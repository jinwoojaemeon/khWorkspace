package com.kh.inherit;

public class Desktop extends Product{
	private boolean isAllInOne;
	
	
	
	public Desktop() {
		
	}


	public Desktop(String pName, int price, String brand, boolean isAllInOne) {
		super(pName, price, brand);
		this.isAllInOne = isAllInOne;
	}

	
	public boolean isAIO(){
		return isAllInOne;
	}


	public boolean isAllInOne() {
		return isAllInOne;
	}


	public void setAllInOne(boolean isAllInOne) {
		this.isAllInOne = isAllInOne;
	}
	
	public String inform() {
		return "상품명 : " + super.getpName() + " / 가격 : " + super.getPrice() + " / 브랜드 : " + super.getBrand() + " / 일체형 여부 : " + (isAllInOne? "일체형":"따로따로"); 
	}
	
}
