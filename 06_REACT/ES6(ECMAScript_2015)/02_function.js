// 함수 표현식

// 1. 기본 함수
function hello(){
    console.log("Hello, react");
}

hello();

// js에서는 함수도 하나의 값(변수)로 취급된다.
let _hello = hello;
console.log(_hello);
_hello();

// 2. 익명함수
const printMsg = function(){
    console.log("this is a function");
}

printMsg();

// 기본 함수는 호이스팅이 된다.
tmp(); 
function tmp() {
    console.log("나는함함함수다");
}

// tmp2();
// let tmp2 = function(){
//     console.log("나도 익명함수다");
// }

// 함수의 기본 매개변수 
function greet(name="방문자", msg="안녕하세요"){
    console.log(`${name}님, ${msg}`);
}

// JavaScrip의 함수는 이름으로만 함수를 판단한다.
greet("Jeameon", "Hello");
greet();
greet("Jeoeon");

greet(null); // 개발자가 명시적으로 값을 전달하지 않을 때 기본 값을 사용한다.
greet(undefined); // 시스템이 정해준 빈값(개발자가 선언 후 사용하지 않은 값)

function greet2(msg, name="방문자"){
    console.log(`${name}님, ${msg}`);
}

greet2("Hello");

function greet3(name="방문자", msg){
    console.log(`${name}님, ${msg}`);
}

greet2(undefined, "Hello");

// 2. 화살표 함수 
function add1(a, b){
    return a + b;
}

const add2 = (a, b) => { 
    console.log(a, b);
    return a + b 
};

// 함수의 구현부에 return값만 있다면 return 키워드와 중괄호를 생략 가능하다.
add3 = (a, b) => a + b;  
// 매개변수가 하나인 경우 괄호() 생략 가능하다.
const print = msg => console.log(msg); 

// 코드가 짧고 가독성이 좋다.
// this의 바인딩차이
// 화살표 함수는 자신만의 this를 바인딩하지 않는다.
const human1 = {
    name: "Jeameon",
    age: 22,
    info: function(){
        console.log(`안녕 나는 ${this.name}이고 ${this.age}살이야`);
        setTimeout(function(){
            console.log(`안녕 나는 ${this.name}이고 ${this.age}살이야`);
        }, 1000);
    }
}

// Lexical scope : 화살표 함수는 자신이 선언된 위치의 scope를 계승한다.
// 함수를 선언 위치에 따라 this가 결정되는 방식이다.
const human2 = {
    name: "Jeoeon",
    age: 20,
    info: function(){
        console.log(`안녕 나는 ${this.name}이고 ${this.age}살이야`);
        setTimeout(() => {
            console.log(`안녕 나는 ${this.name}이고 ${this.age}살이야`);
        }, 1000);
    }
}

human1.info();
human2.info();


// 3. 콜백 함수
// 특정 함수를 실행할 때 실행하는 사람이 특정 기능을 완료한 후에 실행하고싶은 코드를 정의하는 용도이다.
const run = (callback) => {
    // 특정 기능 수행 함
    callback();
}

run(() => {
    console.log("콜백 함수 실행");
});