package com.kh.example.ploymorphism;

public class Avante extends Car{

	public Avante(String color, String fuel, int year) {
		super(color, fuel, year);
	}

	@Override
	public void drive() {
		System.out.println("슝슝~ avante");
	}

	
	public void moveAvante() {
		System.out.println("방빵~ avante");
	}
	
	
	public void driveCar(Car car) { // 매개변수에 부모타입 참조변수를 사용하면 모든 자식타입을 받을 수 있다.
		// 매개변수로 넘어온 car가 실제 메모리공간이 Avante를 구현하고 있어야 moveAvante()를 사용하능하다.
		if(car instanceof Avante)
		((Avante)car).moveAvante();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Avante) {
			//비교
		}
		return false;
	}
	
	
}
