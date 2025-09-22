package com.kh.abstractclass;

public class Run {
	/*
	 * 추상클래스 : 하나 이상의 추상메서드를 포함하는 클래스(추상매서드 없이 선언도 가능)
	 * 
	 * abstract 키워드를 명시적으로 class 앞에 붙여서 선언한다.
	 * 추상메서드 또한 abstract 키워드를 명시적으로 사용
	 * 객체생성 불가 -> 반드시 상속하여 구현(오버라이딩) 후 사용
	 * 
	 * 용도
	 * 1. 필수기능(일반메서드) + 형식(추상메서드)를 동시에 제공할 수 있다.
	 * 2. 상속을 통해 자식클래스에서 반드시 구현해야할 기능을 강제
	 * 3. 코드 재사용성과 일관성을 높일수 있다.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal dog = new Dog();
		Animal cat = new Cat();
		dog.speak();
		cat.move();
		cat.speak();
		cat.breathe();
		dog.move();
		dog.breathe();
	}
}
