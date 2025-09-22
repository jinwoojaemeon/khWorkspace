package com.kh.example.exception1;

import java.util.Scanner;

public class CharacterMenu {
	public void menu() {
		System.out.print("문자열 : ");
		
		try(Scanner sc = new Scanner(System.in)){	
			String str = sc.nextLine();
			int count = new CharacterController().countAlpha(str);
			System.out.println(str+ "에 포함된 영문자 개수 : "+count);
		} catch (CharCheckException e) {
			e.printStackTrace();
		}
		
	}
}
