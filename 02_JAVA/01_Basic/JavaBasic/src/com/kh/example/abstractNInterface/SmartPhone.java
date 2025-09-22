package com.kh.example.abstractNInterface;

public abstract class SmartPhone {
	public String maker;

	public SmartPhone() {
		super();
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}
	
	public abstract String printInformation();
}
