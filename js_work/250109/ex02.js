const arr1 = [
    {name:"홍길동", age:20},
    {name:"김길동", age:15},
    {name:"이길동", age:30},
];

arr1.forEach(obj => {
    console.log(obj)
})

console.log("\n")

const arr2 = [...arr1, {name : "박길동", age:40}]
console.log(arr2)

const findObj = arr1.find(obj => {
    if( obj.name == "홍길동" && obj.age === 20) {
        return obj;
    }
})

console.log(findObj)

const arr3 = [1,2,3,4];
const findIndex = arr3.findIndex(value => {
    return value === 2;
})

console.log(findIndex)

const findIndex2 = arr3.findIndex(value => {
    return value === 4;
})

console.log(findIndex2)