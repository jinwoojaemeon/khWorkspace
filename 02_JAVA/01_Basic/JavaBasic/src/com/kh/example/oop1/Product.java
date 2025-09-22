package com.kh.example.oop1;

public class Product {
	private String pName = "텀블러";
	private int price= 23000;
	private String brand= "stanley";
	
	public Product() {}
	
	public void information() {
		System.out.printf("제품명: %s\n가격: %d\n브랜드명: %s", pName, price, brand);
	}
	
}
