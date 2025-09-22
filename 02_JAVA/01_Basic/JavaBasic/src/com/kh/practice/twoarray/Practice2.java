package com.kh.practice.twoarray;

import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();  // 행
		int M = sc.nextInt();  // 열
		
		int[][] matrix = new int[N][M];
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		int max = Integer.MIN_VALUE;
		int rowIdx=0, colIdx=0;
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				if(max < matrix[i][j]) {
					max = matrix[i][j];
					rowIdx = i;
					colIdx = j;
				}		
			}
		}
		System.out.println(matrix[rowIdx][colIdx]);
		System.out.println((rowIdx+1) +" "+ (colIdx+1));
		sc.close();
	}

}
