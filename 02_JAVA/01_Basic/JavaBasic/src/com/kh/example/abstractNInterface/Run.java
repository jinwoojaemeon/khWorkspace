package com.kh.example.abstractNInterface;
public class Run {
	public static void main(String[] args) {
		String[] phoneArr = new PhoneController().method();
		for(String s : phoneArr) {
			System.out.println(s);
			System.out.println();
		}
	}
}
