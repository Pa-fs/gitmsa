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
            <tbody v-for="item in arr" :key="item.idx">
                <td class="border text-center">{{ item.idx }}</td>
                <td class="border text-center">{{ item.title }}</td>
                <td class="border text-center">{{ item.creAuthor }}</td>
                <td class="border text-center">{{ item.regDate.substring(0, 10) }}</td>
                <td class="border text-center">{{ item.viewCount }}</td>
            </tbody>
        </table>
        </div>
    </div>
</template>

<script setup>
import axios from 'axios';
import { ref } from 'vue';
import { useRoute } from 'vue-router';

const route = useRoute();
let arr = ref('');
console.log("route.params.aa = " + route.params.aa);
console.log("route.params.bb = " + route.params.bb);

axios.get("http://localhost:8080/freeboard")
.then(res => {
    console.log(res.data);
    arr.value = res.data;
})
.catch(e => {
    console.log(e);
})
</script>

<style lang="scss" scoped>

</style>