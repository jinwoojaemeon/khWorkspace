console.log("Hello world 안녕 js");
// 브라우저의 개발자 console 객체
//.log() console객체의 메서드 중 하나로 메세지를 출력한다. -> 개발자 도구에 console 영역에 표시된다.

/*
    js의 변수 
    1) var - 사용하지 않는다.
    2) let
    3) const    자바에서의 final 과 같은 역할? 
*/
// js는 동적 타입 언어이다. var -> 변수의 타입을 명시적으로 지정하지 않고, 실행 중에 값에 따라서 자동으로 타입이 결정된다.
var name = "정진우";
var age = 55;
var height = 182.3;
var isTure = true;

age = "오십";
var name = "김수민";
console.log(name);

/*
    let은 var에서 같은 이름의 중복 생성을 하지 못하게 만든 자료형 
    const는 상수를 표현하기 위한 자료형
*/
let name2 = "jae";
name2 = "meon";

// let name2 = "jaemeon";  // 안된다.

/**
 * js 네이밍 규칙 
 * 
 * 변수이름
 * 1) 일반적으로 영어를 사용하며 문자와 숫자 모두 사용할 수 있다.
 * 2) 특수문자는 언더스코어(_) 달러($)를 사용할 수 있다. 
 * 3) 숫자로 시작하면 안된다.
 * 4) 키워드를 변수명으로 사용하면 안된다.
 * 
 * 일반적으로 변수명, 함수명 -> camelCase 사용
 * class, id같은 속성명은 -> Kebab-case 하이픈(-) 사용
 */

/*
    Data Type 
    여섯 개의 원시 타입과 한 개의 Object타입이 있다.

    1) Number
    2) String
    3) Boolean
    4) undifined
    5) null
    6) Symbol

    7) Object
    -function
    -Array
    -object
*/


//  Number타입
const age2 = 55;
const temp = -10.5;
const pi = 3.14;
console.log(age2, temp, pi);
console.log(typeof age2);
console.log(typeof temp);
console.log(typeof pi);
console.log(Infinity);
console.log(typeof Infinity);

// String 
const name3 = "최지원 66살";
const age3 = 55;
console.log(typeof name3);
console.log(age3 == "55");
console.log(age3 === "55"); // === >> type까지 비교 

// boolean 
const isTure2 = true;
const isFalse = false;
console.log(typeof isTure2);

/**
 * undefined 
 * 개발자가 직접 값을 초기화하지 않았을 때
 * 즉, 변수는 선언하고 사용하지 않았을 때 지정되는 값 
 */
let num2;
console.log(num2);
console.log(typeof num2);

/**
 * null 
 * undefined와 비슷하게 값이 없을을 표시한다
 * 다만 js에서는 개발자가 직접 명시적으로 없는 값을 초기화 할 때 사용한다.
 */
let init = 10;
init = null;
console.log(init);

/**
 * Symbol 타입
 * 
 * 유일무이한 값을 생성하는 타입 
 * 다른 원시값들과는 다르게 symbol함수를 호출해서 사용한다.
 */

const tmp1 = '1';
const tmp2 = '1';
console.log("tmp1 === tmp2 : ",tmp1 === tmp2);
const symbol1 = Symbol('1');
const symbol2 = Symbol('1');
console.log(symbol1,symbol2);
console.log("symbol1 === symbol2 : ",symbol1 === symbol2);

/**
 * Object -> 프로토타입 체인의 최상위 object가 Object이다
 * object 타입
 * 
 * key : value 형태 -> map의 구조 
 * 
 * 예 : DOM에 <input type="text" style="color:red;"/>
 * {
 *      element: input,
 *      type: text,
 *      style: "coler:red;" 
 * }
 */

const jiwon = {
    name: "최지원",
    age: 47,
    address: "경기도 안양시",
    job: "강사",
}

console.log(jiwon.name);
console.log(jiwon.address);
jiwon.age = 15;
console.log(jiwon.age);
console.log(typeof jiwon);

/**
 * Array 타입 
 * 값을 리스트로 나열할 수 있는 타입 
 */

const arr = ["초록색", "노란색"];
// .push(요소) -> 타입에 상관없이 배열의 맨 뒤에 값을 추가 
arr.push("빨간색");
arr.push("파란색");
arr.push(50);
console.log(arr);
console.log(typeof arr);

//arr.pop() 맨 마지막에 추가된 요소를 제거하고 반환한다.
console.log(arr.pop());
console.log(arr);

console.log(arr[0]);
console.log(arr[2]);
console.log(arr[10]);
