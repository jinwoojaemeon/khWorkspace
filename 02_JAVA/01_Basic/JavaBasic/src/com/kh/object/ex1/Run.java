package com.kh.object.ex1;
/*
 * 해당 클래스는 객체를 생성하기 위함이 아닌
 * 실행을 위한 main문을 포함한 클래스
 */
public class Run {

	public static void main(String[] args) {
		//객체를 생성할 때 
		//class명 객체이름 -> 해당 class타입의 참조변수 생성
		Student park;
		//객체이름 = new class명() -> 새로운 class 타입의 메모리 공간을 할당해서 주소를 참조해라.  (기본생성자 자동 생성)
		park = new Student();
		Student song = new Student();
		
		park.name = "박지연";
		park.age = 20;
		
		song.name = "송아영";
		song.age = 21;
		
		park.myInfo();
		song.myInfo();
		System.out.println(park);
		System.out.println(song);
	}

}
