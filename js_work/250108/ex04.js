const person = {
    age: 20,
    name: "홍길동",
    gender: "남자"
}

function func({}) {
    console.log(person)
}

func(person)

const func2 = ( { age, name, gender } ) => {
    console.log(`나이는 ${age}`)
    console.log(`이름은 ${name}`)
    console.log(`성별은 ${gender}`)
}

func2(person)
