package com.kh.thread.multi;

public class Task1 extends Thread{
	//20이하의 짝수 
	@Override
	public void run() {
		try {
			for(int i = 1; i<=20; i++) {
				if(i%2 == 0) {
					System.out.print(i + " ");
				}
			}
			Thread.sleep(40000);
		}
			catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
