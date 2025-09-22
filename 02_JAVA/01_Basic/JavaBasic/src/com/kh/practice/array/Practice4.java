package com.kh.practice.array;

import java.util.Scanner;

public class Practice4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] student = new boolean[30];
	
		for(int i=0; i<28; i++) {
			int doProjStudent = sc.nextInt();
			student[doProjStudent-1] = true;
		}
		System.out.println("출석을 안해온 사람");
		for(int i=0; i<30; i++) {
			if(!student[i]) {
				System.out.println(i+1);
			}
		}
		sc.close();
	}

}
