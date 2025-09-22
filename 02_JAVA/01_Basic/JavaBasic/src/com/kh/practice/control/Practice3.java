package com.kh.practice.control;

import java.util.Scanner;

public class Practice3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String grade = "성인";
		int cost = 10000;
		
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		System.out.print("요일을 입력하세요 : ");
		sc.nextLine();
		String day = sc.nextLine();
		
		if(age >= 0 && age <= 12) {
			grade = "어린이";
			cost = 5000;
		}else if(age <= 18) {
			grade = "청소년";
			cost = 7000;
		}
	
		
		
		System.out.print(grade + " 요금입니다.");
		if(day.equals("토") || day.equals("일")) {
			System.out.print("(주말 할인 적용)");
			cost = (int)(cost * 0.8);
		}
		System.out.println("\n최종 요금은 "+ cost + "원입니다.");
		
		sc.close();
	}
}
