package com.kh.collection.map;

import java.util.Objects;

public class Human {
	private String name;
	private int age;
	
	
	
	public Human() {
		super();
	}

	public Human(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", age=" + age + "]";
	}

	
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		//return ("" + name + age).hashCode();   String의 hashCode 매서드를 이용하는 방법
		return Objects.hash(name, age);  // Object에 hash 매서드를 이용하는 방법(비교를 원하는 모든 인자를 전달할 수 있다);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Human) {
			Human h = (Human)obj;
			return this.name.equals(h.getName());
		}
		return false;
	}
	
	
	
}
