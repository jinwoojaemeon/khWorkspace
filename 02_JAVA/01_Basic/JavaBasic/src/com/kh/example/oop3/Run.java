package com.kh.example.oop3;

public class Run {

	public static void main(String[] args) {
		Book b1 = new Book();
		b1.inform();
		System.out.println("====================");
		Book b3 = new Book("원피스","챔스","오다");
		b3.inform();
		System.out.println("====================");
		Book b5 = new Book("원피스앤토루코","챔스","오다",8000,0.3);
		b5.inform();
	}

}
