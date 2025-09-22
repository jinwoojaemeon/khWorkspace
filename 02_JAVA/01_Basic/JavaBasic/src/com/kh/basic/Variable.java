package com.kh.basic;

public class Variable {
	/*
	 * 변수 : 값을 기록하고 사용하기 위한 메모리 공간
	 * 
	 * [표현식]
	 * 자료형 변수이름;
	 * 
	 * 자료형 : 변수가 사용할 메모리 크기에 따라서 지정 
	 * 변수이름 : 변수를 식별하기 위해 붙여주는 이름 
	 * */
	
	public static void main(String[] args) {
		// 정수형 변수 num을 선언
		int num;   
		num = 10;	 // 정수형 변수 num에 10이라는 값을 대입해라  => 초기화 
		System.out.println(num);
		
		//참과 거짓을 표현하는 자료형으로 isTrue라는 이름의 변수를 선언
		boolean isTrue = false;  // 선언과 동시에 false라는 값을 대입 
		isTrue = true;
		System.out.println(isTrue);
		
		//실수형(소숫점 6자리 까지 사용) 자료형으로 num2라는 이름의 변수를 선언
		float num2; 
		num2 = 3.1415926352321f;
		System.out.println(num2);
		System.out.printf("%.6f\n", num2);
		
		/********************************************************************************
		 * 원시타입 : 가장 기본적인 데이터 타입, 값 자체를 저장하며 추가적인 속성이 없다.               *
		 *
		 * 정수 자료형 : byte(1) short(2) int(4) long(8) 
		 *    모두 정수를 저장하는 자료형, 각 자료 마다 저장할 수 있는 수의 범위가 다르다.
		 *    
		 * 정수 리터럴의 기본값 : int
		 * byte, short은 범위 내에 있을 경우 자동 형변환된다. 
		 ********************************************************************************/
		int integer = 10;
		byte by = 10; 
		short sh = 10;
		long lo = 10;
		
		System.out.println("정수 자료형");
		System.out.printf("%d %d %d %d\n", integer, by, sh, lo);
		
		/*
		 * 실수 자료형 float(4) double(8)
		 * 실수를 저장하는 자료형, float보다 double이 더 정밀하게 표현할 수 있다.
		 * */
		float fl = 4.24f;   // 리터럴 기본값이 double이기 때문에 float를 가리키는 f를 실수 뒤로 붙여준다.
		double dou = 4.24;
		System.out.println("실수 자료형");
		System.out.println(fl + "," + dou);
		
		/*
		 * 문자 자료형 char(2)
		 * 문자 하나를 담을 수 있는 자료형 'a'
		 * Java는 2byte 유니코드를 사용한다.
		 * */
		char c1 = '홍';
		char c2 = '길';
		char c3 = '동';
		System.out.println(c1 + c2 + c3);    // char라도 숫자로 저장되기 때문에 연산 시 int로 형변환이 일어난 결과값이 숫자가 나온다.
		System.out.println(c1 + ""+ c2 + "" + c3);
		System.out.println("" + c1 + c2 + c3);  
		System.out.println(c2);
		System.out.println((int)c2);
		
		/*
		 * 논리 자료형
		 * boolean(1)
		 * true와 false를 저장하는 자료형 
		 * */
		boolean b1 = 10 > 5;   // true
		boolean b2 = 2 > 5;    // false
		System.out.println(b1 +" , "+ b2);
		
		// 객체 타입 - 앞글자가 대문자로 시작한다.  String, Class이름 ...
		/*
		 * 문자열
		 * String 
		 * 문자열 같은 경우 할당할 메모리 크기가 가변적이므로 원시 타입이 아닌 객체 타입을 사용한다. 
		 * 
		 * 원래 객체를 만드는 방식
		 * String 변수명 = new 클래스명(초기값); 
		 * 
		 * 문자열은 특별한 객체로 원시 타입과 동일하게 생성하고 사용할 수 있다.
		 */
		
		String str1 = "가나다라마바사아자차카abcdefghijklmnopq";
		System.out.println(str1);
		String str2 = "참조 변수";
		str2 = "참조 변수에 대해서 알아보자";
		str2 = null; // String의 변수는 참조 변수이기 때문에 기본값이 null이고 빈 값을 표현하기 위해 null을 대입할 수 있다.
		
		System.out.println(str2);
		
		/*
		 * Escape sequence
		 * 문자열 내에서 탭, 백슬래시. 작은따옴표 등을 사용하기 위한 방식이다.
		 */
		
		// 탭문자, \t   가로로 일정 간격을 띄운다.
		System.out.println("이름     나이     주소");
		System.out.println("이름\t나이\t주소");
		
		// \\ : 백슬래시(\) 문자 자체를 출력하고 싶을 때 쓰는 방식
		System.out.println("경로 C:\\devtool ");
		
		// \' : 작은 따옴표, \" : 쌍 따옴표 
		// 문자 형에서 '을 그래로 쓰면 구문오류
		System.out.println("오늘은 '금요일' 입니다.");
		System.out.println('\''+'\"');
		
		// \n : 개행문자 
		// 줄 바꿈을 하고 싶을 때 사용하는 방식 
		
		/*
		 * 상수
		 * 한 번만 쓸 수 있는 메모리 공간
		 *  >>> 한 번 선언하면 바꿀 수 없다
		 *  
		 *  [표현법]
		 *  final 자료형 변수이름;
		 *
		 *	상수의 변수이름은 모두 대문자로 짓는 것이 일반적이다. 
		 *	대문자로 작성하되 스네이크 케이스를 사용한다. 
		 */
		
		final int AGE;
		AGE = 30;
		// AGE = 33;  -- 한번 선언하면 초기화 할 수 없다.  
		System.out.println(AGE);
		
		/*
		 * 프로그래밍에서 이름 짓는 방식 
		 *  카멜케이스 : 단어를 나열하며 이름을 짓되, 두번째 단어부터는 단어의 첫글자를 대문자로 짓는다.
		 *  ex ) userName,  totalPrice,  MaxAvgGrade ... 
		 *  파스칼케이스 : 객체(클래스) 이름을 지을 때 카멜 케이스에서 첫단어의 첫글자도 대문자로 작성한다. 
		 *  ex) UserName, TotalPrice
		 *  
		 *  스네이크케이스 : 문자와 문자 사이에 언더스코어(_)를 통해서 이어주는 방식 (python에서 주로 사용)
		 *  ex ) user_name, total_price
		 *  
		 *  대문자스네이크케이스(?) : 스네이스케이스 + 모두 대문자 (주로 상수명)
		 *  ex) MAX_COUNT
		 *  
		 *  케밥케이스 : 단어를 소문자로 작성하되 문자와 문자 사이를 하이픈(-)으로 이어주는 방식(html, url, 설정파일 등...  자바에선 불가능)
		 *  ex) user-name 
		 */
		
	}
}
