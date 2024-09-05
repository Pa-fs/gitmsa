<template>
    <div>
        <h1>MyAA = {{ name }}</h1>
    </div>
</template>
<script>
export default {
    props: {
        name: {
        type: String,
        required: true
        }
    },
    setup (props) {
        // const name = '홍길동';
        console.log(props);
        return {}
    }
}
</script>

<style lang="scss" scoped>

</style>