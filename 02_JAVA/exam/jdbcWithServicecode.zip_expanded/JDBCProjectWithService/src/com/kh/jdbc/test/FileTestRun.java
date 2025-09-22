package com.kh.jdbc.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileTestRun {
	public static void main(String[] args) {
		/* 
		 * Properties
		 * Properties 클래스는 Map 계열의 컬렉션으로, Key-Value 형식으로 데이터를 저장/읽기 할 수 있다.
		 * 특히 외부파일(.Properties / .xml)을 통해서 데이터를 쉽게 관리하고 불러올 수 있다.
		 * 
		 * DB연결정보(Connection), 프로그램 설정정보(port, 환경변수 ... ), sql Query문 등을 코드와 분리해서 관리할 때 주로 사용한다.
		 */
		/*
		// 파일로 출력
		Properties prop = new Properties();
		prop.setProperty("C", "CREATE");  // CREATE 데이터 생성
		prop.setProperty("R", "READ");    // READ   데이터 조회
		prop.setProperty("U", "UPDATE");  // UPDATE 데이터 수정
		prop.setProperty("D", "DELETE");  // DELETE 데이터 삭제
		
		try {
			//prop.store() -> properties 파일로 객체의 정보를 저장하겠다
			//.properties -> 단순 텍스트 파일 (Key-Value 형식)
			prop.store(new FileOutputStream("resources/driver.properties"), "properties test");// 첫번째는 어디에 저장할 것인지. 
			//prop.storeToXML() .xml 파일로 객체의 정보를 저장하겠다.
			//.xml 파일 -> xml 형식 문서 (<태그> 구조)
			// -> dtd : xml 문서의 구조와 규칙을 정의한 문서
			prop.storeToXML(new FileOutputStream("resources/query.xml"), null);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		*/
		
		// 파일로부터 값을 읽어오기
		Properties prop = new Properties();
		Properties propXml = new Properties();
		try {
			prop.load(new FileInputStream("resources/driver.properties"));
			
			System.out.println(prop.getProperty("driver"));
			System.out.println(prop.getProperty("url"));
			System.out.println(prop.getProperty("username"));
			System.out.println(prop.getProperty("password"));
			System.out.println("====================================");
			propXml.loadFromXML(new FileInputStream("resources/query.xml"));
			System.out.println(propXml.getProperty("C"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
