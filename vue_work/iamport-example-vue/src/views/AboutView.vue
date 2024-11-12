<template>
  <!-- 주문, 결제 각각 따로 진행됨 
    장바구니에서 주문하기 클릭 시 번호가 채번되고 총 주문금액 1차 검증 후, 주문 페이지(결제 준비)로 이동한다
    따라서 주문번호가 결제 시 동일하다
    - 화면 단에서 사용자가 주문 페이지에서 새로고침 시 채번 재요청을 막는다 (프론트 단에서 막아야함)
    - 화면 이동을 하면 주문취소를 백으로 요청해야 한다 (비동기, 기다릴 필요는 없다) / 백엔드는 주문 취소 트랜잭션 실행
    
    1. 주문 상세 페이지가 로드 되면 총 주문금액 2차 사전검증을 한다. (사전검증 데이터 DB저장) <- XSS 막기
    2. 결제하기 클릭 후 사용자가 결제요청처리를 완료하면 2차 사전검증 데이터와 함께 사후검증한다
    3. 2번까지 통과하면 결제완료정보를 우리 시스템에 등록한다
    4. 해당 사용자의 장바구니 데이터를 지운다
    4-1. 주문결제 완료 후 배송지 주소나 회원정보가 기존 주문결제자와 다를 수 있기에 로직 판단이 필요하다
    5. 배송서비스 시작과 알림을 보내야하기 때문에 카프카를 통해 메시지를 전송한다
  -->

  <div>
    <button @click="createPurchase()">주문하기</button>
    <button @click="requestPay()">결제하기</button>
  </div>
</template>

<script setup>
import { ref, watchEffect, nextTick } from 'vue'
import axios from 'axios'

const purchaseId = 1
const email = ref('fkam12@naver.com')
const purchaseStatus = ref(null)
console.log('Initial purchaseStatus:', purchaseStatus.value)

watchEffect(() => {
  console.log('Watch triggered:', purchaseStatus.value)
  if (purchaseStatus.value) {
    console.log('PAID 상태 감지, 이벤트 발생')
    alert('결제가 완료되었습니다.')
    // SSE 연결을 초기화합니다.
    connectSSE()
    // window.location.reload()
  }
})

const purchaseProducts = [
  {
    productId: 1, // 실제 제품 ID
    quantity: 1 // 주문 수량
  },
  {
    productId: 9, // 다른 제품 ID
    quantity: 1
  },
  {
    productId: 17,
    quantity: 1
  }
  // 필요한 만큼 추가
]

// 총액 계산 (각 제품 가격을 미리 알고 있다고 가정)
const productsInfo = {
  1: 1, // productId: 가격
  9: 1,
  17: 1
}

const totalPrice = purchaseProducts.reduce((sum, product) => {
  return sum + productsInfo[product.productId] * product.quantity
}, 0)

const merchant_uid = `IMP${Date.now()}`
const totalAmount = totalPrice

const createPurchase = async () => {
  const res = await axios.post(`http://localhost:8080/api/purchase/create`, {
    purchaseProductDtos: purchaseProducts,
    totalPrice: totalPrice
  })
  if (res.status == 200) {
    console.log(res.data)
  } else {
    console.log('failed create order')
  }

  const data = {
    merchant_uid: merchant_uid,
    amount: totalAmount,
    purchaseId: purchaseId
  }

  // 주문 상세 페이지 로드 완료되면 아래 호출
  try {
    const res = await axios.post('http://localhost:8080/api/payment/prepare', data)

    if (res.status == 200) {
      console.log('사전검증 성공')
    } else {
      console.log('사전검증 실패')
    }
  } catch (error) {
    console.error('Payment prepare failed', error)
  }
}

const connectSSE = () => {
  const sse = new EventSource('http://localhost:8080/api/notification/payment/completed/subscriber')
  console.log('start sse')
  console.log(sse)

  sse.addEventListener('paymentCompletedEvent', async (event) => {
    console.log('SSE event received:', event.data)
    const data = await JSON.parse(event.data)
    purchaseStatus.value = event.data.status
    console.log('Message:', data.message)
    console.log('Order ID:', data.orderId)
    console.log('Total Amount:', data.totalAmount)
  })

  sse.addEventListener('error', (event) => {
    if (event.readyState === EventSource.CLOSED) {
      console.error('SSE connection was closed.')
    } else {
      console.error('Error occurred:', event)
    }
  })
}

