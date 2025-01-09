// 배열 map -> 반환되는 값이 있는 경우, forEach -> 반환되는 값이 없는 경우

const arr1 = [1,2,3];

const mapArr1 = arr1.map(item => {
    console.log("map 함수")
    return item * 3;
});
const forEachArr1 = arr1.forEach(item => {
    console.log(item * 3)
});

console.log(mapArr1)

console.log(forEachArr1)