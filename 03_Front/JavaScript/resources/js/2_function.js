// js의 함수 정의 -> function 함수명(매개변수...){
//                      실행코드... 
//                 }

function test1() { 
    console.log("test1 함수 실행");
}
// 자바스크립트는 함수를 변수에 할당할 수 있다.
// 일급객체, 1종객체/변수 -> 함수에 담을 수 있다, 함수의 인자로 전달이 가능하다, 함수의 결과로 반환할 수 있다. 
// js에서 함수는 1종 객체이기 때문에 위에 모든게 가능하다.
// js에서 함수의 이름이 필수는 아니다. 다만 호출을 위해서는 함수의 이름이 필요하기 때문에 필요 시 작성한다.
const test2 = function(){
    console.log("test2 함수 실행");
}

test1();        
test2();        
test1();

// js는 오버로딩을 지원하지 않는다. 매개변수의 갯수가 달라도 동일한 메서드로 인식한다.
let test3 = function(name){ 
    // js의 함수는 기본적으로 arguments객체를 가지고 있다. -> arguments : 전달받은 모든 인자값이 들어있는 배열
    console.log(arguments);
    console.log("test3 함수 실행");
    console.log(name);
}
test3();
test3("jaemeon");
test3("jaemeon",55,"경기도 고양시");

let test4 = () => 200;
console.log(test4());