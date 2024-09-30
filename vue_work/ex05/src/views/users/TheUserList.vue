<template>
  <div class="pb-10">
    <div class="overlay"></div>
    <h1 class="h1-blue">UserList</h1>
    <div class="flex flex-reverse-wrap">
      <div
        @click="modalUser"
        class="
        bg-slate-500 
        p-5 
        w-80
        text-white 
        cursor-pointer
        rounded"
        v-for="item in arr"
        :key="item.idx"
      >
        <div>idx = {{ item.idx }}</div>
        <div>name = {{ item.name }}</div>
        <div>email = {{ item.email }}</div>
        <div>가입날짜 = {{ item.wdate }}</div>
        <div>작성한 글 = {{ item.list.length }}</div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, watch, watchEffect } from "vue";
import { getUsers } from "@/api/useApi.js";

const arr = ref([]);

const modalUser = () => {
  console.log("test");
};

// watch(() => {
//     console.log("test");
// }, { immediate: true });
watchEffect(async () => {
  const retValue = await getUsers();
  // JSON.stringify() : object => string으로 변환
  // console.log("retValue = " + JSON.stringify(retValue.data));
  arr.value = retValue.data;
  console.log(arr.value);
});
</script>

<style scoped>
.h1-blue {
  font-size: 5rem;
  color: blue;
}

.overlay{
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 1000;
  background-color: rgb(0,0,0, 0.5);
  /* display: none; */
}
</style>
