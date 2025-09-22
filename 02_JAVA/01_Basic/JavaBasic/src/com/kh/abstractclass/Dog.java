package com.kh.abstractclass;

public class Dog extends Animal{

	@Override
	public void speak() {
		System.out.println("월월~!");
	}

	@Override
	public void move() {
		System.out.println("개가 달린다.");
	}
	
	public void eat() {
		System.out.println("우적우적");
	}
}
