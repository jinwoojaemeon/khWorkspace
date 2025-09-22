package com.kh.array;

public class ArrayBasic {
	/*
	 * 변수 : 하나의 공간에 하나의 값을 담을 수 있다, 메모리공간에 이름을 붙여서 사용.
	 * 배열 : 하나의 이름(참조변수)에 여러 개의 '같은 자료형'의 값을 저장할 수 있는 연속적인 메모리 공간
	 * 
	 * 배열을 사용하는 이유
	 * - 변수만을 사용하면 대량의 데이터를 보관하고자 할 때, 각각의 변수를 만들어서 따로 관리를 해야한다.
	 * - 배열을 이용하면 한번에 관리를 할 수 있다.
	 */
	public static void main(String[] args) {
		//int형 변수 5개 만들어서 0~4의 값을 각각 할당.
		int num1=0, num2=1, num3=2, num4=3, num5=4; 
		
		//배열을 사용하기
		int[] arr = new int[5];
		arr[0] = 0; arr[1] = 1;arr[2] = 2;arr[3] = 3;arr[4] = 4;
		//배열 선언 시 바로 초기화
		int[] arr2 = {0,1,2,3,4};
		
		//배열 사용 방법
		//1. 선언 
		// 자료형[] 배열이름;
		int[] iArr1;  // 배열의 참조 변수만 생성, 아직 메모리가 없다.
		
		//2. 생성(메모리를 할당) : 배열이름 = new 자료형[길이];
		iArr1 = new int[10];
		
		// 반복문을 이용한 값 할당
		for(int i=0; i<iArr1.length; i++) {
			iArr1[i] = i;
		}
		
		// 반복문을 이용하여 모든 값 출력
		for(int i=0; i<iArr1.length; i++) {
			System.out.print(iArr1[i] + " ");
		}
		
		//for-each : 배열을 전체적으로 탐색할 때 쉽게 사용할 수 있는 문법
		/*
		 * for(배열의 값을 받아줄 변수 : 배열 ){
		 * 		반복할 코드
		 * }
		 */
		for(int num : iArr1) {
			System.out.println(num + "을 가져옴");
		}
		
		
	}

}
