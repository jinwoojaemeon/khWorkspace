package com.kh.inherit;

public class Man {
	private String name;
 
	protected Man() {
		super();
		System.out.println("Man의 기본생성자");
	}

	protected Man(String name) {
		super();
		this.name = name;
		System.out.println("Man에 name이 포함된 생성자");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void tellYourName() {
		System.out.println("My name is " + name);
	}
	
}
