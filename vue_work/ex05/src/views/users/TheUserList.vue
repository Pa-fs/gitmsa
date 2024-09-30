<template>
  <div class="pb-10">
    <div class="overlay" :class="{ isModal: isModal }"></div>
    <div class="modal p-5 rounded" :class="{ isView: isModal }">
      <h1 class="text-5xl">USER 수정</h1>
      <div class="bg-slate-500 p-5 w-80 text-white cursor-pointer rounded">
        <div>idx = {{ idx }}</div>
        <div>name = <input type="text" v-model="name" class="text-black" /></div>
        <div>email = {{ email }}</div>
        <div>가입날짜 = {{ wdate }}</div>
      </div>
      <div class="flex space-x-5 justify-center">
        <button
          class="px-4 py-2 bg-blue-500 text-white font-semibold rounded-lg shadow-md hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-300"
          @click="modalUser"
        >
          저장
        </button>
        <button
          class="px-4 py-2 bg-blue-500 text-white font-semibold rounded-lg shadow-md hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-300"
          @click="modalUser"
        >
          취소
        </button>
      </div>
    </div>
    <h1 class="h1-blue">UserList</h1>
    <div class="flex flex-reverse-wrap">
      <div
        @click="modalUser(item)"
        class="bg-slate-500 p-5 w-80 text-white cursor-pointer rounded"
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

const idx = ref();
const name = ref();
const wdate = ref();
const email = ref();

const isModal = ref(false);
const isView = ref(false);
const modalUser = (item) => {
  isModal.value = !isModal.value;
  console.log(item);
  idx.value = item.idx;
  name.value = item.name;
  email.value = item.email;
  wdate.value = item.wdate;
};

// watch(() => {
//     console.log("test");
// }, { immediate: true });
watchEffect(async () => {
  const retValue = await getUsers();
  // JSON.stringify() : object => string으로 변환
  // console.log("retValue = " + JSON.stringify(retValue.data));
  arr.value = retValue.data;
  // console.log(arr.value);
});
</script>

<style scoped>
.h1-blue {
  font-size: 5rem;
  color: blue;
}

.overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 1000;
  background-color: rgb(0, 0, 0, 0.3);
  display: none;
}

.isModal {
  display: block;
}

.modal {
  position: fixed;
  top: 50%;
  left: 50%;
  height: 200px;
  transform: translate(-50%, -50%);
  background-color: white;
  z-index: 1001;
  display: none;
}

.isView {
  display: block;
}
</style>
