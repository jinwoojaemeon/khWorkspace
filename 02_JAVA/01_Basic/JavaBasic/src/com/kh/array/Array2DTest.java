package com.kh.array;

import java.util.Scanner;

public class Array2DTest {
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * 사용자에게 행(M)과 열(N)을 입력받아 
		 * 해당 행과 열의 빙고판을 만들어라.
		 * 다음 행과 열의 들어갈 문자열을 각각 입력 받아 저장한 뒤.
		 * 출력하라 
		 */
//		System.out.print("행과 열 입력 : ");
//		int m = sc.nextInt();
//		int n = sc.nextInt();
//		
//		String[][] bingo = new String[m][n];
//		for(int i=0; i<m; i++) {
//			for(int j=0; j<n; j++) {
//				System.out.printf("%d행 %d열에 들어갈 단어 입력 : ", i+1, j+1);
//				bingo[i][j] = sc.next();
//			}
//		}
//		
//		for(int i=0; i<bingo.length; i++) {
//			for(int j=0; j<bingo[i].length; j++) {
//				System.out.print(bingo[i][j] + " ");
//			}
//			System.out.println();
//		}
		/*
		 * 사용자에게 좌석의 행과 열을 입력 받아 2차원 배열을 생성
		 * 각 좌석에 들어갈 관객의 이름을 입력받아 저장한뒤
		 * 모두 입력받았으면 좌석표를 출력 
		 */
		System.out.print("줄의 수, 좌석의 수 입력 : ");
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		String[][] seats = new String[m][n];
		for(int i=0; i<m; i++) {
		for(int j=0; j<n; j++) {
			System.out.printf("%d행 %d열에 예약한 관객의 이름 입력 : ", i+1, j+1);
			seats[i][j] = sc.next();
			}
		}
		System.out.println("========좌석표========");
		for(int i=0; i<seats.length; i++) {
			for(int j=0; j<seats[i].length; j++) {
				System.out.print(seats[i][j] + " ");
			}
			System.out.println();		
		}
		
		
		
		
		
		
		
		
		
		sc.close();
	}

}
