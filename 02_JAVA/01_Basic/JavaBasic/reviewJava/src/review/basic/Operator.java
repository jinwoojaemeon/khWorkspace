package review.basic;

import java.util.Scanner;

public class Operator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수값 입력: ");
		int num = sc.nextInt();

		String result = (num == 0) ? "0" : (num > 0) ? "양수" : "음수";
		System.out.println(result);
	}
}
