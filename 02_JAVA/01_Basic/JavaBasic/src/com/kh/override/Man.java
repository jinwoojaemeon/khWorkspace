package com.kh.override;

import java.util.Objects;

public class Man {		
	private String name;
	private String number;
	
	public Man(String name, String number) {
		super();
		this.name = name;
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Man [name=" + name + ", number=" + number + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, number);
	}
	@Override
	public boolean equals(Object obj) {
		return this.number == ((Man)obj).getNumber();
	}
	
	
	
	
	
}
