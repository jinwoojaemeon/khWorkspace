// var -> 더이상 사용하지 않을 것
//문제점 
console.log(tmp); //undefined -> 변수가 선언이 되었지만 값이 할당되지 않았기 때문에 : 호이스팅 할때 
var tmp = "여기서부터 생성됨";

// let, const : 변수, 상수 
// TDZ(Temporal Dead Zone)를 통해서 호이스팅의 문제를 해결 -> 변수가 선언되기 전에 접근할 수 없도록 한다.
// let과 const는 호이스팅이 되지만, 선언되는 시점의 코드가 실행되기 전까지는 TDZ에 등록하여 사용할 수 없게 관리한다.

// 변수명 작성 규칙
// 1. 변수명에는 $, _ 외에 특수문자는 사용할 수 없다.
// 2. 변수명은 숫자로 시작할 수 없다.
// 3. 예약어 사용이 안된다 (let, const)

// 올바른 변수명 예시 
let $price = 10000; // 보통 두가지의 변수 타입이 있을 때 구분의 용도로 활용한다.
let userName = "Jeameon"; // 카멜 케이스 
let _status = "active"; // 보통 복사한 값을 표현할 때 

// let : 변수 (값 재할당 가능, 중복선언 xx)
let name = "Jeameon";
console.log('name : ', `${name}`);

name = "Jeoeon";
console.log('name : ', `${name}`);

const age = 50;
console.log(`age : ${age}`);

try{
    age = 15;
    console.log(`name : ${age}`);
}catch(error){
    console.log('error : ', `${error.message}`);
}