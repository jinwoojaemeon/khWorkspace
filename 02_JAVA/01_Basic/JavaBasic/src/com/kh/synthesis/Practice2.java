package com.kh.synthesis;

import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		boolean pallindrome = true;
		
		/*
		 * for(int i=0, j=str.length()-1; i < j; i++, j--)
		 */
		for(int i=0; i<(str.length()/2); i++) {
			if(str.charAt(i) != str.charAt(str.length()-i-1)) {
				pallindrome = false;
				break;
			}
		}
		
		System.out.println(pallindrome ? 1 : 0);
		sc.close();
	}

}
