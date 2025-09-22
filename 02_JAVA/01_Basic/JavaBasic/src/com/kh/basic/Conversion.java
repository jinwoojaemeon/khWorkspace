package com.kh.basic;
public class Conversion {

	public static void main(String[] args) {
		double dPi = 3.1415;
		int iNum = (int)dPi;
		System.out.println(iNum);
		
		char a = 'a';
		System.out.println("a : " + a);
		System.out.println("a : " + (int)a);
		System.out.println("a : " + (int)(a+1) + " " +(char)(a+1));
		System.out.println((char)98);
		
		long num1 = 30000007L;
		int num2 = (int)num1;
		System.out.println(num2);
		num1= 3030301302031032L;
		num2 = (int)num1;
		System.out.println(num2);    //  전혀 다른 값이 나온다. 
	}
}
