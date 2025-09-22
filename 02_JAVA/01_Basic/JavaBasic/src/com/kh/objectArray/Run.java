package com.kh.objectArray;

public class Run {
	/*
	 * 객체 배열 
	 * 같은 타입의 객체 여러 개를 하나의 배열에 저장해서 관리하는 것 
	 *  배열의 각 요소가 개체 자체를 저장하는게 아니라 객체의 주소(참조값)를 저장한다.
	 *  	배열 생성 시 객체까지 자동으로 생성되는 것이 아니라 각 요소의 객체를 직접 생성해서 넣어야한다.
	 */
	public static void main(String[] args) {
		
		//1. 객체 배열 선언 및 생성
		Book[] books = new Book[3];
		for(Book b : books) {
			System.out.print(b+" ");
		}
		System.out.println();
		//2.
		books[0] = new Book();
		books[1] = new Book();
		books[2] = new Book();
		for(Book b : books) {
			System.out.print(b+" ");
		}
	}

}
