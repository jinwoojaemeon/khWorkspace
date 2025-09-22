package com.kh.practice.control;

import java.util.Scanner;

public class Practice1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요: ");
		int score = sc.nextInt();
		score = score / 10;
		char grade;
		switch(score) {
		case 10:  case 9: 
			grade = 'A';
			break;
		case 8: 
			grade = 'B';
			break;
		case 7: 
			grade = 'C';
			break;
		case 6: 
			grade = 'D';
			break;
		default:
			grade = 'F';
		}
		System.out.println("당신의 성적은 " +grade+ "입니다.");
		
		sc.close();
	}
}
