package com.kh.example.exception2;

import java.util.Scanner;

public class NumberMenu {
	public void menu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 1 :");
		int num1 = sc.nextInt();
		System.out.print("정수 2 :");
		int num2 = sc.nextInt();
		try{
			boolean result = new NumberController().checkDouble(num1, num2);
			System.out.println(num1+"은(는) "+num2 + "의 배수인가 ? "+ result);
		} catch (NumRangeException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}
}
