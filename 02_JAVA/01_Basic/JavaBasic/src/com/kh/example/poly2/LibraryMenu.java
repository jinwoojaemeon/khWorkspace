package com.kh.example.poly2;

import java.util.Scanner;

public class LibraryMenu {
	LibraryController lc = new LibraryController();
	Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		System.out.print("성별 : ");
		char gender = sc.next().toUpperCase().charAt(0);
		lc.insertMember(new Member(name, age, gender));
		
		while(true) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색");
			System.out.println("4. 도서 대여하기");
			System.out.println("9. 프로그램 종료하기");
			System.out.print("메뉴 번호 : ");
			int selectNum = sc.nextInt();
			sc.nextLine();
			
			System.out.println();
			switch(selectNum) {
			case 1:
				System.out.println(lc.myInfo());
				break;
			case 2:
				selectAll();
				break;
			case 3:
				searchBook();
				break;
			case 4:
				rentBook();
				break;
			case 9:
				System.out.println("도서 대여 프로그램을 종료합니다. ");
				return;
			default: 
				System.out.println("잘못된 입력입니다. 다시 입력하세요.");
			}
			System.out.println();
		}
	
	}
	public void selectAll() {
		Book[] b = lc.selectAll();
		for(int idx=0; idx<b.length; idx++) {
			if(b[idx] == null) break;
			
			System.out.println(idx+"번 도서 : "+ b[idx].toString());
		}
	}
	
	public void searchBook() {
		System.out.print("검색할 제목 키워드 : ");
		String keyword = sc.next();
		Book[] searchedBook = lc.searchBook(keyword);
		if(searchedBook[0]==null) {
			System.out.println("검색 결과가 없습니다.");
		}
		for(int idx=0; idx<searchedBook.length; idx++) {
			if(searchedBook[idx] != null) {
				System.out.println(searchedBook[idx].toString());
			}
		}
	}
	
	public void rentBook() {
		lc.selectAll();
		System.out.print("대여할 도서 번호 선택: ");
		int rentNum = sc.nextInt();
		int rentResult = lc.rentBook(rentNum);
		switch(rentResult) {
		case 0:
			System.out.println("성공적으로 대여되었습니다.");
			break;
		case 1:
			System.out.println("나이 제한으로 대여 불가능입니다.");
			break;
		case 2:
			System.out.println("성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었으니 마이페이지에서 확인하세요.");
			break;
		default:
			System.out.println("잘못된 입력입니다. 메인 메뉴로 돌아갑니다.");
			return;
		}
	}
}
