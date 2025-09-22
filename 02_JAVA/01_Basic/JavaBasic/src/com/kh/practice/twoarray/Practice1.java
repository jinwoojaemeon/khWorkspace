package com.kh.practice.twoarray;

import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();  // 행
		int M = sc.nextInt();  // 열
		
		
		int[][] A = new int[N][M];
		int[][] B = new int[N][M];
		
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[i].length; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		for(int i=0; i<B.length; i++) {
			for(int j=0; j<B[i].length; j++) {
				B[i][j] = sc.nextInt();
			}
		}
 
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(A[i][j]+B[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}

}
