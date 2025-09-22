// 자료형, 목적에 따라 간경하고 명확하게 구현하기 위한 다양한 반복문이 존재한다.
// 읽기/변환/필터링/검색... 등등 다양한 목적에 따라 알맞는 반복문을 사용해야 가독성이 높아진다.
let members = [
    "김재면",
    "최재면",
    "이재면",
    "박재면",
    "정재면",
    "황재면",    
];

/*console.log(members.push("신재면"));
console.log(members);
// splice(인덱스, 몇 개) -> 원본에서 특정 인덱스부터 n개를 잘라내어 제거
console.log(members.splice(1, 3));
console.log(members);
// slice(인덱스, 마지막 인덱스-1) -> 원본에서 특정 인덱스부터 마지막 인덱스-1 개를 추출(원본 영향 없음)
console.log(members.slice(0, 3));
console.log(members);*/

// ... 배열 또는 ... 객체 -> spread 연산자
// 배열이나 객체의 요소를 개별적으로 펼쳐서 복사하거나 전달할 때 사용한다.
let members2 = [
    ...members,
    "신재면", 
];
console.log(members2);

let choi = {
    name : "jaemeon",
    age : 30,
    gender : "남"
};

// 값을 수정할 때
choi = {
    ...choi,
    gender : "여",
} // 원하는 값만 변경 가능
console.log(choi);

//데이터를 추가할 때 
choi = {
    ...choi,
    address : "서울시 강남구",
}
console.log(choi);

// 비구조 할당
// 배열이나 객체에서 값을 추출할 때 개별 변수에 할당해서 추출하는 문법 : react, 신문법에서 많이 사용
members = [
    "김재면",
    "정재면",
    "황재면",    
];

// const kim = members[0];
// const jung = members[1];
// const hwang = members[2];

const [kim, jung, hwang] = members; // 배열 비구조 할당
console.log(kim, jung, hwang);

const {name, age} = choi; // 객체 비구조 할당
console.log(name);
console.log(age);

// const userName = choi.name;
// const userAge = choi.age;
const {name : userName, age : userAge} = choi; 
console.log(userName);
console.log(userAge);

// join(구분자) -> 배열을 문자열로 변경해준다.
console.log(members.join); 
console.log(members.join()); //  ','가 기본 구분자
console.log(members.join(" / "));


//sort() -> 배열을 정렬(원본 변경)
console.log(members2);
console.log(members2.sort()); // 오름차순 정렬
console.log(members2.reverse()); // 배열을 지금 상태에서 역순 정렬
console.log(members2.sort().reverse()); // 내림차순 정렬
 
const stdList = [ // 서버에서 받아온 데이터의 형식은 이런식으로 온다
                {name:"홍길동", java:75, db:95, front: 80},
                {name:"김철수", java:85, db:65, front: 70},
                {name:"박영희", java:55, db:45, front: 50},
                {name:"최민수", java:95, db:85, front: 90},
                {name:"이영자", java:65, db:75, front: 60},
                {name:"김자바", java:100, db:90, front: 95}
            ];

/*
    정렬 기준이 없을 때는 직접 콜백 함수를 동해 정렬 기준을 전달할 수 있다.
    a, b를 비교
    a를 b보다 나중에 정렬하고 싶다면(뒤에두고 싶다면) 0보다 큰 값 반환  - 오름차순  
    a를 b보다 먼저 정렬하고 싶다면(앞에두고 싶다면) 0보다 작은 값 반환  - 내림차순
    원래 순서를 유지하고 싶다면 0 반환
*/
stdList.sort(function(a, b){
    return a.name > b.name ? 1 : -1; // 오름차순
});
console.log(stdList);



//js의 반복문
// for(초기값; 조건식; 증감식){
//     반복 실행할 코드
// }
for(let i=0; i<stdList.length; i++){
    console.log(stdList[i]);
}

// for ~ of : 배열의 요소를 하나씩 꺼내서 반복할 때 사용  // java의 for-each와 비슷하다.
// 배열 값 중심으로 순회한다. 가장 깔금하며 인덱스가 필요없을 때 사용한다.
console.log("=== for ~ of ===");
for(const student of stdList){
    console.log(student);
}

// for ~ in 
//인덱스 중심으로 순회한다.
console.log("=== for ~ in ===");
for(const i in stdList){
    console.log(i + "번째 : ", stdList[i]);
}

// 객체에 사용 시 key를 전부 열거한다.
console.log("=== for ~ in object ===");
const std = {name:"홍길동", java:75, db:95, front: 80};
for(const key in std){
    console.log(key + " : " + std[key]);
}

// ------ 배열의 고차함수 ------
// 읽기전용 + 새로운 배열/값을 반환 -> 불변성 유지를 위해 사용한다.
// 배열/객체.forEach(function(v: 순차적으로 요소하나, i:인덱스 번호, a: 전체배열){}) 
stdList.forEach(function(v,index, array){  // array 빼고 많이 사용, (v, index) : for-of, for-in 같이 사용하는 느낌
    console.log(v + " ", index, " ", array);
    //console.log(array); // stdList 전체
});