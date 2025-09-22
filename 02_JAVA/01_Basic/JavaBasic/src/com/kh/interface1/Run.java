package com.kh.interface1;

public class Run {
	/*
	 * <Interface> : 클래스가 구현해야 할 메서드를 추상매서드로 정의해 두는 것
	 * 
	 * 추상메서드만 선언 가능(구현부가 없는 메서드)
	 * 	- Java8 이후 default 메서드, static 메서드도 사용 가능 (유지보수 위함)
	 * 모든 메서드는 묵시적으로 [public abstract] 키워드가 생성(명시적으로도 사용 가능)
	 * 모든 변수는 묵시적으로 public static final(정적 상수, 묵시적 사용 가능) 
	 * 인터페이스를 implements 하는 클래스는 반드시 인터페이스 내의 모든 추상메서드를 구현해야한다.
	 * Java에서는 클래스 다중상속이 불가하지만, 인터페이스는 다중상속, 다중구현이 가능하다.
	 * 
	 *  
	 * 장점
	 * 1. 다형성 제공(하나의 인터페이스를 참조타입으로 사용하여 여러 객체를 구현할 수 있다.)
	 * 2. 기능의 표준화(기능을 미리 추상메서드로 정의하여 형식을 통일시킬수 있다.)
	 * 3. 결합도가 낮아진다.(구현체가 자유롭게 교체할 수 있기 때문)
	 */
	public static void main(String[] args) {
		Animal dog = new Dog();
		Animal cat = new Cat();
		dog.speak();
		cat.move();
		cat.speak();
		dog.move();
		// dog.eat(); 참조타입에 따른 접근이 불가 
	}

}
