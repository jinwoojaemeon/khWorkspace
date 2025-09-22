package com.kh.array;

import java.util.Scanner;

public class Array2D {
	/*
	 * 2차원 배열
	 * 자료형이 같은 1차원의 배열의 묶음
	 * ex) int[행][열] arr -> ~열의 1차원 배열이 행만큼 존재
	 * 2차원 배열은 할당된 공간마다 index를 2개 부여(앞은 행 : 몇번째 1차원 배열인지, 뒤는 열 : 1치원 배열의 갯수) 
	 *
	 * 선언된 공간마다 같은 길이의 1차원 배열을 사용할 수도 있고
	 * 각각 다른길이의 1차원 배열을 할당할 수도 있다.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//2차원 배열 선언 (1차원 배열의 묶음을 참조하는 2차원 배열 참조변수 선언) 
		//자료형[][] 배열명;
		int[][] iArr;
		
		//2차원 배열의 메모리 할당
		//배열명 = new 자료형[n][m];
		//배열명 = new 자료형[n][];
		
		iArr = new int[2][3]; 
		// arr라는 2차원 배열에 2행 3열의 메모리구조가 바로 할당됨
		// 3개짜리 1차원 배열 2개가 생성 
		
//		iArr = new int[3][];
//		// 1차원 배열의 참소변수만 3개 생성
//		iArr[0] = new int[5];  
//		iArr[1] = new int[3];
//		iArr[2] = new int[2];   >> 각 1차원 배열의 길이를 다르게 생성할수 있다
		
		iArr[0][0] = 5;
		iArr[0][1] = 10;
		iArr[0][2] = 15;
		iArr[1][0] = 3;
		iArr[1][1] = 6;
		iArr[1][2] = 9;
		
		System.out.println(iArr[0][0]);
		System.out.println(iArr[0][1]);		
		System.out.println(iArr[0][2]);
		
//		for(int i=0; i<iArr[0].length; i++) {
//			System.out.print(iArr[0][i] + " ");
//		}
		System.out.println();
		
		/*
		 * 2차원 배열의 모든 요소 탐색 시 
		 * 두개의 for문을 통해서 탐색하면 된다.
		 */
		
		/*
		 * for(int i=0; i<참조변수개수의길이; i++) {
			for(int j=0; j<Arr[i].각1차원배열의길이; j++) {
			 	2차원 배열 Arr[][]를 활용한 코드 ... 
			}
		}
		 */
		for(int i=0; i<iArr.length; i++) {
			for(int j=0; j<iArr[i].length; j++) {
				System.out.print(iArr[i][j] + " ");
			}
			System.out.println();
		}
 
		
		
		
	}

}
