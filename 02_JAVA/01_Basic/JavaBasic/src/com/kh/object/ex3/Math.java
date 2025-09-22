package com.kh.object.ex3;

public class Math {
	int adder(int n) {
		return n + n;
	}
	
	int adder(int n1, int n2) {
		return n1+n2;
	}
	
	double adder(double n1, double n2) {
		return n1+n2;
	}
	
	String adder(int n1, String str) {
		String addResult = n1 + str;
		return addResult;
	}
	
	String adder(String str, int n1) {
		String addResult = n1 + str;
		return addResult;
	}
}
