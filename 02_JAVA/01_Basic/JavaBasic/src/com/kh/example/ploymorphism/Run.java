package com.kh.example.ploymorphism;

public class Run {
	/*
	 * 클래스  참조변수     =      new     클래스 생성자(); 
	 *    부모클래스가 위치할 수 있음  = 자식클래스가 위치할 수 있음   -> 업캐스팅
	 *    실제로 어디까지 접근이 가능한가   =  실제로 어떤 형태의 메모리가 생성되는가 
	 */
	public static void main(String[] args) {
		/*
		 * Cake c1 = new CheeseCake(); // Cake까지 접근 가능하며 메모리공간은 실제 CheeseCake의 공간까지 존재함.
		 * c1.sweet(); //오버라이딩시에는 실제 메모리에 있는 재정의된 매서드가 호출된다. ((CheeseCake)c1).yummy();
		 * // 다운캐스팅. 자식의 참조변수로 타입을 변경한다. (업캐스팅 관계에 있을 경우에만 가능하다)
		 * 
		 * // CheeseCake c2 = new Cake(); // 성립 x // 실제 메로리가 Cake이므로 CheeseCake 공간에 접근할
		 * 수 없다. // -> 접근 범위가 실제 메모리의 크기보다 클 수 없다.
		 */		
		
		
		// 1. 부모타입의 래퍼런스(참조변수)로 부모객체를 다루는 경우
		Car c1 = new Car("빨간색", "가솔린", 2021);
		c1.drive();
		//((Sonata)c1).moveSonata();  // error 
		
		// 2. 자식타이 래퍼런스 자식객체를 다루는 경우
		Avante c2 = new Avante("흰색", "LNG", 2024);
		c2.drive();
		c2.moveAvante();
		((Car)c2).drive();   // 부모참조변수로 업캐스팅 가능 -> 오버라이딩된 매서드는 생성된 메모리를 기준으로 하기 때문에 오버라이딩된 매서드가 사용이 된다. 
		//((Car)c2).moveAvante   // 업캐스팅 시 자식요소의 메모리 접근이 불가능하다.
		
		// 3. 부모타입 래퍼런스로 자식객체를 다루는 경우 (업캐스팅)
		Car c3 = new Sonata("회색", "경유", 2025);
		c3.drive();
		//c3.moveSonata();  // 부모타입의 참조변수이기 때문에 자식요소의 매서드 접근이 불가능하다. 
		((Sonata)c3).moveSonata();
		
		/*
		 *  "상속구조"의 클래스들 간의 형변환 가능하다.
		 *  1. UpCasting
		 *  	- 자식타입 -> 부모타입으로 형변환
		 *  	 자동형변환이 가능하다.
		 *  ex) Car c = new Sonata()
		 *  
		 *  2. DownCasting
		 *  	2 부모타입 -> 자식타입으로 형변환
		 *  	 강제형변환을 해야한다. 단, 업캐스팅 관계에 있을 때만 가능하다. 
		 *  ex) ((Sonata)c).moveSonata();
		 *  	((자식)부모).자식매서드();
		 */
		c2.driveCar(c1);
	}

}
