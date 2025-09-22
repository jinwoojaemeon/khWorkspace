package com.kh.example.inherit;

public class Circle extends Point {
	private int radius; // 반지름

	public Circle() {
		super();   // 부모 클래스의 기본 생성자
	}

	public Circle(int x, int y, int radius) {
		super(x, y);	
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return super.toString() + ", " +radius;
	}
	
	
}
