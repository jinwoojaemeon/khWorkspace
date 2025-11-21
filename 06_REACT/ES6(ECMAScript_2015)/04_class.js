// js class 

// 1. class 선언
// - 객체를 생성하기 위한 문법 (설계도)
// - 데이터(변수)와 기능(메서드), 생성자를 포함하고 있다.

class Person{

    // js에서 생성자는 명확하게 이름을 constructor로 지정해야 한다.
    // 생성자 : 객체가 무결성
    constructor(name, age){
        this.name = name;
        this.age = age;
    }

    getAge(){
        return this.age;
    }
    setAge(age){
        this.age = age;
    }
    getName(){
        return this.name;
    }
    setName(name){
        this.name = name;
    }

    printInfo(){
        console.log(`이름 : ${this.name}, 나이 : ${this.age}`);
    }
}

const user1 = new Person("Jeameon", 22);
user1.printInfo();
console.log(user1);

// 클래스 상속

class Student extends Person{
    constructor(name, age, gender, grade){
        super(name, age);
        this.gender = gender;
        this.grade = grade;
    }
    getGender(){
        return this.gender;
    }
    setGender(gender){
        this.gender = gender;
    }
    introduce(){
        console.log(`이름 : ${this.name}, 나이 : ${this.age}, 성별 : ${this.gender}`);
    }
}

const student1 = new Student("Jeameon", 22, "male", 1);
student1.printInfo();
student1.introduce();
console.log(student1);

//function Student(){}
//Student.prototype.introduce = function(){console.log("나는 학생입니다.~~~ ");};

// 자바스크립트의 object로도 필드와 메서드를 포함하는 객체를 만들 수 있다.
const car = {
    name : "소나타",
    brand : "현대",
    year : 2025,
    color : "검정",
    speed : 0,
    start : function(){
        console.log("차가 출발합니다.~~~ ");
    },
    stop : function(){
        console.log("차가 정지합니다.~~~ ");
    }
}

car.start();
console.log(car);
// ... : 스프레드 연산자
const car2 = {
    ...car,
    name : "모닝",
    year : 2024,
    color : "흰색"
}
console.log(car2);