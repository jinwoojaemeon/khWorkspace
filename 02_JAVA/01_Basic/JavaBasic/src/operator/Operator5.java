package operator;
import java.util.Scanner;
public class Operator5 {
	/*
	 * 논리 연산자
	 * 두 개의 논리값을 연산해주는 연산자.
	 * 논리연산자의 결과도 논리값.
	 * 
	 * 논리값 && 논리값 : 왼쪽 오른쪽의 조건이 모두 true일 경우 결과는 true
	 * 논리값 || 논릭밧 : 왼쪽, 오른쪽의 조건 중 하나라도 true인 경우 결과는 true
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		/*//사용자에게 숫자를 입력 받아 해당 숫자가 1~100 사이 값인지 확인
		int num;
		System.out.print("숫자 입력 >>> ");
		num = sc.nextInt();
		
		boolean result = num >= 1 && num <= 100;
		System.out.println("사용자가 입력한 값은 1이상 100 이하이다. :  " + result);
		*/
		
		// 사용자에게 알파벳 하나를 입력받아 대소문자를 확인
		char ch;
		System.out.print("문자 하나 입력 : ");
		ch = sc.next().charAt(0);   // charAt(index)next()로 String을 입력받아 charAt의 N번째 값 추출
		//System.out.println((int)'A' + " " + (int)'Z');
		boolean result1 = ch >= 'A' && ch <= 'Z';   // 대문자
		boolean result2 = ch >= 'a' && ch <= 'z';   // 소문자
		// 둘 다 거짓 : a~z , A~Z 사이에 있는 알파벳이 아닌 다른 문자이다.
		System.out.println("사용자가 입력한 값은 알파벳인가? " + (result1||result2));
		System.out.println("사용자가 입력한 값은 대문자인가? " + result1);
		System.out.println("사용자가 입력한 값은 소문자인가? " + result2);		
		sc.close();
	}
}
