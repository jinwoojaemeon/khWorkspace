package com.kh.example.gearrent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GearRentMenu {
	GearRentController gc = new GearRentController();
	Scanner sc =new Scanner(System.in);
	
	public void mainMenu() {
		while(true) {
			System.out.println("=== KH 장비 대여 관리 ===");
			System.out.println("1) 장비등록  2) 회원등록  3) 대여  4) 반납  5) 태그검색");
			System.out.println("6) 키워드검색  7) 전체장비  8) 대여중목록  9) 종료");
			System.out.print("메뉴 : ");
			int selectNum = sc.nextInt();
			sc.nextLine();
			
			switch(selectNum) {
			case 1: addDevice();  break;
			case 2: addMember();  break;
			case 3: borrow();  break;
			case 4: returnItem();  break;
			case 5: findByTag();  break;
			case 6: findByKeyword();  break;
			case 7: printAllDevices();  break;
			case 8: printActiveLoans();  break;
			case 9: System.out.println("프로그램을 종료합니다.");  return;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
			}
			System.out.println();
		}
	}
	
	public void addDevice() {
		System.out.print("유형(1:Camera, 2:Laptop): ");
		int type = sc.nextInt();
		sc.nextLine();
		if(type < 1 || type > 2) {
			System.out.println("잘못된 입력");
			return;
		}
		System.out.print("id: ");
		String id = sc.next();
		System.out.print("name: ");
		String name = sc.next();
		System.out.print("category: ");
		String category = sc.next();
		System.out.print("tags(쉼표로 구분): ");
		String strtags = sc.next();
		StringTokenizer stn = new StringTokenizer(strtags.trim(), ",");
		HashSet<String> tags = new HashSet<>(); 
		while(stn.hasMoreElements()) {
			tags.add(stn.nextToken());
		}
		boolean result;
		if(type == 1) {
			 result = gc.addDevice(new Camera(id, name, category, tags));
			 if(result) {
				System.out.println("등록 완료");
			 	return;
			}else {
				System.out.println("중복된 ID입니다. 다시 입력해주세요.");
				return;
			}
				
			
		}else if(type == 2) {
			 result = gc.addDevice(new Laptop(id, name, category, tags));
			 if(result) {
				 System.out.println("등록 완료");
				 return;
			 }else {
				System.out.println("중복된 ID입니다. 다시 입력해주세요.");
				return;
			}
			 
		}
		
		
	}
	
	public void addMember() {
		System.out.print("member id: ");
		String id = sc.next();
		System.out.print("name: ");
		String name = sc.next();
		boolean result = gc.addMember(new Member(id, name));
		if(result) {
			System.out.println("가입 완료");
			return;
		}
		System.out.println("중복된 ID입니다. 다시 입력해주세요.");
		
	}
	
	public void borrow() {
		 System.out.print("회원 ID: ");
		 String memberId = sc.next();
		 System.out.print("장비 ID: ");
		 String itemId = sc.next();
		 System.out.print("대여일 (YYYY-MM-DD): ");
		 String dateStr = sc.next();
	    try {
	    	LocalDate loanDate = LocalDate.parse(dateStr);
	    	Loan loan = gc.borrow(memberId, itemId, loanDate);
	    	System.out.println("대여 완료: " + loan);
	    	System.out.println("반납 예정일: " + loan.getDueDate());
		    } catch (Exception e) {
		        System.out.println("대여 실패: " + e.getMessage());
		    }
	}

	public void returnItem() {
	    System.out.print("장비 ID: ");
	    String itemId = sc.next();
	    System.out.print("반납일 (YYYY-MM-DD): ");
	    String dateStr = sc.next();
	    
	    String[] parts = dateStr.split("-");
	    int year = Integer.parseInt(parts[0]);
	    int month = Integer.parseInt(parts[1]);
	    int day = Integer.parseInt(parts[2]);
	    
	    LocalDate returnDate = LocalDate.of(year, month, day);
	    int fee = gc.returnItem(itemId, returnDate);
	    System.out.println("반납 완료. 연체료: " + fee + "원");
	}

	public void findByTag() {
	    System.out.print("검색할 태그: ");
	    String tag = sc.next();
	    
	    ArrayList<Device> result = gc.findByTag(tag);
	    
	    if (result.isEmpty()) {
	        System.out.println("결과 없음");
	    } else {
	        for (Device device : result) {
	            System.out.println(device);
	        }
	    }
	}

	public void findByKeyword() {
	    System.out.print("검색 키워드: ");
	    String keyword = sc.next();
	    
	    ArrayList<Device> result = gc.findByKeyword(keyword);
	    
	    if (result.isEmpty()) {
	        System.out.println("조회 결과가 없습니다.");
	    } else {
	        for (Device device : result) {
	            System.out.println(device);
	        }
	    }
	}

	public void printAllDevices() {
	    Collection<Device> devices = gc.getAllDevices();
	    if (devices.isEmpty()) {
	        System.out.println("조회 결과가 없습니다.");
	    } else {
		    for (Device device : devices) {
		        System.out.println(device);
		    }
	    }
	}

	public void printActiveLoans() {
	    Collection<Loan> loans = gc.getActiveLoans();
	    if(loans.isEmpty()) {
	    	System.out.println("조회 결과가 없습니다.");
	    }else {
		    for (Loan loan : loans) {
		        System.out.println(loan);
		    }
	    }
	}
}
