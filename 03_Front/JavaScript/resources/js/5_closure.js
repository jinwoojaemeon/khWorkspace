/**
 * closure란 
 * 클로저는 함수와 그 함수가 선언된 시점의 렉시컬 환경의 조합이다.  (렉시컬 : 선언된 위치 기준으로 스코프가 결정되는 것(js는 렉시컬 스코프를 따른다.)
 * 즉, 내부 함수의 선언 시점에 외부 함수의 변수를 함께 저장해서 사용하는 것을 의미한다.
 * 
 * 콜백/ 이벤트 핸들러/ 모듈 패턴에서 핵점적인 역할을 한다.  
 */

function getCounter(){
    // count는 getCounter 영역에 선언된 변수
    let count = 0;

    function increase(){
        // count를 본인만의 렉시컬 환경에 저장하는 것처럼 동작
        count++;
        return count;
    }

    return increase; // 내부 함수를 반환 -> 외부에서도 count 변수에 접근 가능
}

const run = getCounter(); // getCounter() 실행 -> increase 함수 반환
// console.log(run()); // 1
// console.log(run()); // 2

// count는 외부에서 직접 보이지 않지만, increase()를 통해서 변경 가능하다. => 캡슐화 (정보 은닉)
// run()이 살아있는 한, count가 메모리에 계속 유지된다. => 상태 유지 가능

function out(outValue){
    // outValue를 기억하는 closure 생성
    function inner(innerValue){
        console.log("outValue : "+outValue);
        console.log("innerValue : "+innerValue);
    }
    return inner;
}

const printer = out("외부함수");
printer("내부함수");
// outValue는 out 함수가 종료된 이후에도 inner함수가 기억된다. => closure

// getCounter 실행 시마다 새로운 렉시컬 환경이 만들어진다
// run1, run2, run3는 완전히 독립적인 상태값을 가진다.
let run1 = getCounter();
let run2 = getCounter();
let run3 = getCounter();

// console.log(run1()); // 1
// console.log(run1()); // 2
// console.log(run2()); // 1
// console.log(run3()); // 1
// console.log(run2()); // 2
// console.log(run1()); // 3
// console.log(run3()); // 2
// console.log(run2()); // 3
// console.log(run3()); // 3

function createStore(initial = 0){ // 값이 안 넘어오면 0으로 기본값을 지정 
    let value = initial; // 초기값
    return {
        get: function(){return value},
        set: function(val){value = val},
        increase: function(){value++; return value;}
    }
}

const store1 = createStore(10);
console.log(store1.get()); // 10
store1.increase();
console.log(store1.get()); // 11
store1.set(100);
console.log(store1.get()); // 100
// 외부에서 value에 직접 접근 불가 => 캡슐화(정보은닉) => 메서드로만 조작

function attachOnce(el, msg){
    let clicked = false; // 지역상태(closure 생성)
 
    el.addEventListener('click',function(){  // 이벤트리스너 등록
        if(clicked) return; // 클릭한 적이 있는지 판별
        clicked = true; // 클로저에 있는 clicked 값을 true로 변경
        console.log(msg); // 클릭시 하고자하는 동작을 수햏
    }); 

}
// el를 눌러도 처음 한번만 msg 출력