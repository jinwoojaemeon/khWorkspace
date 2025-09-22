package com.kh.jdbc.view;

import java.util.Scanner;

import com.kh.jdbc.controller.BookController;

public class BookMenu {
	private Scanner sc;
	private BookController bookController; 

	public BookMenu() {
		super();
	}

	public BookMenu(Scanner sc, BookController bookController) {
		super();
		this.sc = sc;
		this.bookController = bookController;
	}
	
	public void mainMenu() {
		while(true) {
			System.out.println("========== 도서관리 ===========");
			System.out.println("1. 도서 추가");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 정보 변경");
			System.out.println("4. 도서 삭제");
			System.out.println("5. 도서 제목으로 검색");
			System.out.println("9. 프로그램 종료");
			
			System.out.print("메뉴 입력 : ");
			int sel = sc.nextInt();
			sc.nextLine();
			
			switch(sel) {
				case 1: insertBoard(); break;
				case 2: break;
				case 3: break;
				case 4: break;
				case 5: break;
				case 9: System.out.println("프로그램을 종료합니다."); return;
				default: System.out.println("잘못 입력하셨습니다. ");
			}
			
			System.out.println();
		}
	}
	
	public void insertBoard() {
		System.out.println("\n=================== 도서추가 ============================");
		System.out.print("제목 : ");
		String title = sc.nextLine();
		
		System.out.print("저자 : ");
		String author = sc.nextLine();
		
		System.out.print("출판사 : ");
		String publisher = sc.nextLine();

		bookController.insertBook(title, author, publisher);
	}
	
	public void displaySuccess(String msg) {
		System.out.println(msg + "에 성공적으로 완료하였습니다.");
	}
	
	public void displayFail(String msg) {
		System.out.println(msg + "에 실패하였습니다.");
	}
}
