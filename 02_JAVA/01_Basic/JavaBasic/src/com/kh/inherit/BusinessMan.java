package com.kh.inherit;

public class BusinessMan extends Man {
	private String company;
	private String position;
	protected BusinessMan(String name, String company, String position) {
		super(name); // 자식클래스의 생성자에는 무조건 부모생성자가 필요함.
		//맨 첫번째 줄에, 생략 시 부모의 기본 생성자를 호출.
		this.company = company;
		this.position = position;
	}
	public void tellYourInfo() {
		System.out.println("My company is "+ company);
		System.out.println("My Position is "+ position);
		super.tellYourName();  // super. -> 부모클래스의 메모리에 접근
	}
}
