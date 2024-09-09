<template>
    <div>
      <h1>안녕하세요</h1>
      <h2>카운트: {{ count }}</h2>
      <button @click="addCount">카운트 증가</button>
    </div>
  </template>
  
  <script>
  import { ref } from 'vue';
  
  export default {
    setup() {
      const count = ref(0);
      const addCount = () => {
        count.value = count.value + 1;
      }
  
      return { count, addCount }
    }
  }
  </script>
  
  <style lang="scss" scoped></style>