//1. for 문
for(let i = 0; i < 5; i++){
    console.log("for in i : ", i);
}

// 2. while 문
let j = 0;
while(j < 5){
    console.log("while in j : ", j);
    j++;
}

// 3. do while 문
let k = 0;
do{
    console.log("do while in k : ", k);
    k++;
}while(k < 5);

// // 4. for ... of 문
// const fruit = ["apple", "banana", "cherry", "orange", "mango"];
// for(const fruit of fruits){
//     console.log("for fruit of in fruit : ", fruit);
// }

// // 5. for ... in 문
// fruits = [
//     {
//     id : 1,
//     name: "사과",
//     price: 3000,
//     quantity: 10
//     },
//     {
//         id : 2,
//         name: "바나나",
//         price: 2000,
//         quantity: 20
//     },
//     {
//         id : 3,
//         name: "오렌지",
//         price: 4000,
//         quantity: 30
// }]
// for(const fruit of fruits){
//     console.log("for fruit in in fruit : ", fruit);
// }

// 6. for ... in 문
const apple = {
    id: 4,
    name: "사과",
    price: 3000
}

for(let k in apple){
    console.log(k + " : " + apple[k]);
}

// 5. foreach 
// - 배열 순회 전용 메서드 
// fruits.forEach((obj,index) => {
//     console.log("foreach : ${index} : ${obj.name}");
// })

const numbers = [1, 3, 5, 7, 9];
// 6. map()
// 기존 배열을 가지고 새로운 배열을 만들고 싶을 때 -> 변형된 새로운 배열을 반환 
// 서버로부터 받은 데이터를 통해서 대칭되는 UI를 만들고 싶을 때 사용
const squared = numbers.map((num) => num * num); // 내부함수의 리턴값을 통한 새로운 배열을 반환
console.log("map의 결과 squared : ", squared);

// 7. filter()
// 조건에 맞는 요소만 추출하고 싶을 때 -> 조건에 맞는 값만 모아서 새로운 배열을 반환 
// 서버로부터 데이터를 삭제하고 이를 ui 상태에 반영해줄때 많이 사용한다.
const squared2 = numbers.filter((num) => num % 3 === 0); // 내부함수의 리턴값이 true인 요소만 모아서 반환
console.log("filter의 결과 squared2 : ", squared2);

// 8. find()
// 조건에 맞는 요소를 찾고 싶을 때 -> 조건에 맞는 첫번째 요소 반환 -> 조건에 맞는 값 하나 검색할 때 사용
const squared3 = numbers.find((num) => num % 3 === 0); // 내부함수의 리턴값이 true인 요소를 반환
console.log("find의 결과 squared3 : ", squared3);

// 9. some()
// 하나라도 조건을 만족하면 true 반환 -> 조건에 맞는 값이 하나라도 있는지 검색할 때 사용
const hasSquared = numbers.some((num) => num % 3 === 0); // 내부함수의 리턴값이 true인 요소가 하나라도 있는지 검색
console.log("some의 결과 hasSquared : ", hasSquared);

const hasSquared2 = numbers.some((num) => num % 2 === 0); // 내부함수의 리턴값이 true인 요소가 하나라도 있는지 검색
console.log("some의 결과 hasSquared2 : ", hasSquared2);

// 10. every()
const allSquared1 = numbers.some((num) => num % 3 === 0);
console.log("하나라도 조건을 만족하면 true 반환 : ", allSquared1);

const allSquared2 = numbers.every((num) => num % 2 === 0);
console.log("모든 요소가 조건을 만족하면 true 반환 : ", allSquared2);

// 11. reduce()
// 배열의 값을 누적하여 하나의 결과값을 도출한다
// 배열.reduce((누적값, 배열요소) => {실행할 코드 return 누적값;}, 누적값의 초기값);
const result = numbers.reduce((sum, num) => {
   console.log("reduce : sum : ", sum, "num : ", num);
   sum += num;
   return sum;
}, 0);
console.log("reduce의 결과 result : ", result);

const result2 = numbers.reduce((sum, num) => {
    console.log("reduce : sum : ", sum, "num : ", num);
    sum.push(num);
    return sum;
 }, []);
console.log("reduce의 결과 result2 : ", result2);

const stdList = [{
    name: "faker",
    age: 30,
    score: 100
},{
    name: "oner",
    age: 23,
    score: 90
},{
    name: "keria",
    age: 24,
    score: 80
}];

let scoreMap = stdList.reduce((scoreMap, std) => {
    scoreMap[std.name] = std.score;
    return scoreMap;
}, {});
console.log("reduce의 결과 scoreMap : ", scoreMap);
