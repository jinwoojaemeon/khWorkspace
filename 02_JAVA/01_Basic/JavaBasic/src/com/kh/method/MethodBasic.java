package com.kh.method;

public class MethodBasic {
	/*
	 * 매서드란 
	 *  - class 내부에 정의된 함수(Function)를 매서드(Method)라고 부른다.
	 *  - 특정 기능을 수행하는 코드블록을 정의하고, 필요할 때 호출하여 재사용 가능하다.
	 *  - 중복 코드 제거와 가독성, 유지 보수성이 향상 된다.
	 *  
	 *  [기본구조]
	 *   [접근제한자] [static] 반환형 매서드이름(매개변수){ 
	 *   	// 함수에서 실행할 코드 
	 *    	// [return 값];       // 반환형이 void: return을 생략하거나 return;으로 매서드 종료 가능
	 *    
	 *   }
	 */
	
	//	main 매서드 : 프로그램의 시작을 의미하는 매서드
	public static void main(String[] args) {
			System.out.println("프로그램 시작");
			hiEveryone(28);
			int iNum1 = 2;
			int iNum2 = 4;
			int addResult = adder(iNum1, iNum2);
			int squareResult = square(addResult);
			System.out.println(squareResult + " " + addResult);
			
			System.out.println("프로그램 끝");
	}
	public static int adder(int num1, int num2) {
		return num1 + num2;
	}
	
	public static int square(int num) {
		return num * num;
	}
	
	public static void hiEveryone(int age) {
		System.out.println("좋은 아침입니다.");
		System.out.println("제 나이는" + age + "살 입니다.");
	}
	
	
	
}
