<template>
  <main class="">
    <h1>MonthView</h1>

    <h1 class="text-center text-3xl">
      <button @click="subMonth()">&lt;&lt;</button>
      {{ now.format('YYYY년 MM월') }}
      <button @click="addMonth()">&gt;&gt;</button>
    </h1>
    <div class="grid grid-cols-7 gap-2 text-center text-gray-600">
      <div class="p-2 px-4 text-red-600">일</div>
      <div class="p-2 px-4">월</div>
      <div class="p-2 px-4">화</div>
      <div class="p-2 px-4">수</div>
      <div class="p-2 px-4">목</div>
      <div class="p-2 px-4">금</div>
      <div class="p-2 px-4">토</div>
    </div>
    <!-- <div v-for="column in columns" :key="column.format('YYYY-MM-DD')" class="">
      {{ column.get('date') }}
    </div> -->
    <div class="grid grid-cols-7 gap-2" v-for="group in groupColumns" :key="group.length">
      <div
        @click="selectDateFn(column)"
        v-for="(column, index) in group"
        :key="column.format('YYYY-MM-DD')"
        class="border border-gray-400 text-center p-2 cursor-pointer"
        :class="{
          'text-red-600': index % 7 == 0,
          'text-blue-600': index % 7 == 6,
          'opacity-20': !column.isSame(now, 'month')
        }"
      >
        <div @click="dateClick">{{ column.get('date') }}</div>
      </div>
    </div>
  </main>

  <div class="flex justify-center my-5" :class="{ hidden: !selectDate }">
    <div class="bg-white shadow-lg rounded-lg p-6 max-w-sm w-full">
      <h2 class="text-2xl font-bold text-center mb-4">할일 등록</h2>

      <form>
        <div class="mb-4">
          <label for="task" class="block text-gray-700 text-sm font-bold mb-2">할일 제목</label>
          <input
            v-model="title"
            type="text"
            id="task"
            placeholder="할일 제목을 입력하세요"
            class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            required
          />
        </div>

        <div class="mb-4">
          <label for="description" class="block text-gray-700 text-sm font-bold mb-2"
            >상세 설명</label
          >
          <textarea
            v-model="content"
            id="description"
            rows="4"
            placeholder="상세 설명을 입력하세요"
            class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
          ></textarea>
        </div>

        <div class="mb-6">
          <label for="due-date" class="block text-gray-700 text-sm font-bold mb-2">마감일</label>
          <input
            v-model="selectDate"
            type="date"
            id="due-date"
            class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
          />
        </div>

        <div class="flex items-center justify-center">
          <button
            type="submit"
            class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
          >
            등록하기
          </button>
        </div>
      </form>
    </div>
  </div>
</template>

<script setup>
import dayjs from 'dayjs'
import utc from 'dayjs/plugin/utc'
import timezone from 'dayjs/plugin/timezone'
import { ref } from 'vue'
import { watch } from 'vue'

dayjs.extend(utc)
dayjs.extend(timezone)

// const now = dayjs().tz('Asia/Seoul')
const now = ref(dayjs())

// groupColumns ([29,30,1,2,3,4,5,],[6,7,8,9,10,11,12],[13,14,15,16,17,18,19], ...)
const groupColumns = ref([])
const columns = ref([])

const selectDate = ref(null)
const title = ref('')
const content = ref('')

const doSave = () => {
  console.log('save', title.value, content.vvalue, selectDate.value)
}

const subMonth = () => {
  now.value = dayjs(now.value).subtract(1, 'month')
  console.log(now.value.format('YYYY-MM-DD'))
}

const addMonth = () => {
  now.value = dayjs(now.value).add(1, 'month')
  console.log(now.value.format('YYYY-MM-DD'))
}

const selectDateFn = (date) => {
  console.log('dateClick', dayjs().format('YYYY-MM-DD'))
  selectDate.value = dayjs(date).format('YYYY-MM-DD')
}

watch(
  now,
  (newValue) => {
    groupColumns.value = []
    columns.value = []
    const startday = dayjs(now.value).startOf('month')
    const lastday = dayjs(now.value).endOf('month')

    const startdayOfWeek = startday.get('day')
    console.log('startdayOfWeek:', startdayOfWeek)

    const lastdayOfWeek = lastday.get('day')
    console.log('lastdayOfWeek:', lastdayOfWeek)

    // 저번달에 날짜 추가
    for (let i = 1; i <= startdayOfWeek; i++) {
      columns.value.unshift(dayjs(startday).subtract(i, 'day'))
    }

    // 현재 달력에 날짜 추가
    for (let i = 0; i < lastday.get('date'); i++) {
      columns.value.push(dayjs(startday).add(i, 'day'))
    }

    // 다음달에 날짜 추가
    for (let i = 1; i <= 6 - lastdayOfWeek; i++) {
      columns.value.push(dayjs(lastday).add(i, 'day'))
    }
    console.log('slice : ' + columns.value.slice(0, 7))
    for (let i = 0; i < 35; i += 7) {
      groupColumns.value.push(columns.value.slice(i, i + 7))
    }
  },
  {
    immediate: true, // 현재 페이지 처음 로딩될 때도 실행
    deep: true // 안에 값이 객체이면 객체 안에 변수도 변경될 때 watch안에 있는 함수 실행
  }
)
</script>

<style lang="scss" scoped></style>
