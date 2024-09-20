<template>
    <div>
        <h1 class="h1-red">FreeBoardList</h1>
        <div class="px-5">
        <table class="border border-bg-gray-500 w-full">
            <thead>
                <tr>
                    <th class="border">idx</th>
                    <th class="border">title</th>
                    <th class="border">author</th>
                    <th class="border">regdate</th>
                    <th class="border">viewcount</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="item in arr" :key="item.idx"  
                class="cursor-pointer hover:bg-green-500" 
                @click="viewPage(item.idx)">
                    <td class="border text-center text-lg p-1">{{ item.idx }}</td>
                    <td class="border text-center text-lg p-1">{{ item.title }}</td>
                    <td class="border text-center text-lg p-1">{{ item.creAuthor }}</td>
                    <td class="border text-center text-lg p-1">{{ item.regDate }}</td>
                    <td class="border text-center text-lg p-1">{{ item.viewCount }}</td>
                </tr>
            </tbody>
        </table>
        </div>
        <div class="flex justify-center mt-5">
            <ul class="flex space-x-2">
                <li 
                    class="cursor-pointer p-3"
                    v-for="num in totalPages" v-bind:key="num" @click="setPageNum(num - 1)">
                    {{ num }}
                </li>
            </ul>
        </div>
    </div>
</template>

<script setup>
import axios from 'axios';
import { ref } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();
let arr = ref('');
const totalPages = ref(10);
const pageNum = ref(0);

const setPageNum = (num) => {
    pageNum.value = num;
    getFreeBoard(num);
}

// board detail page
const viewPage = (idx) => {
    console.log(idx);
    router.push({path:`/freeboardView/${idx}`, params:{'idx': idx}});
}

const getFreeBoard = (pageNum) => {
    if(pageNum == undefined) pageNum = 0;

    axios.get(`http://localhost:8080/freeboard?pageNum=${pageNum}`)
    .then(res => {
        console.log(res.data.totalpages);
        arr.value = res.data.list;
        totalPages.value = res.data.totalPages;
    })
    .catch(e => {
        console.log(e);
    })
}

getFreeBoard();

</script>

<style lang="scss" scoped>

</style>