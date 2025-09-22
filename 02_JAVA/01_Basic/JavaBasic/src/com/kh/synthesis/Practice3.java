package com.kh.synthesis;

import java.util.Scanner;

public class Practice3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		str = str.toUpperCase();
		int[] alphaCnt = new int[26];
		
		// 알파벳 배열에 갯수 넣기
		for(int i=0; i<str.length(); i++) {
			int idx = str.charAt(i)-'A';
			alphaCnt[idx]++;
		}
		
		// 최빈 위치 찾기
		int maxIdx = 0;   
		int max = 0;   //  알파벳 최대의 갯수 
		for(int loop=0; loop<alphaCnt.length; loop++) {
			if(max<alphaCnt[loop]) {
				maxIdx = loop;
				max = alphaCnt[loop];
			} // max = alphaCnt[loop] > max ? alphaCnt[loop] : max;   최대값 구하는 삼항 연산자 
		}
		
		// 최빈 갯수 중복 탐색 
		int maxCnt = 0;
		for(int loop=0; loop<alphaCnt.length; loop++) {
			if(alphaCnt[maxIdx]==alphaCnt[loop]) {
				maxCnt++;
			}
		}

		// 출력
		if(maxCnt>1) {
			System.out.println("?");
		}else {
			System.out.println((char)('A'+maxIdx));
		}
		sc.close();
	}

}
