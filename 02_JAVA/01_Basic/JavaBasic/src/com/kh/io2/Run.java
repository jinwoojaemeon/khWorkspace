package com.kh.io2;

public class Run {
/*
 *  자바 스트림 개념
 *   - 프로그램과 외부매체 (파일, 네트웤, 콘솔...)
 *   - 데이터를 순차적으로 흘려보내는 파이프같은 구조. queue (FIFO)
 *   
 *   스트림의 특징
 *   1. 단방향 : 입력이면 입력만, 출력이면 출력만 가능 -> 동시에 원하면 각각 만들어줘야한다.
 *   2. 순차적 처리(FIFO : First In First Out) : 먼저 보낸 데이터가 먼저 나온다.
 *   3. 시간 지연 가능성 : 외부 매체와 연결되므로 입출력 속도가 상대적으로 느낄 수 있다.
 *   
 *    스트림의 구분 
 *    > 데이터 단위에 따른 구분(바이트스트림(1byte), 문자스트림(2byte)) 
 *      바이트 스트림(Input, Output) : 이미지, 동영상, binary데이터 등 ... 
 *      문자 스트림(Reader, Writer) : 텍스트 데이터(문자/문자열)...
 *      
 *    > 외부 매체 연결 방식에 따른 구분
 *      기반 스트림 : 외부 매체와 직접 연결되는 스트림(필수, 단독사용가능)
 *      보조 스트림 : 기반 스트림을 감싸 성능 향상이나 기능 추가 제공 (단독 사용 불가, 반드시 기반 스트림과 함께 사용)    
 */
	
	public static void main(String[] args) {	
		new serveStream().fileSave();
		new serveStream().fileRead();
		new serveStream().objectSave();
		new serveStream().objectRead();
	}

}
