package com.kh.practice.loop;

import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();     //  영수증에 적힌 총 금액 
		int N = sc.nextInt();     //  구매한 물건의 종류 수 
		int sum = 0;
		for(int loop = 0; loop < N ; loop++) {
			int cost = sc.nextInt();
			int cnt = sc.nextInt();
			sum = sum + (cost * cnt);
		}
		
		System.out.println(sum == X ? "Yes" : "No");
		sc.close();
	}

}
