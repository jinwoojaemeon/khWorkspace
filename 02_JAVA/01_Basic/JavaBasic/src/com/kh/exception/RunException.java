package com.kh.exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RunException {
	Scanner sc = null;
	public void method1() {
		try {
			sc = new Scanner(System.in);
			System.out.print("a/b...a : ");
			int a= sc.nextInt();
			System.out.print("a/b...b : ");
			int b= sc.nextInt();
			System.out.printf("%d / %d = %d ", a,b,a/b);
			System.out.println("꼐산완료");
		} catch(ArithmeticException e){
			System.out.println("수학적 에러 발생" + e.getMessage());
		} catch(InputMismatchException e) {
			System.out.println("미스 매치 에러 발생");
			e.printStackTrace();
		}finally { // 에러가 발생하건 안하건 마지막에 실행해주는 코드
			sc.close(); 
		}
	}
	
	// 2. throws : 여기서 예외를 처리하지 않고 현재 이 매서드를 호출한 곳으로 예외처리를 위임한다. 
	public void method2() {
		//CheckedException : 반드시 예외처리를 해야하는 예외들(강제되어 안할 수 없다)
		// -> 조건문을 미리 제시할 수 없다.. (예측이 불가한 문제가 많다)
		// -> 외부 매개체와 입출력이 일어날 때 발생할 수 있다
		
		//Scanner와 같이  키보드로 입력받은 값을 코드로 가져와주는 객체(단, 문자열로만 읽어들인다.)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = null;
		try {
			// 이 시점에 바로 예외를 처리해야하거나 또는 예외를 동일하게 위임하면 된다.
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(str);
	}
	
	public void methodA() throws IOException, CustomException{
		methodB();
	}
	public void methodB() throws IOException, CustomException{
//		methodC();
		methodD();
	}
	public void methodC() throws IOException{
		throw new IOException();
	}
	public void methodD() throws CustomException{
		throw new CustomException("커스텀 에러 발생");
	}

}
