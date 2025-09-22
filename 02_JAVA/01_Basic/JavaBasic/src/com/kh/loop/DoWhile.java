package com.kh.loop;

import java.util.Scanner;

public class DoWhile {
	/*
	 * do-while 문 
	 * do{
	 * 	실행할 코드
	 * }while(조건식);
	 * 처음에 무조건 실행코드 한번 실행되고 조건문을 검사
	 * 
	 * 기존의 for/while은 처음 수행될 때 조건검사 후 true 일 경우에만 반복코드를 실행함.
	 * do-while은 그와 다르게 첫 실행은 조건검사를 하지 않고 무조건 실행.
	 */
	
	public static void main(String[] args) {
		
		/*
		 * int n; Scanner sc = new Scanner(System.in);
		 * 
		 * 
		 * do { System.out.println("서비스 번호를 입력하세요. "); System.out.println("1. 추가");
		 * System.out.println("2. 삭제"); System.out.println("3. 종료"); n = sc.nextInt();
		 * switch(n) { case 1: System.out.println("추가 완"); case 2:
		 * System.out.println("삭제 완"); case 3: System.out.println("종료 완"); break;
		 * default: System.out.println("잘못입력");
		 * 
		 * } System.out.println("서비스 번호를 입력하세요. "); n = sc.nextInt(); }while(n != 3);
		 */		 
		// 사용자가 원하는 수를 계속해서 더하는 프로그램 작성
		// 단, 사용자가 0을 입력하면 종료 
		Scanner sc = new Scanner(System.in);
		int inputNum, sum=0;
		do {
			System.out.print("숫자 입력 : ");
			inputNum = sc.nextInt();
			sum += inputNum;
		}while(inputNum!=0);
		
		System.out.println("결과 : " + sum);
	}

}
