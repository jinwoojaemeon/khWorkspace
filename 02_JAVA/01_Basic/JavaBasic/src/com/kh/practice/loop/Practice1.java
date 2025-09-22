package com.kh.practice.loop;

import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int inputNum = sc.nextInt();
		for(int i=1; i<=9;i++) {
			System.out.println(inputNum + " * " + i + " = " + inputNum*i);
		}
		sc.close();
	}
}
