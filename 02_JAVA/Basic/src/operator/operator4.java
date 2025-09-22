package operator;

import jdk.internal.misc.FileSystemOption;

public class operator4 {
	/*
	 * 비교연산자 / 관계연산자
	 * - 두 값을 비교하여 조건을 판단
	 * - 비교 결과는 항상 boolean 타입을 반환
	 * 
	 * 종류
	 * - 대소비교 : < > <= >=
	 * - 동등비교 : == !=
	 * 
	 * 원시타입 비교
	 * - 정수, 실수, 문자등의 기본 변수는 ==. != 등으로 비교가 가능
	 * 
	 * 참조형 비교 
	 * - String 같은 객체는 참조형이므로 ==로 비교 시 문제가 발생한다.
	 *  ( 참조형은 == 비교 시 일반적으로 연산자를 사용하면 값 자체가 아닌 주소값으로 비교된다. )
	 *  - String 문자열1.equals(문자열2)
	 *  처럼 내부의 함수를 이용해서 비교해야 한다. 
	 * */
	
	public static void main(String[] args) {
		int a = 10;
		int b = 25; 
		
		System.out.println("a == b : " + (a==b));
		System.out.println("a <= b : " + (a<=b));
		
		System.out.println("(a*2) > (b/5) : " + ((a*2) > (b/5)));
		
		String str1 = "hello"; // hello 는 문자열 리터럴 
		String str2 = "hello";  // 자바에서 문자열 리터럴은 String Pool이라는 메모리 영역에 저장됨
		// 만약 위처럼 동일한 문자열 리터럴이 또 참조가 되면. 기존에 있던 문자열 객체의 주소로 재사용한다.
		// 즉, 한번만 리터럴 메모리에 값을 올려 메모리를 효율적으로 사용 .
		System.out.println("str1 == str2 : " + (str1==str2));
	}
}
