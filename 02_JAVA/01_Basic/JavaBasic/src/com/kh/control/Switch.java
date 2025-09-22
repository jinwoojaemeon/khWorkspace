package com.kh.control;

import java.util.Scanner;

public class Switch {
	/* <Switch>
	 * switch문도 if문과 동일하게 조건문 
	 *
	 * switch문은 값이 정확하게 일치(동등비교)하는 경우에만 사용한다.
	 * 
	 * [표현식]
	 * switch(비교대상(정수, 문자, 문자열 )) 
	 * case 값1 :
	 *  실행코드;
	 * case 값2 : 
	 *  실행코드;
	 * case 값3 :
	 *  실행코드;
	 *  ...
	 * default: 
	 *  실행코드;   >> 위의 값이 전부 일치가지 않았을 때 실행할 코드   
	 */
	public static void main(String[] args) {
		/*
		 * 정수를 입력받아서 
		 * 1일 경우 빨간색 입니다.
		 * 2일 경우 파란색 입니다. 
		 * 3일 경우 초록색 입니다.
		 * 다른 경우 모두 잘못 입력 했습니다.
		 * 를 출력  
		 */
		Scanner sc = new Scanner(System.in);
		/*
		 * System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		switch(num) {
		case 1:
		//case 5:  이런식으로 다른 값도 일치시킬수 있다.  
			System.out.println("빨간색 입니다.");
			break;  // switch문 내에서 사용하면 해당 코드가 실행됨과 동시에 가장 가까운 switch문 종료 
		case 2:
			System.out.println("파란색 입니다.");
			break;
		case 3:
			System.out.println("초록색 입니다.");
			break;
		default:
			System.out.println("모두 잘못 입력했습니다.");
		}*/
		
		/*
		 * 과일을 구매하는 프로그램을 작성하자. 구매하고자 하는 과일을 입력하면 그에 맞는 가격이 출력되는 프로그램이다. [출력] 구매하고자하는
		 * 과일(사과(2000),바나나(3000),딸기(5000)) : xxx xxx의 가격은 xxxx입니다. / 잘못 입력 하셨습니다.
		 * 
		 * 
		 * System.out.print("구매하고자 하는 과일(사과(2000), 바나나(2000), 딸기(5000)) 입력 : "); String
		 * fruit = sc.next();
		 * 
		 * switch(fruit) { case "사과": System.out.println(fruit+"의 가격은 2000입니다."); break;
		 * case "바나나": System.out.println(fruit+"의 가격은 3000입니다."); break; case "딸기":
		 * System.out.println(fruit+"의 가격은 5000입니다."); break; default:
		 * System.out.println("잘못 입력하셨습니다."); }
		 * 
		 */	
		
		/*
		 * 월을 입력받아서 해당 월에 마지막일이 몇일인지를 출력하는 프로그램 작성
		 * 
		 * [출력]
		 * 월을 입력하세요 : [키보드입력]
		 * xx월은 xx일까지 있습니다.
		 * 1,3,5,7,8,10,12 -> 31dlf
		 * 2 -> 28
		 * 4,6,9,11 -> 30일 
		 * */
		int day=0;
		System.out.print("월을 입력하세요 : ");
		int month = sc.nextInt();
		switch(month) {
		case 2:
			day = 28;
			break;
			
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			day = 31;
			break;
		
		case 4:
		case 6:
		case 9:
		case 11:
			day = 30;
			break;
		}
		if(day==0) {
			System.out.println("잘못된 입력");
		}
		else System.out.println(month + "월은 "+ day +"일까지 있습니다.");
	
		sc.close();
	}

}
