package com.kh.array;

import java.util.Scanner;

public class ArrayTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1. 크기가 10인 정수형 배열 생성
		int[] iArr = new int[10];
		
		// 2. 반복문을 통해서 0번 인덱스부터 마지막 인덱스까지 10으로 초기화
		for(int i=0; i<iArr.length ;i++) {
			iArr[i] = 10;
		}
		// 3. 반복문을 통해서 (for-each사용) 모든 배열의 요소를 출력
		for(int i : iArr) {
			System.out.print(i + " ");
		}
		System.out.println();
		// 4. 사용자에게 배열의 길이를 입력 받아, 해당 크기의 문자열 배열 nameArr을 생성
		System.out.print("배열의 길이 입력 : ");
		int num = sc.nextInt();
		String[] nameArr = new String[num];
		
		// 5. 사용자에게 사람의 이름을 입력받아서 nameArr에 할당, namearr의 모든 요소만큼 실행.
		for(int i=0; i<nameArr.length;i++) {
			System.out.print("이름 입력 : ");
			nameArr[i] = sc.next();
		}
		
		
		// 6. 사용자에게 이름을 하나 입력 받아서 nameArr에 동일한 이름이 있다면 
		//     동일한 이름이 존재합니다. / 동일한 이름이 존재하지 않습니다. 출력 
		System.out.print("비교할 이름 입력 : ");
		String name = sc.next();
		int cnt = 0;
		for(String s : nameArr) {
			if(s.equals(name)) {
				cnt++;
				break;
			}
		}
	
		System.out.println(cnt > 0 ? "동일한 이름이 존재합니다. " : "동일한 이름이 존재하지 않습니다.");
		
		sc.close();
	}
}
