<template>
  <!-- 주문, 결제 각각 따로 진행됨 
    주문하기 클릭 시 번호가 채번되고 주문 페이지(결제 준비)로 이동한다
    따라서 주문번호가 결제 시 동일하다
    1. 화면 단에서 사용자가 주문 페이지에서 새로고침 시 채번 재요청을 막는다
    2. 화면 이동을 하면 주문취소를 백으로 요청해야 한다 (비동기, 기다릴 필요는 없다) / 백엔드는 주문 취소 트랜잭션 실행
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
    window.location.reload()
  }
})

const createPurchase = async () => {
  const res = await axios.post(`http://localhost:8080/purchase/create`, {
    memberId: 1
  })
  if (res.status == 200) {
    console.log(res.data)
  } else {
    console.log('failed create order')
  }
}

const connectSSE = () => {
  const sse = new EventSource('http://localhost:8080/payment/completed/connect')

  sse.addEventListener('connect', (e) => {
    const { data: receivedConnectData } = e
    console.log('connect event data: ', receivedConnectData)
  })

  sse.addEventListener('paidCompleted', async (event) => {
    console.log('SSE event received:', event.data)
    purchaseStatus.value = event.data
    console.log('purchaseStatus updated:', purchaseStatus.value)
    await nextTick()
    console.log('nextTick completed, purchaseStatus:', purchaseStatus.value)
  })
}

const requestPay = () => {
  const IMP = window.IMP
  IMP.init('${my_key}')

  IMP.request_pay(
    {
      pg: 'html5_inicis',
      pay_method: 'card',
      merchant_uid: `IMP${Date.now()}`,
      name: '향수 1',
      amount: 1,
      buyer_email: email.value,
      buyer_name: '김태영',
      buyer_tel: '010-1234-5678',
      buyer_addr: '대구광역시 중구',
      buyer_postcode: '123-456'
    },
    async (rsp) => {
      if (rsp.success) {
        const form = new FormData()
        form.append('impuid', rsp.imp_uid)
        form.append('merchantuid', rsp.merchant_uid)
        form.append('paidamount', rsp.paid_amount)
        form.append('applynum', rsp.apply_num)
        form.append('email', email.value)
        form.append('purchaseId', purchaseId)

        try {
          // SSE 연결을 초기화합니다.
          connectSSE()
          // purchaseStatus.value = 'PAID'

          // 결제 정보를 서버로 전송합니다.
          await axios.post('http://localhost:8080/payment/create', form)
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
