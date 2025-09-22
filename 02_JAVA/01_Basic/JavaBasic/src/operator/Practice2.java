package operator;

import java.util.Scanner;

public class Practice2 {
	/*
	 * 키보드로 정수 두 개를 입력받아 두 수의 합, 차, 곱, 나누기 값을 출력
	 * 
	 * [출력]
	 * 첫번째 정수 : [키보드 입력]
	 * 두번째 정수 : [키보드 입력]
	 *
	 * 더하기 : n
	 * 빼기 : n
	 * 곱하기 : n
	 * 나누기 : n
	 * 나머지 : n
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 정수 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수 : ");
		int num2 = sc.nextInt();
		
		System.out.printf("더하기 : %d\n빼기 : %d\n곱하기 : %d\n나누기 : %d\n나머지 : %d", 
				num1+num2, num1-num2, num1*num2, num1/num2, num1%num2);
	
		sc.close();
		
	}

}
