// 여러 기능을 모듈로 등록해서 외부에서 사용할 수 있도록 구성 

// export -> 외부로 기능을 내보낸다. (함수, 변수 전부 가능)
// 외부에서 가져다 사용할 수 있게 만들어졌다.
export function add(a, b){
    return a + b;
}

export const PI = 3.141592653589793;

// default export -> 이름없이 1개만 내보낼 수 있다. 
// 해당 모듈을 불러와서 사용하는 쪽에서 이름은 자유롭게 만들 수 있다.

export default function hello(name="방문자"){
    console.log(`안녕하세요. ${name}님!`);
}