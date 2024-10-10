<template>
  <div>
    <h1 class="h1-red">FreeBoard Update</h1>
    <div class="p-5">
      <input
        type="text"
        v-model="title"
        placeholder="Enter your title here"
        class="w-full p-3 border border-gray-300 rounded-lg shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent text-gray-700 placeholder-gray-400 bg-white"
      />
      <textarea
        v-model="content"
        placeholder="Enter Content here"
        class="w-full h-40 p-4 border border-gray-300 rounded-lg shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-400 focus:border-transparent resize-none text-gray-700 placeholder-gray-400 bg-white"
      >
      </textarea>
    </div>
    <div class="my-3">
        <input type="file" name="" id="" @change="onFileChange">
    </div>
    <button
      @click="save"
      class="px-4 py-2 bg-blue-500 text-white font-semibold rounded-lg shadow-md hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-300"
    >
      수정
    </button>
  </div>
</template>

<script setup>
import axios from "axios";
import { ref } from "vue";
import { useRoute, useRouter } from "vue-router";

const title = ref("");
const content = ref("");
const regDate = ref("");
const creAuthor = ref("");
const idx = ref(0);
const myfile = ref(null);

const router = useRouter();
const route = useRoute();

const getFreeBoard = () => {
  axios
    .get(`http://localhost:8080/freeboard/view/${route.query.idx}`)
    .then((res) => {
      title.value = res.data.title;
      content.value = res.data.content;
      regDate.value = res.data.regDate;
      creAuthor.value = res.data.creAuthor;
      idx.value = res.data.idx;
    })
    .catch((e) => {
      console.log(e);
      alert(e.response.data.message);
      router.push({ path: "/freeboardSelect" });
    });
};

getFreeBoard();

const save = () => {
  const date = new Date();
  date.setHours(date.getHours() + 9);
  const data = {
    idx: route.query.idx,
    title: title.value,
    content: content.value,
    regDate: date,
  };
  console.log(data);

  const formData = new FormData();
  formData.append("file", myfile.value);
  formData.append(
    "data",
    new Blob([JSON.stringify(data)], {
      type: "application/json",
    })
  );

  axios
    .post("http://localhost:8080/freeboard", formData)
    .then((res) => {
      console.log(res);
      alert("저장하였습니다.");
      router.push({ path: "/freeboardSelect", params: { pageNum: 0 } });
    })
    .catch((e) => {
      console.log(e);
      alert("에러" + e.response.data.message);
    });
};

const onFileChange = (e) => {
    myfile.value = e.target.files[0];
}

</script>

<style lang="scss" scoped></style>
