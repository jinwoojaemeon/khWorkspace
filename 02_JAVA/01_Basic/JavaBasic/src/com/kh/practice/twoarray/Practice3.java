package com.kh.practice.twoarray;

import java.util.Scanner;

public class Practice3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[][] paper = new boolean[100][100];
		
		int colorPaper = sc.nextInt();
		int sumArea = 0;
		
		for(int i=0; i<colorPaper; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int paperX = x; paperX<(x+10); paperX++) {
				for(int paperY = y; paperY<(y+10); paperY++) {
					if(!paper[paperX][paperY] ) {
						paper[paperX][paperY] = true;
						sumArea++;
					}
					
				}
			}
			
		}
		System.out.println(sumArea);
		sc.close();
		
	}

}
