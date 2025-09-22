package com.kh.practice.control;

import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("# 입력: ");
		int dice1 = sc.nextInt();
		int dice2 = sc.nextInt();
		int dice3 = sc.nextInt();
		
		int reward;
		
		if(dice1 == dice2 && dice1 == dice3) {
			reward = 10000 + dice1*1000;
		}else if(dice1 == dice2 && dice2 != dice3) {
			reward = 1000 + dice1*100;
		}else if((dice2 == dice3 && dice2 != dice1)) {
			reward = 1000 + dice2*100;
		}else if((dice1 == dice3 && dice2 != dice3)) {
			reward = 1000 + dice1*100;
		}else {
			/*
			 * if(dice1 > dice2 && dice1 > dice3) { 
			 * 			reward = dice1*100; 
			 * }else if(dice2 > dice1 && dice2 > dice3){
			 *  reward = dice2*100; 
 			*	}else reward = dice3*100;
			 */
			
			int max = dice1 > dice2 ? dice1 : dice2;
			max = max > dice3 ? dice1 : dice3;
			reward = max * 100;
			
			// import java.lang.Math -> 코드를 작성할 때 기본적으로 유용한 것들을 담아서 제공 
			// int max = Math.max(dice1, dice2);
			// max = Math.max(max, dice3);
		}
		System.out.printf("# 출력:\n%d", reward);
		sc.close();
	}

}
