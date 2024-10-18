<template>
  <div>
    <h1 class="text-5xl">Hello vue</h1>
    <h1 class="text-5xl">{{ now.format('YYYY/MM/DD') }}</h1>
    <h1 class="text-5xl">{{ now.get('month') + 1 }}월</h1>
    <h1 class="text-5xl">{{ now.subtract(1, 'month').format('YYYY/MM/DD') }}</h1>
    <h1 class="text-5xl">{{ now.subtract(1, 'date').format('YYYY/MM/DD') }}</h1>
    <h1 class="text-5xl">{{ now.subtract(1, 'year').format('YYYY/MM/DD') }}</h1>

    <h1 class="text-5xl">{{ now.add(3, 'month').format('YYYY/MM/DD') }}</h1>
    <h1 class="text-5xl">{{ now.add(2, 'date').format('YYYY/MM/DD') }}</h1>
    <h1 class="text-5xl">{{ now.add(2, 'year').format('YYYY/MM/DD') }}</h1>

    <hr />
    <h1 class="text-3xl">첫 날 {{ now.tz('Asia/Seoul').startOf('month').format('YYYY-MM-DD') }}</h1>
    <h1 class="text-3xl">마지막날 {{ now.endOf('month').format('YYYY/MM/DD') }}</h1>
  </div>
</template>

<script setup>
import dayjs from 'dayjs'
import utc from 'dayjs/plugin/utc'
import timezone from 'dayjs/plugin/timezone'
import { ref } from 'vue'

dayjs.extend(utc)
dayjs.extend(timezone)

const now = dayjs().tz('Asia/Seoul')
// const now = ref(dayjs())

const date = new Date()
console.log(date)

console.log(now)
console.log(now.format('YYYY-MM-DD HH:mm:ss'))
console.log(now.format('YYYY년MM월DD일 HH시mm분ss초'))
console.log(now.format('MM-DD HH:mm:ss'))

const firstDay = dayjs().startOf('month')
const lastDay = dayjs().endOf('month')

// 0 일, 1 월, 2 화, 3 수, 4 목, 5 금, 6 토
console.log(dayjs().day())
console.log(firstDay.day())
console.log(lastDay.day())

// 10월 17 -> 9월 17
const beforeMonth = dayjs().subtract(1, 'month').format('YYYY/MM/DD')
// 9월 마지막날
const sepLastDay = dayjs(beforeMonth).endOf('month').endOf('month')
console.log('sepLasit = ' + sepLastDay.format('YYYY/MM/DD'))

// 9월달과 현재달의 달을 비교
console.log(
  "dayjs().isSame(isSame(sepLastDay, 'month') = " +
    dayjs().isSame(dayjs().startOf('month'), 'month')
)
console.log(
  "dayjs().isSame(isSame(sepLastDay, 'month') = " + dayjs().isSame(dayjs().endOf('month'), 'month')
)
</script>

<style lang="scss" scoped></style>
