/**
 * Hoisting
 * 
 * - JS 엔진이 코드를 실행(해석)하기 전에 모든 변수와 함수 선언을 메모리에 미리 등록해 두는 동작이다.
 *  >>> 선언이 코드 아래에 있어도 마치 코드의 최상단으로 끌어올려진 것처럼 동작한다.
 */

/**
 * hositing area : name1, name2, name3
 * TDZ area : name2, name3
 * 
 * TDZ(Temporal Dead Zone) = let, const 변수가 선언되기 전까지 해당 변수를 기록해두는 공간
 *  해당 영역(TDZ)에 표시된 변수는 아직 선언 시점이 되지 않은 변수로 구분한다.
 */


console.log("선언 전 : ", name1); 
var name1 = "jaemeon"; 
console.log("선언 후 : ", name1); 

console.log("선언 전 : ", name2);

// 일반 변수
let name2 = "jeemeon";
// 일반 상수 
const name3 = "jaeon";

// const와 let은 var와는 다르게 TDZ(Temporal Dead Zone) 영역을 이용해서
// 마치 hositing이 일어나지 않은 것처럼 동작한다.

hello(); 

function hello() {
    console.log("안녕하세요");
}
// 함수 선언문은 전체 함수가 메모리에 먼저 등록(hoisting)되기 때문에 
// 코드 어디서든 호출할 수 있다.

/*let hello = function() {  >> 이건 호이스팅 안된다.
    console.log("안녕하세요");
}*/
