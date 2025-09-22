package com.kh.practice.array;

import java.util.Scanner;

public class Practice3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] basket = new int[N];
		for(int loop=0; loop<M; loop++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int k = sc.nextInt();
			
			for(int n=i;n<=j;n++) {
				basket[n-1] = k; 
			}
		}
		
		for(int number : basket) {
			System.out.print(number+" ");
		}
		sc.close();
	}

}
