<template>
  <div>
    <TheNav></TheNav>
    <RouterView></RouterView>
  </div>
</template>

<script>
import TheNav from './views/TheNav.vue';
import { RouterView } from 'vue-router';
export default {
  components: {
    RouterView,
    TheNav
  },
  setup() {


    return { RouterView, TheNav }
  }
}
</script>

<style lang="scss" scoped></style>