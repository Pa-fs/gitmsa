<template>
  <div>
    <h1 class="h1-red">FreeBoard Input</h1>
    <div class="p-5">
      <input
        type="text"
        v-model="title"
        placeholder="Enter your title here"
        class="w-full p-3 border border-gray-300 rounded-lg shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent text-gray-700 placeholder-gray-400 bg-white"
      />
      <textarea
        v-model="content"
        class="w-full h-40 p-4 border border-gray-300 rounded-lg shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-400 focus:border-transparent resize-none text-gray-700 placeholder-gray-400 bg-white"
      ></textarea>
      <div class="my-3">
        <input type="file" name="" id="" @change="onFileChange"/>
      </div>
    </div>
    <button
      @click="save"
      class="px-4 py-2 bg-blue-500 text-white font-semibold rounded-lg shadow-md hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-300"
    >
      저장
    </button>
  </div>
</template>

<script setup>
import axios from "axios";
import { ref } from "vue";
import { useRouter } from "vue-router";

const title = ref("");
const content = ref("");
// const regdate = ref('초기값');
// const creAuthor = ref('초기값');
// const idx = route.params.idx;
const myfile = ref(null);

const router = useRouter();

const onFileChange = (e) => {
    myfile.value = e.target.files[0];
};

const save = () => {
  const data = {
    title: title.value,
    content: content.value,
  };
  console.log(data);

  const formData = new FormData();
  formData.append(
    "data",
    new Blob([JSON.stringify(data)], {
      type: "application/json",
    })
  );

  formData.append("file", myfile.value);

  console.log(formData + " 테스트");

  axios
    .post("http://localhost:8080/freeboard", formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
    })
    .then((res) => {
      console.log(res);
      alert("저장하였습니다.");
      router.push({
        path: "/freeboardSelect",
        params: { aa: 10, bb: "안녕하세요" },
      });
    })
    .catch((e) => {
      console.log(e);
      alert("에러" + e.response.data.message);
    });
};

// const getFreeBoard = (pageNum) => {
//     if(pageNum == undefined) pageNum = 0;

//     axios.get(`http://localhost:8080/freeboard/view/${route.params.idx}`)
//     .then(res => {
//         console.log(res.data.totalpages);
//         arr.value = res.data.list;
//         totalPages.value = res.data.totalPages;
//     })
//     .catch(e => {
//         console.log(e);
//     })
// }
</script>

<style lang="scss" scoped></style>
