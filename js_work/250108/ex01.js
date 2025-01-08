console.log("ㅎㅎㅎ")

// 1 
// false 값
const f1 = undefined; // 선언만 되어져있고 값이 할당 되지 않았을 때
const f2 = null; // 선언되어져있고 값이 null로 선언되어 있을 때
const f3 = 0;
const f4 = -0;
const f5 = NaN; // 숫자로 표기할 수 없음 Not a Number
const f6 = "";

const result = f1 && "result";
console.log(result);

// 2
// true 값

class A {
    a;
    constructor(a) {
      this.a = A;  
    }
}

const t1 = "result";
const t2 = 123;
const t3 = [];
const t4 = {a : 20}; // json
const t5 = () => {};
const t6 = new A(50);
const t7 = {}; // 빈 객체도 true
const t8 = () => {
    function a() {
        console.log("함수")
    }
}

const result2 = t1 && "result22222";
console.log(result2);
console.log(t4.a)

function printName(test) {
    if(test) {
        console.log(`${test} 출력 된다`)
    } else {
        console.log(`${test} 출력 안된다`)
    }
}

printName(f5)
printName(t6)

function aa (a) {
    if(a) {
        console.log(a);
    }
}

aa({a : 10, b: 20});