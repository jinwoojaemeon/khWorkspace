package com.kh.example.ploymorphism;

public class Sonata extends Car {

	public Sonata(String color, String fuel, int year) {
		super(color, fuel, year);
	}
	
	@Override
	public void drive() {
		System.out.println("슝슝~ sonata");
	}
	
	public void moveSonata() {
		System.out.println("빵방 sonata~ ");
	}

	
}
