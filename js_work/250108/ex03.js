const aa = {
    a:'a변수',
    b:'b변수',
    c:'c변수'
}

const {a,b,c} = aa;

console.log(`a = ${a}`)
console.log(`b = ${b}`)
console.log(`c = ${c}`)


// javascript fetch -> react -> Node -> typescript -> next.js axios (X) fetch (O)
// 문자열로 만드는 함수 JSON.stringify();
// 문자열을 다시 객체로 만드는 함수 JSON.parse();
const aaa = JSON.stringify(aa);
console.log(aaa)
console.log(JSON.parse(aaa))