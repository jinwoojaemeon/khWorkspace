package com.kh.example.oop3;

public class Book {
		//앞으로 필드는(private) -> 정보은닉
		private String title; //제목
		private String publisher; //장르 
		private String author; //저자
		private int price; // 페이지수
		private double discountRate;
		
		public Book() {
			super();
		}
		public Book(String title, String publisher, String author) {
			this(title, publisher, author, 0, 0.0);
		}
		public Book(String title, String publisher, String author, int price, double discountRate) {
			super();
			this.title = title;
			this.publisher = publisher;
			this.author = author;
			this.price = price;
			this.discountRate = discountRate;
		}
		
		void inform() {
			System.out.println("제목 :" + title);
			System.out.println("출판사 :" + publisher);
			System.out.println("저자 :" + author);
			System.out.println("가격 :" + price);
			System.out.println("할인율 :" + discountRate);
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getPublisher() {
			return publisher;
		}
		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public double getDiscountRate() {
			return discountRate;
		}
		public void setDiscountRate(double discountRate) {
			this.discountRate = discountRate;
		}
		
		
		
}
