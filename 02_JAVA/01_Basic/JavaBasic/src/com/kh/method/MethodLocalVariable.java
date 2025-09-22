package com.kh.method;

public class MethodLocalVariable {
/*
 * 지역변수
 * - 블록({}) 내부에서 선언된 변수
 * - 해당 블록을 벗어나면 메모리에서 제거된다.
 * - 선언 시 반드시 초기화 후 사용해야된다.
 * 
 * 매개변수 
 * - 매서드 호출 시 외부에서 전달받는 값을 저장하는 지역변수
 * - 매서드 선언부에 정의가 된다.
 * - 매서드 실행 시 생성되고, 매서드 종료 시 사라진다.
 */
	public static void main(String[] args) {
		// main의 지역변수. 
		// main이 종료되면 사라진다.
		String name = "철수";
		int age = 20;
		
		System.out.println("say실행 전 : " + name);
		say(name, age);
		System.out.println("say실행 후 : " + name);
		//if(name.equals("철수"))
			//String name = "진우";  포함되는 관계는 같은 지역이므로 동일한 이름을 사용할 수 없다. 
	
	
		// Call By Value(값에 의한 호출) >> Java는 무조건 이 방식
		// 메모라에 담긴 값 자체를 전달한다.
		// 기본형, 참조형으로 나뉜다.
		// 기본형 -> 값(데이터)자체가 복사된다.
		// 참조형 -> 참조값(주소)이 복사된다.
		// 		>> 주소값을 복사해서 같은 객체를 가르키게 되므로, 내부 데이터를 변경하면 원본에도 영향을 준다.
	
		//기본형
		int num = 10;
		changeValue(num);
		System.out.println("main에서 changeValue 호출 후 : " + num);
		
		// 참조형
		int[] arr = {1,2,3};
		changeReference(arr);
		System.out.println("changeReference호출 후: ================ ");
		for(int n : arr) {System.out.println(n + " ");}
	}
	public static void changeValue(int value) {
		System.out.println("전달받은 value : " + value);
		value = 100;
		System.out.println("변경된 vlaue : " + value);
		
		/*
		 * 참조형을 전달하면 실제 값자체를 전달하는게 아니라
		 * 참조형에 담긴 주소값을 전달하기 때문에
		 * 해당 주소로 접근해서 원본데이터를 변경할 수 있다. 
		 */
		
	}
	
	public static void changeReference(int[] array) {
		System.out.println("전달받은 array ================ ");
		for(int n : array) {System.out.println(n + " ");}
		array[0] = 100;
		System.out.println("변경된 array ================ ");
		for(int n : array) {System.out.println(n + " ");}
	}
	
	public static void say(String name,int age) {
		name = "jaemeon";
		System.out.println("say실행 중 : " + name);
		// name, age는 매개변수이자 say 매서드의 지역변수이다.
	}
	
}
