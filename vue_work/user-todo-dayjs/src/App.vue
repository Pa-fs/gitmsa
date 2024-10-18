<template>
  <header class="">
    <RouterLink to="/">HOME</RouterLink>
    <RouterLink to="/month">MONTH</RouterLink>
    <RouterLink to="/about">ABOUT</RouterLink>
    <RouterLink to="/login">login</RouterLink>
    <RouterView />
  </header>
</template>

<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<style lang="scss" scoped></style>
