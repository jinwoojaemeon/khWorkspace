package com.kh.example.oop4;

import java.util.Scanner;

public class ShapeMenu {
	private Scanner sc = new Scanner(System.in);
	private SquareController scr = new SquareController();
	private TriangleController tc = new TriangleController();
	
	public void inputMenu() {
		System.out.println("===== 도형 프로그램 =====");
		System.out.println("3.삼각형");
		System.out.println("4.사각형");
		System.out.println("9.프로그램 종료");
		System.out.print("메뉴번호 : ");
		
		int selectMenu = sc.nextInt();
		sc.nextLine();
		
		switch(selectMenu) {
		case 3:
			triangleMenu();
			break;
		case 4:
			squareMenu();
			break;
		case 9:
			return;
		default:
			System.out.println("잘못된 번호입니다. 다시 입력하세요. ");
			break;
		}
	}
	
	public void triangleMenu() {
		System.out.println("===== 삼각형 =====");
		System.out.println("1.삼각형 면적");
		System.out.println("2.삼각형 색칠");
		System.out.println("3.삼각형 정보");
		System.out.println("9.메인으로");
		System.out.print("메뉴번호 : ");
		
		int selectMenu = sc.nextInt();
		sc.nextLine();
	}
	public void squareMenu() {
		System.out.println("===== 사각형 =====");
		System.out.println("1.사각형 둘레");
		System.out.println("2.사각형 면적");
		System.out.println("3.사각형 색칠");
		System.out.println("4.사각형 정보");
		System.out.println("9.메인으로");
		System.out.print("메뉴번호 : ");
		
		int selectMenu = sc.nextInt();
		sc.nextLine();
	}
	public void inputSize(int type, int menuNum) {
		if(type == 3) {
			switch(menuNum) {
			case 1 :
				 {
				 System.out.print("높이 : ");
				 double height = sc.nextDouble();
				 System.out.print("너비 :");
				 double width = sc.nextDouble();
				 System.out.println("삼각형 면적 : " + tc.calcArea(height, width));
				 }break;
			case 2 :
				System.out.println("색깔을 입력하세요 : ");
				String color = sc.next();
				scr.paintColor(color);
			case 3 :
			}
		}else if(type == 4) {
			switch(menuNum) {
			case 1:{
				System.out.print("높이 : ");
				double height = sc.nextDouble();
				System.out.print("너비 :");
				double width = sc.nextDouble();
				System.out.println("사각형 둘레 : " + scr.calcPerimeter(height, width));
			
			}case 2:{
				System.out.print("높이 : ");
				double height = sc.nextDouble();
				System.out.print("너비 :");
				double width = sc.nextDouble();
				System.out.println("사각형 넓이 : " + scr.calcArea(height, width));
			}break;
			case 3:
				System.out.println("색깔을 입력하세요 : ");
				String color = sc.next();
				scr.paintColor(color);
				
			}
		}
	}
	public void printInformation(int type) {
		if(type == 3) {
			tc.print();
		}
		else if(type == 4) {
			scr.print();
		}
		
	}
}
