package com.kh.control;

import java.util.Scanner;

public class Practice2 {
	/*
	 * 성별을(m/f)으로 (대소문자 상관x)로 입력받아 남학생인지 여학생인지 출력하는 프로그램을 작성하라
	 * 
	 * [출력]
	 * 성별(m/f) : x 
	 * 여학생입니다 / 남학생입니다 / 잘못입력하셨습니다
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("성별(m/f): ");
		char gender = sc.next().charAt(0);            // sc.next().toUpperCase().charAt(0); << 모든 문자열을 대문자로 변환 후 추출 
		switch(gender) {
		case 'm': case 'M':
			System.out.println("남학생 입니다.");
			break;
		case 'f': case 'F':
			System.out.println("여학생 입니다.");
			break;
		default:
			System.out.println("잘못입력하셨습니다.");
		}
	sc.close();
	}
	
}
