package com.kh.abstractclass;

public class Cat extends Animal {

	@Override
	public void speak() {
		System.out.println("야옹");
	}

	@Override
	public void move() {
		System.out.println("고양이가 천천히 걷는다.");
	}
}
