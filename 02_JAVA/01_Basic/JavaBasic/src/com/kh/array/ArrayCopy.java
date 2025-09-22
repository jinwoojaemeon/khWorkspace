package com.kh.array;

import java.util.Scanner;

public class ArrayCopy {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] origin = {1,2,3,4,5};
		System.out.println("====원본출력====");
		for(int n : origin) {
			System.out.print(n + " ");
		}
		System.out.println();
		
		int[] copy = origin;
		System.out.println("====복사출력====");
		for(int n : copy) {
			System.out.print(n + " ");
		}
		
		copy[2] = 99;
		System.out.println("\n복사본 값 변경");
		System.out.println("====원본출력====");
		for(int n : origin) {
			System.out.print(n + " ");
		} // 복사라고 하기 보단, 한 메모리를 같이 참조하고 있는 셈이다.
		
		// copy배열의 값을 수정해도 원본의 값이 변경된다.
		// 복사라고 하기 보단, origin과 copy가 같은 한 메모리를 참조하고 있기 때문이다.(참조변수의 주소값이 동일)
		// 얕은 복사 : 주소값 복사 
		
		// 배열의 복사 방법 
		/*
		 * 1. for문을 활용
		 * 새로운 배열을 만들어서 반복문을 통해 원본배열의 각 요소를 복사한다.
		 *   >> 완벽한 깊은 복사 : 서로 독립적인 배열 생성 
		 */
		
		int[] origin2 = {1,2,3,4,5};
		int[] copy2 = new int[origin2.length];
		
		for(int i=0; i<copy2.length; i++) {
			copy2[i] = origin2[i];
		}
		System.out.println("\n====원본2 출력====");
		for(int n : origin2) {
			System.out.print(n + " ");
		}
		System.out.println("\n====복사본2 출력====");
		for(int n : copy2) {
			System.out.print(n + " ");
		}
		
		copy2[2] = 99;
		System.out.println("\n====원본2 출력====");
		for(int n : origin2) {
			System.out.print(n + " ");
		}
		System.out.println("\n====복사본2 출력====");
		for(int n : copy2) {
			System.out.print(n + " ");
		}
		
		/*
		 * 2. clone()
		 * Java에서 제공하는 매서드
		 * 배열의 모든 요소를 새로운 배열로 복사
		 * 기본적으로 얕은복사를 진행한다. 단, 기본형 배열(원시타입)은 깊은 복사로 동작한다.
		 */
		
		int[] origin3 = {1,2,3,4,5};
		int[] copy3 = origin3.clone();
		
		System.out.println("\n====원본3 출력====");
		for(int n : origin3) {
			System.out.print(n + " ");
		}
		System.out.println("\n====복사본3 출력====");
		for(int n : copy3) {
			System.out.print(n + " ");
		}
		copy3[2] = 99;
		System.out.println("\n====원본3 출력====");
		for(int n : origin3) {
			System.out.print(n + " ");
		}
		System.out.println("\n====복사본3 출력====");
		for(int n : copy3) {
			System.out.print(n + " ");
		}
		
		sc.close();
	}

}
