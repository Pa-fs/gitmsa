<template>
    <div>
        <h1>TheInsert</h1>
        <button @click="userSend">전송</button>
    </div>
</template>

<script>
export default {
    setup () {
        const mydata = {
            "name": "Test",
            "age": 100,
            "email": "bbb@naver.com",
            "password": "password",
            "wdate": new Date()
        }
        const userSend = () => {
            console.log("일로오나");
            fetch('http://localhost:8080/user/insert', {
                method: "POST", 
                headers: {'Content-Type':'application/json'}, 
                body: JSON.stringify(mydata)
            })
            .then(res => {
                console.log(res);
            })
        }
        return {userSend}
    }
}
</script>

<style lang="scss" scoped>

</style>