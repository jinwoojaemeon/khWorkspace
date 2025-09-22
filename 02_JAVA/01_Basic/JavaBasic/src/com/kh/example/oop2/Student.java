package com.kh.example.oop2;

public class Student {
	private int grade;
	private int classroom;
	private String name;
	private double height;
	private char gender;
	
	{ // 초기화 블럭 : 기본 값을 초기화 하기위한 코드 
		this.grade = 4;
		this.classroom = 12;
		this.name = "박노원";
		this.height = 169.77;
		this.gender = 'M';
	} 
	
	
	
	public int getGrade() {
		return grade;
	}



	public void setGrade(int grade) {
		this.grade = grade;
	}



	public int getClassroom() {
		return classroom;
	}



	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getHeight() {
		return height;
	}



	public void setHeight(double height) {
		this.height = height;
	}



	public char getGender() {
		return gender;
	}



	public void setGender(char gender) {
		this.gender = gender;
	}



	void information() {
		System.out.printf("학년: %s\n반: %d\n이름: %s\n키: %.2f\n성별: %c", 
								grade, classroom, name, height, gender);
	}
	
	
}
