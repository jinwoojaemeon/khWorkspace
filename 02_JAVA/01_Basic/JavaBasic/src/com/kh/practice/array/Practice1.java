package com.kh.practice.array;

import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		
		int[] iArr = new int[N];
		for(int i=0 ; i<iArr.length ; i++) {
			iArr[i] = sc.nextInt();
		}
		
		for(int num : iArr) {
			if(num < X) {
				System.out.print(num + " ");
			}
		}
		sc.close();
	}

}
