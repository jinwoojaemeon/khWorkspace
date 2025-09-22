package com.kh.example.inherit2;

import java.util.Scanner;

public class PersonMenu {
	private Scanner sc = new Scanner(System.in);
	private PersonController pc = new PersonController();
	
	public void mainMenu() {
		while(true){
			int pCnt[] = pc.personCount();
			System.out.println("학생은 최대 3명까지 저장할 수 있습니다.");
			System.out.printf("현재 저장된 학생은 %d명입니다.\n", pCnt[0]);
			System.out.println("사원은 최대 10명까지 저장할 수 있습니다.");
			System.out.printf("현재 저장된 사원은 %d명입니다.\n", pCnt[1]);
			
			System.out.println("1. 학생 메뉴");
			System.out.println("2. 사원 메뉴");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int selectNum = sc.nextInt();
			System.out.println();
			
			switch(selectNum) {
			case 1:
				studentMenu();
				break;
			case 2:
				employeeMenu();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	
	public void studentMenu() {
		while(true) {
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 보기");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			int selectNum = sc.nextInt();
			sc.nextLine();
			switch(selectNum) {
			case 1:
				insertStudent();
				break;
			case 2:
				printStudent();
				break;
			case 9:
				return;
			default:
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	
	public void employeeMenu() {
		while(true) {
			System.out.println("1. 사원 추가");
			System.out.println("2. 사원 보기");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			int selectNum = sc.nextInt();
			sc.nextLine();
			switch(selectNum) {
			case 1:
				insertEmployee();
				break;
			case 2:
				printEmployee();
				break;
			case 9:
				return;
			default:
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	
	public void insertStudent() {
		int pCnt[] = pc.personCount();
		while(true) {
			if(pCnt[0] >= 3) {
				System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가를 종료하고 학생 메뉴로 돌아갑니다.");
				break;
			}
			System.out.print("학생 이름 : ");
			String sName = sc.next();
			System.out.print("학생 나이 : ");
			int sAge = sc.nextInt();
			System.out.print("학생 키 : ");
			double sHeight = sc.nextDouble(); 
			System.out.print("학생 몸무게 : ");
			double sWeigth = sc.nextDouble();
			System.out.print("학생 학년 : ");
			int sGarde = sc.nextInt();
			System.out.print("학생 전공 : ");
			String sMajor = sc.next();
			pc.insertStudent(sName, sAge, sHeight, sWeigth, sGarde, sMajor);
			pCnt[0]++;
			System.out.print("그만하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 : ");
			char isStop = sc.next().toUpperCase().charAt(0);
			if(isStop == 'N') break;
		}
	}
	
	public void printStudent() {
		Student[] s = pc.printStudent();
		for(Student st : s) {
			if(st == null) {
				break;
			}
			System.out.println(st.toString());
		}
	}
	
	public void insertEmployee() {
		int pCnt[] = pc.personCount();
		while(true) {
			if(pCnt[1] >= 10) {
				System.out.println("사원을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가를 종료하고 학생 메뉴로 돌아갑니다.");
				break;
			}
			System.out.print("사원 이름 : ");
			String eName = sc.next();
			System.out.print("사원 나이 : ");
			int eAge = sc.nextInt();
			System.out.print("사원 키 : ");
			double eHeight = sc.nextDouble(); 
			System.out.print("사원 몸무게 : ");
			double eWeigth = sc.nextDouble();
			System.out.print("사원 급여 : ");
			int eSalary = sc.nextInt();
			System.out.print("사원 부서 : ");
			String eDept = sc.next();
			pc.insertEmployee(eName, eAge, eHeight, eWeigth, eSalary, eDept);
			pCnt[1]++;
			System.out.print("그만하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 : ");
			char isStop = sc.next().toUpperCase().charAt(0);
			if(isStop == 'N') break;
		}
	}
	
	public void printEmployee() {
		Employee[] e = pc.printEmployee();
		for(Employee ep : e) {
			if(ep == null) {
				break;
			}
			System.out.println(ep.toString());
		}
	}
}
