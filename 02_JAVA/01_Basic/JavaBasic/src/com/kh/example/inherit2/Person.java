package com.kh.example.inherit2;

public class Person {
	private String name;
	private int age;
	private double height;
	private double weigth;
	public Person() {
		super();
	}
	public Person(String name, int age, double height, double weigth) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weigth = weigth;
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
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeigth() {
		return weigth;
	}
	public void setWeigth(double weigth) {
		this.weigth = weigth;
	}
	@Override
	public String toString() {
		return  name + ", " + age + ", " + height + ", " + weigth;
	}
	
	
}
