package com.kh.option;

public class Counter {
	//클래스 변수 -> 프로그램 시작과 동시에 메모리에 할당, 프로그램 종료 시 반환 
	static int count = 0;
	
	//인스턴스 변수
	String name;
	//alt+shift+s 누르고 -> o  >>> 생성자 생성 단축키. 
	public Counter(String name) {
		this.name = name;
		count++;      // 인스턴스 생성 시 마다 1증가
	}
	
	public static void showCount() {
		//System.out.println(name);  -> 인스턴스 변수 접근 불가. 
		System.out.println("현재 생성된 객체 수 : " + count);
	}

}
