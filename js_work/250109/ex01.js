const arr1 = [1,2,3];

for(let i = 0; i < arr1.length; i++) {
    console.log(arr1[i]);
}

for(let i of arr1) {
    console.log(i);
}

const arr2 = {a:10, b:20};

for (let i in arr2) {
    console.log(i);
    console.log(arr2[i]);
}

if("a" in arr2) {
    console.log("a가 있다")
}