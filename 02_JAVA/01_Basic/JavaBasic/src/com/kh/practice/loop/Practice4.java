package com.kh.practice.loop;

public class Practice4 {

	public static void main(String[] args) {
		for(int i=1; i<=100; i++) {
			if(i%2 == 0) {
				continue;
			}
			else if(i%7 != 0) {
				continue;
			}
			System.out.print(i +" ");
		}
	}
}
