package com.kh.control;

import java.util.Scanner;

/*
 * 나이를 입력 받아서 
 * 13세 이하면 : 어린이
 * 13세 초과 19세 이하 : 청소년
 * 19세 초과 : 성인
 * 
 * [출력]
 * 나이를 입력 : xx
 * xx 은 xxx에 속합니다. 
 */

public class Practice1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String group = null;
		System.out.print("나이를 입력 : ");
		int age = sc.nextInt();
		if (age > 0 && age <= 13) group = "어린이";
		else if (age<=19) group="청소년";
		else if (age>19) group="성인";
		
		if(group == "어린이" || group == "청소년" || group == "성인") {
			System.out.println(age+ "은 " + group + "에 속합니다.");
		}
		else {
			System.out.println("잘못된 입력");
		}
		sc.close();
	}

}
