const doA = () => {
    const promise = new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve('잘됨')
            // reject("못됨")
        }, 3000)
    });
    return promise
}



// console.log(promise)

doA()
// promise
.then((result) => {
    console.log(result)
})
.catch(error => {
    console.log(error)
});