const products = [
  {
    name: '향수 1',
    amount: 1 // 가격을 실제 가격으로 설정
  },
  {
    name: '향수 2',
    amount: 1
  },
  {
    name: '향수 3',
    amount: 1
  }
  // 추가 상품을 여기에 더하세요
]

const requestPay = async () => {
  const IMP = window.IMP
  IMP.init('imp25637745')

  IMP.request_pay(
    {
      pg: 'html5_inicis',
      pay_method: 'card',
      merchant_uid: merchant_uid,
      name: products.map((product) => product.name).join(', '),
      amount: totalAmount,
      buyer_email: email.value,
      buyer_name: '김태영',
      buyer_tel: '010-1234-5678',
      buyer_addr: '대구광역시 중구',
      buyer_postcode: '123-456'
    },
    async (rsp) => {
      if (rsp.success) {
        const data = {
          imp_uid: rsp.imp_uid,
          merchant_uid: rsp.merchant_uid,
          paid_amount: rsp.paid_amount,
          apply_num: rsp.apply_num,
          email: email.value,
          purchaseId: purchaseId
        }
        // form.append('imp_uid', rsp.imp_uid)
        // form.append('merchant_uid', rsp.merchant_uid)
        // form.append('paid_amount', rsp.paid_amount)
        // form.append('apply_num', rsp.apply_num)
        // form.append('email', email.value)
        // form.append('purchaseId', purchaseId)

        try {
          // 사후 검증
          await axios
            .post('http://localhost:8080/api/payment/validate', data, {
              headers: {
                'Content-Type': 'application/json'
              }
            })
            .then(async (res) => {
              console.log(res.data)

              const mesg = '결제가 완료되었습니다.'
              const buyerInfo = {
                merchant_uid: rsp.merchant_uid,
                imp_uid: rsp.imp_uid,
                memberId: 1, // JWT로 접근해야함
                buyerEmail: rsp.buyer_email,
                pay_method: rsp.pay_method,
                embPgProvider: rsp.emb_pg_provider,
                pgProvider: rsp.pg_provider,
                paidAt: rsp.paid_at,
                status: rsp.status,
                amount: rsp.paid_amount // 총 결제 금액
                // phone: rsp.buyer_tel,
                // addr: rsp.buyer_addr,
                // post: rsp.buyer_postcode
              }

              console.log(buyerInfo)

              // 결제 정보 저장
              await axios
                .post('http://localhost:8080/api/payment/save-user-info', buyerInfo, {
                  headers: {
                    'Content-Type': 'application/json'
                  }
                })
                .then((res) => {
                  console.log(res.data)
                })
                .catch((e) => {
                  console.log(e)
                })

              const purchaseInfo = {
                imp_uid: rsp.imp_uid,
                merchant_uid: rsp.merchant_uid,
                buyerEmail: rsp.buyer_email,
                buyerName: rsp.buyer_name,
                pay_method: rsp.pay_method,
                amount: rsp.paid_amount,
                buyerPhone: rsp.buyer_tel,
                buyerAddr: rsp.buyer_addr,
                buyerPostcode: rsp.buyer_postcode,
                cartId: 1, // 카트 아이디
                purchaseProductDtos: purchaseProducts // 제품IDs와 수량들
              }

              // 주문 정보 저장
              await axios
                .post('http://localhost:8080/api/payment/save-purchase-info', purchaseInfo, {
                  headers: {
                    'Content-Type': 'application/json'
                  }
                })
                .then((res) => {
                  console.log(res.data)
                  purchaseStatus.value = 'PAID'
                  // window.location.href = 'purchaseCompleted?merchant_uid=' + res.data
                })
                .catch((e) => {
                  console.log(e)
                })
            })
            .catch((e) => {
              console.log(e)
            })
        } catch (error) {
          console.error('Payment processing failed', error)
        }
      } else {
        alert('결제에 실패하였습니다.')
      }
    }
  )
}
</script>
