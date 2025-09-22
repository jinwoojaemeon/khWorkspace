package com.kh.basic;

import java.util.Scanner;

public class Input {
	/*
	 * 입력 : 외부에서의 데이터를 코드 내부로 가져오는 것 
	 * 
	 * Scanner를 사용하면 키보드에 입력값을 가져올 수 있다.
	 * (java.util.Scanner 클래스를 이용한다.)
	 * 
	 * [사용식]
	 * Scanner 이름 = new Scanner(System.in); 
	 */
	public static void main(String[] args) {
		// 입력을 받기 위한 Scanner 객체 생성 
		Scanner sc = new Scanner(System.in);
		/*int inputNum = sc.nextInt();
		
		System.out.println(inputNum);*/
		String str1, str2;
		/*
		//입력받은 값을 특정 변수에 바로 대입 
		System.out.print("입력 : ");
		str1 = sc.next();
		str2 = sc.next();
		System.out.println("str1에 입력한 값 : " + str1);	
		System.out.println("str2에 입력한 값 : " + str2);
		
		//System.out.println("str1에 입력한 값 : " + sc.next());
		
		System.out.print("한 줄 입력 : ");
		str1 = sc.nextLine();
		System.out.println("str1에 입력한 값 : " + str1);	
		*/
		
		/*
		 * Scanner객체명.next() : 문자열 입력받는 함수 (공백 전까지)
		 * Scanner객체명.nextLine() : 문자열 입력받는 함수(공백을 포함한 한줄, 개행문자까지)
		 */
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("주소 : ");
		String address = sc.nextLine();
		System.out.print("나이 : ");
		int age = sc.nextInt();   // 정수를 입력 받고자 할 때 
		
		System.out.printf("제 이름은 %s 이며 %s에 살고 있습니다."
				+ " 저는 올해 %d 살 입니다.", name, address, age);
		// 문제점. 이런식으로 코드를 짜면 nextInt에서 nextLine이 받을 \n 개행이 남아있다.
		System.out.print("이름 : ");
		name = sc.nextLine();
		System.out.print("나이 : ");
		age = sc.nextInt();
		System.out.print("주소 : ");
		address = sc.nextLine();
		   // 정수를 입력 받고자 할 때 
		
		// >> 해결방법 
		System.out.print("이름 : ");
		name = sc.nextLine();
		System.out.print("나이 : ");
		age = sc.nextInt();
		sc.nextLine();                // 아무 의미없는 nextLine 하나 추가 
		System.out.print("주소 : ");
		address = sc.nextLine();
		   // 정수를 입력 받고자 할 때 
		
		System.out.printf("제 이름은 %s 이며 %s에 살고 있습니다."
				+ " 저는 올해 %d 살 입니다.", name, address, age);
		
		/*
		 * 문자 이외에 원시 타입을 입력받을 때
		 * .next타입()
		 * nextInt()   nextDouble()    nextBoolean()   ...   
		 */
		
		sc.close();  // Scanner 자원을 다 쓰고 반납 (한번 반납하면 다시 사용x. 다시 선언 해야한다. )
		// Scanner sc = new Scanner(System.in)  -- 같은 객체명도 오류가 난다.  
	}

}
