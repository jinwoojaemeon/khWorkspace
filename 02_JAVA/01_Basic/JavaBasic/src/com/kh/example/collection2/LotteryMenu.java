package com.kh.example.collection2;

import java.util.HashSet;
import java.util.Scanner;

public class LotteryMenu {
	private final Scanner sc = new Scanner(System.in);
    private final LotteryController lc = new LotteryController();
    
    public void mainMenu() {
        while(true) {
        	System.out.println("========== KH 추첨 프로그램 ==========");
            // ***** 메인 메뉴 *****
            // 1. 추첨 대상 추가       -> insertObject()
            // 2. 추첨 대상 삭제       -> deleteObject()
            // 3. 당첨 대상 확인       -> winObject()
            // 4. 정렬된 당첨 대상 확인 -> sortedWinObject()
            // 5. 당첨 대상 검색       -> searchWinner()
            // 9. 종료                 -> "프로그램 종료."
            // 잘못 입력 시 재입력 유도, 반복
            System.out.println("1. 추첨 대상 추가");
            System.out.println("2. 추첨 대상 삭제");
            System.out.println("3. 당첨 대상 확인");
            System.out.println("4. 정렬된 당첨 대상 확인");
            System.out.println("5. 당첨 대상 검색");
            System.out.println("9. 종료");
            System.out.print("메뉴 번호 입력 : ");
            int selectNum = sc.nextInt();
            sc.nextLine();
            switch(selectNum) {
            case 1: insertObject(); break;
            case 2:deleteObject(); break;
            case 3:winObject(); break;
            case 4:sortedWinObject(); break;
            case 5:searchWinner(); break;
            case 9: System.out.println("프로그램 종료"); return;
            default : System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
            System.out.println();
        }
    }
    
    public void insertObject() {
    	System.out.print("추가할 추첨 대상 수 : ");
    	int num = sc.nextInt();
    	sc.nextLine();
    	
    	for(int i=0;i<num;i++) {
    		System.out.print("이름 : ");
    		String name = sc.next();
    		System.out.print("핸드폰 번호('-'빼고) : ");
    		String phone = sc.next();
    		Lottery l = new Lottery(name, phone);
    		boolean result = lc.insertObject(l);
    		if(!result) {
    			System.out.println("중복된 인원입니다. 다시 입력합니다.");
    			i--;
    		}	
    	}
    	System.out.println(num + "명 추가 완료되었습니다.");
    }
    public void deleteObject() {
    	System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("핸드폰 번호('-'빼고) : ");
		String phone = sc.next();
		Lottery l = new Lottery(name, phone);
		boolean result = lc.deleteObject(l);
		
		System.out.println(result ? "삭제 완료되었습니다." : "존재하지 않는 대상입니다");
    }
    
    public void winObject() {
    	HashSet<Lottery> win = lc.winObject();
    	System.out.println(win);
    }
    
    public void sortedWinObject() {
    	
    }
    
    public void searchWinner() {
    	System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("핸드폰 번호('-'빼고) : ");
		String phone = sc.next();
		Lottery l = new Lottery(name, phone);
		boolean result = lc.searchWinner(l);
		System.out.println(result ? "축하합니다. 당첨 목록에 존재합니다." : "안타깝지만 당첨 목록에 존재하지 않습니다.");
    }
    
}
