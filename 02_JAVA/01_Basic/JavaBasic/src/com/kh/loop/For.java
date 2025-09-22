package com.kh.loop;

import java.util.Scanner;

public class For {
	/*
	 * <반복문> 특정 코드를 여러 번 반복해서 실행하고자 할 때 사용하는 제어문
	 * 
	 * 대표적으로 for, while, do-while이 있다.
	 * 
	 * for문 반복 횟수가 명확할 때 가장 많이 사용된다. for(초기식; 조건식; 증감식){ 반복 실행 할 코드; }
	 * 
	 * 초기식 : 반복을 시작하기 전 변수를 선언하고 초기값 설정, 처음 딱 한번만 실행된다. 조건식 : 반복을 계속 진행할지 여부를 판단하는
	 * 조건, 조건이 true면 반복 진행/ false면 반복 종료한다. 매번 반복문의 코드를 실행하기 전에 확인하며, 보통 초기식에 제시된
	 * 변수를 활용하여 조건식을 정한다. 증감식 : 매번 반복이 끝난 후 변수값을 증가/감소시키는 식, 보통 초기식에서 제시된 변수를 활용하여
	 * 증감을 처리한다.
	 */
	public static void main(String[] args) {
		/*
		 * System.out.println("안녕하세요."); System.out.println("안녕하세요.");
		 * System.out.println("안녕하세요."); System.out.println("안녕하세요.");
		 * System.out.println("안녕하세요."); System.out.println("안녕하세요.");
		 * System.out.println("안녕하세요."); System.out.println("안녕하세요.");
		 * System.out.println("안녕하세요."); System.out.println("안녕하세요.");
		 */
		/*
		 * for(int i=0;i<10;i++) { System.out.println("안녕하세요."); }
		 * 
		 * n번 반복 for(int i =0; i<n; i++)
		 * 
		 * for(int i =0; i<"안녕하세요".length() ; i++) {
		 * System.out.println("안녕하세요".charAt(i)); }
		 */

		//1~5 까지의 숫자를 순차적으로 출력하세요. (1 2 3 4 5 )
		/*for(int loop=0; loop<5; loop++) {
			System.out.print((loop+1) + " ");
		}*/
		// System.out.print((loop+1) + " "); 사용 xx 
		/*
		 * java의 지역변수 (블록 scope)
		 *  - 특정 메서드나 블록({}) 내부에서 선언하고
		 *    선언된 블록 범위 내에서만 접근이 가능하다.
		 *  - 해당 블록이 종료되면 블록 내부의 변수도 함께 사라진다.
		 */
		
		/*
		 * 반복문의 초기식, 조건식, 증감식을 꼭 입력해야 하는 것은 아니지만 
		 * 입력하지 않으면 무한 loop가 발생한다 
		 */
		
		// 정수 n을 입력받아 1부터 n까지 1씩 증가시키면서 출력
		Scanner sc = new Scanner(System.in);
		
		/*
		 * System.out.print("정수입력 : "); int n = sc.nextInt(); for(int i=1; i<=n; i++) {
		 * System.out.print(i + " "); }
		 */
		/*
		 * 커피주문 키오스크
		 * [출력]
		 * 아메리카노를 몇 잔 구매하시겠습니까? (1100원) : n
		 * 결제하실 금액 xxxx원 입니다.
		 *
		 */
//		System.out.print("아메리카노를 몇 잔 구매하시겠습니까? (1100원) : ");
//		int n = sc.nextInt();
//		int sum = 0;
//		for(int i = 0 ; i < n ; i++) {
//			sum += 1100;
//		}
//		System.out.printf("결제하실 금액 %d원 입니다.", sum);
		
		// 1~ 10 숫자 중 홀수만 출력 
//		for(int loop=1; loop<=10; loop++) {
//			if(loop%2==1) {
//				System.out.print(loop + " ");
//			}
//		}

//		// 1 ~ 100 숫자 중 짝수의 합을 출력 
//		int sum = 0;
//		for(int loop=1; loop<=100; loop++) {
//			if(loop%2==0) {
//				sum += loop;
//			}
//		}
//		System.out.print("1 ~ 100 숫자 중 짝수의 합: " + sum);
		//System.out.println(Math.random());
		/*
		 * Math.random()
		 * java.lang.Math 클래서에서 기본적으로 제공하는 함수로 호출하면 매번 다른 랜덤을 반환한다.
		 * Math.random() 호출 시 -> 0.0~ 0.999999999999 사이의 랜덤값을 반환
		 * int num = (int)(Math.random()*10) + 1 ; -> 1~10 사이의 랜덤값. 
		 * 최솟값 ~ 최댓값 사이 랜덤 수 : (int)(Math.random()*(최대값 + 1 - 최솟값)) + 최솟값;
		 */
		// random(1~10) 숫자 n을 생성해서 1부터 n까지 모두 더한 값을 출력
		// 출력] random 수 : n
		// 1~n까지의 더한값, 항 : xxx 
//		int num =  (int)(Math.random()*(10 + 1 - 1)) + 1;
//		int sum = 0;
//		for(int i = 1 ; i <= num ; i++) {
//			sum += i;	
//		}
//		System.out.println("random 수 : " + num);
//		System.out.print("1~" + num + "까지의 항 : ");
//		for(int i = 1 ; i <= num ; i++) {
//			System.out.print(i + " ");
//		}
//		System.out.println("\n1~" + num + "까지의 더한 값 : " + sum);
		
		/*
		 * 각 인덱스 별 문자 출력 : str = "Hello"
		 * str.charAt(0) =>  H
		 * str.charAt(1) =>  e
		 * str.charAt(2) =>  l
		 * str.charAt(3) =>  l
		 * str.charAt(4) =>  o
		 * 
		 * index 반복 -> 0~(길이-1)
		 * str.length() = 문자열의 길이를 반환해주는 함수.  
		 */
		
//		for(int i =0; i<"Hello".length() ; i++) {
//			  System.out.print("Hello".charAt(i) + " "); 
//		}
//		System.out.println("문자열 입력 : ");
//		String str = sc.next();
//		System.out.println("문자열 길이 : " + str.length());
//		for(int i =0; i<str.length() ; i++) {
//			  System.out.print(str.charAt(i) + " "); 
//		}
		
		// 사용자에게 문자열을 입력받아 해당 문자열의 짝수 자리 글자만 출력 
		// 문자열 입력 : Hello 
		// el 
//		System.out.print("문자열 입력 : ");
//		String str = sc.next();
//		for(int i=0;i<str.length();i++) {
//			if(i%2==1) {
//				System.out.print(str.charAt(i));
//			}
//		}
//		int dan = 2;
//		for(int i = 1 ; i<=9 ; i++) {
//			System.out.println(dan + " x " + i + " = " + dan*i);
//		}
		
		
		for(int i = 2 ; i<=9 ; i++) {
			for(int j = 1 ; j<=9 ; j++) {
				System.out.println(i + " x " + j + " = " + i*j);
			}
		}
	
		
	}
		
}
