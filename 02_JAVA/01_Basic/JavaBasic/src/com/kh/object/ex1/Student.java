package com.kh.object.ex1;
/**
 * 클래스의 구조
 * 
 * 접근제한자 class 클래스명{
 * 	  -필드 영역
 * 		: 사용할 데이터를 선언하는 영역
 *    -생성자 영역
 *      : 데이터를 초기화하기 위한 특수 목적의 메서드
 *    -메서드 영역
 *    	: 클래스의 기능을 정의하는 영역 
 * }
 **/
public class Student {
	// 필드
	String name;
	int age;
	double height;
	
	// 메서드
	void myInfo() {  // 학생의 정보를 출력하는 기능 
		System.out.printf("안녕하세요. 저는 %d살의 %s입니다.\n", age, name);
	}
	
	
}
