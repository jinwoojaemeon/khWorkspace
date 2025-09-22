package com.kh.practice.loop;

import java.util.Scanner;

public class Practice6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i<10; i++) {
			System.out.print("숫자 입력 : ");
			int input = sc.nextInt();
			if(input % 2 == 1) {
				continue;
			}
			System.out.printf("짝수 %d의 제곱은 %d입니다.", input, input*input);
			System.out.println();
		}
		sc.close();
	}

}
