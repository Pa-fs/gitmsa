<template>
    <div>
        <h1 class="h1-red">TheFreeBoardView</h1>
        <div class="p-5">
            <div class="border border-b-slate-400 rounded p-5">
                <h1 class="font-bold">글제목 {{ title }}</h1>
                <hr class="my-3"/>
                <h1 class="font-bold">글내용</h1>
                <p class="h-64">{{  content }}</p>
                <h1>작성일자 {{ regdate }}</h1>
                <h1>작성자 {{ creAuthor }}</h1>
            </div>
        </div>
        <div v-for="item in list" v-bind:key="item">
            <img :src="`http://localhost:8080/file/download/${item.name}`" width="300" alt="" class="p-5">
            {{ item.name }}
        </div>
        <div class="flex justify-between mt-5">
            <button class="px-4 py-2 bg-blue-500 text-white font-semibold rounded-lg shadow-md hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-300"
            @click="pageMove(idx)">
            수정</button>
            <button class="px-4 py-2 bg-blue-500 text-white font-semibold rounded-lg shadow-md hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-300"
            @click="doDelete(idx)">
            삭제</button>
        </div>
    </div>
</template>

<script setup>
import { freeboardDelete, getFreeBoardView } from '@/api/freeboardApi';
import axios from 'axios';
import { ref, watchEffect } from 'vue';
import { useRoute, useRouter } from 'vue-router';

const route = useRoute();
const router = useRouter();
const title = ref('초기값');
const content = ref('초기값');
const regdate = ref('초기값');
const creAuthor = ref('초기값');
const list = ref([]);
let idx = route.params.idx;

const doDelete = async (idx) => {
    const res = await freeboardDelete(idx);
    if(res.status == 200) {
        alert('삭제되었습니다');
    } else {
        alert('삭제 실패');
    }
    router.push({path: '/freeboardSelect'});
}
// const doDelete = (idx) => {
//     console.log(idx);
//     axios.delete(`http://localhost:8080/freeboard/delete/${idx}`)
//     .then(res => {
//         console.log(res);


//         if(res.status == '200') {
//             alert("해당 게시글이 삭제되었습니다.");
//             router.push({path: '/freeboardSelect'});
//         }
//     })
//     .catch(e => {
//         console.log(e);
//     })
// }

const pageMove = (idx) => {
    router.push({ path: '/freeboardUpdate', query: {idx}});
}

watchEffect(async () => {
    const res = await getFreeBoardView(route.params.idx);
    if(res.status == 200) {
        title.value = res.data.title;
        content.value = res.data.content;
        regdate.value = res.data.regdate;
        creAuthor.value = res.data.creAuthor;
        idx = res.data.idx;
        list.value = res.data.list;
    } else {
        alert(res.response.data.message);
        router.push({path:'/freeboardSelect'})
    }
    // axios.get(`http://localhost:8080/freeboard/view/${idx}`)
    // .then(res => {
    //     title.value = res.data.title;
    //     content.value = res.data.content;
    //     regdate.value = res.data.regdate;
    //     creAuthor.value = res.data.creAuthor;
    //     idx = res.data.idx;
    //     list.value = res.data.list;
    // })
    // .catch(e => {
    //     console.log(e);
    //     alert(e.response.data.message);
    //     router.push({path:'/freeboardSelect'})
    // })
});

// getFreeBoard();

</script>

<style lang="scss" scoped>

</style>