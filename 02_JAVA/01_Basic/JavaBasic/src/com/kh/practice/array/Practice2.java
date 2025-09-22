package com.kh.practice.array;

import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] iArr = new int[N];
		for(int i=0; i<iArr.length; i++) {
			iArr[i] = sc.nextInt();
		}
		int max = iArr[0];
		// int max = Integer.MAX_VALUE;   // int로 표현할 수 있는 수 중 가장 큰 수 
		int min = iArr[0];
		// int min = Integer.MIN_VALUE;   // int로 표현할 수 있는 수 중 가장 작은 수
		for(int i=1; i<iArr.length; i++) {
			if(iArr[i] > max) {
				max = iArr[i];
			}else if(iArr[i] < min){
				min = iArr[i];
			}
		}
		System.out.println(min + " " + max);
		sc.close();
	}

}
