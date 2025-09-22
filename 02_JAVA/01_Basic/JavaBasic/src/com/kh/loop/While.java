package com.kh.loop;

import java.util.Scanner;

public class While {
	/*
	 * <while문>
	 * 
	 * [표현법]
	 * 
	 * while(조건식){
	 * 		반복할 코드
	 * 		[탈출이 가능한 구조]
	 * }
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int i = 0;
//		while(i<10) {
//			System.out.println("아녕하세요");
//			i++;
//		}
	
		// 사용자가 0을 입력할 때 까지 반복해서 입력받아 그대로 출력  -> for
//		for(int n = sc.nextInt(); n!=0; n=sc.nextInt()) {
//			System.out.println(n);
//		}
		// - > while
//		int n = sc.nextInt();
//		while(n != 0) {
//			System.out.println(n);
//			n = sc.nextInt();
//		}
		
		// 사용자가 0을 입력할 때까지 랜덤값(1~100)을 하나씩 생성해서
		// 모두 더한 값을 출력
		
	
		int n = sc.nextInt();
		int sum = 0 ;
		while(n != 0) {
			int num = (int)(Math.random()*100)+1;
			sum += num;
			n = sc.nextInt();
		}
		System.out.println("모두 더한 값: " + sum);
		
		//-----------------------------------------------------
		int num;
		
		System.out.println("서비스 번호를 입력하세요. ");
		System.out.println("1. 추가");
		System.out.println("2. 삭제");
		System.out.println("3. 종료");
		
		num = sc.nextInt();
		while(num != 3) {
			switch(num) {
				case 1:
					System.out.println("추가 완");
				case 2:
					System.out.println("추가 완");
				case 3:
					System.out.println("추가 완");
				default:
					System.out.println("잘못입력");
					
			}
			System.out.println("서비스 번호를 입력하세요. ");
			n = sc.nextInt();
		}
		
		
	}

}
