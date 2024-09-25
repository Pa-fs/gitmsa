<template>
    <div class="p-5 bg-slate-500 text-white text-3xl">
        <div class="flex space-x-5">
            <div><RouterLink to="/">Home</RouterLink></div>
            <div><RouterLink to="/join">JOIN</RouterLink></div>
            <div><RouterLink to="/about">ABOUT</RouterLink></div>
            <div class="group relative">
                <RouterLink to="/freeboardSelect">Freeboard</RouterLink>
                <div class="opacity-0
                group-hover:opacity-100
                transition absolute 
                bg-slate-500 
                p-5 top-8
                -left-5
                rounded">
                    <div><RouterLink to="/freeboardSelect">FreeboardList</RouterLink></div>
                    <div><RouterLink to="/freeboardInput">FreeboardInput</RouterLink></div>
                    <div><RouterLink to="/fileupload">Fileupload</RouterLink></div>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { RouterLink } from 'vue-router';

</script>

<style lang="scss" scoped>

</style>