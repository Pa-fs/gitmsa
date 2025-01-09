setTimeout(() => {
    console.log("test")
}, 3000)

const aa = setInterval(() => {
    console.log("2초마다")
}, 2000)

// setTimeout이 메모리에 저장되기 때문에 다른 페이지에서도 계속 동작


setTimeout(() => {
    clearInterval(aa)
}, 8000);

console.log("출력됩니다")