package com.kh.practice.array;

import java.util.Scanner;

public class Practice5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();   // 바구니 수 
		int M = sc.nextInt();   // 반복 작업 수
		
		// basket을 번호 순서대로 초기화 
		int[] basket = new int[N];
		for(int i=0; i<basket.length; i++) {
			basket[i] = i+1;
		}
		
		// M번 뒤집기
		for(int loop=0; loop<M; loop++) {
			int i = sc.nextInt()-1;   // 역순으로 바꿀 바구니 시작점 
			int j = sc.nextInt()-1;   // 역순으로 바꿀 바구니 끝점 
			
			while(i < j) {
				int temp = basket[i];
				basket[i] = basket[j];
				basket[j] = temp;
				i++;
				j--;
			}
		}
		
		for(int number : basket) {
			System.out.print(number + " ");
		}
		sc.close();
	}

}
