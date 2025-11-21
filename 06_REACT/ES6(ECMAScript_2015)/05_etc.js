//1. 템플릿 리터럴
// 문자열과 변수 결합 시 편리하고 여러줄의 문자열도 간단하게 처리가 가능하다.
const userName = "Jeameon";
console.log(`안녕하세요. ${userName}님!`);

const multiStr = `이 변수는
여러줄로 작성된
문자열을 가지고 있습니다.`;
console.log(multiStr);

// 2. 구조 분해 할당 
// 객체에서 필요한 값을 바로 변수로 추출할 때 사용한다.
const userInfo = {
    name : "Jeameon",
    age : 22,
    email : "jeameon@gmail.com",
    job : "developer"
}

// const { name, age } = userInfo;
// console.log(name, age);

// 변수 이름을 변경해서 추출하고 싶을 때 사용한다. 
const { name, job:userJob} = userInfo;

function myInfo({name, age}){
    console.log(`이름 : ${name}, 나이 : ${age}`);
}

myInfo(userInfo);

// 3. 배열 구조 분해할당
// 배열 요소를 순서대로 변수에 담아준다
const numbers = [10, 20, 30];
const [num1, num2]= numbers;
console.log(num1, num2);

// 필요 없는 값은 생략이 가능하다.
const [,, num] = numbers;
console.log(num);

// react에서는 state라는 값을 생성할 때 배열에 값과 해당 값을 변경하는 함수가 순차적으로 전달된다.
// userState() return [값, 값을 변경할 때 사용하는 setter]
// const [count, setCount] = useState(0);

// 4. 스프레드 연산자
// 배열/객체를 복사, 병합, 수정, 나머지 값을 처리 등 등 ... 
// 

let user = {
    name : "Jeameon",
    age : 22,
    email : "jeameon@gmail.com",
    job : "developer"
}

// user.job = "student"; // 이렇게 변경 시 실제 객체의 내부 값만 변경이 되기 때문에 객체 자체의 주소값이 변경되지 않아 react에서 값이 변경된지 모른다. >> 불변성을 지키지 못한다.
console.log(user);

user = {
    ...user,
    job : "student"
}

console.log(user);