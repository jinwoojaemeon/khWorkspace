package operator;

public class Operator2 {
	public static void main(String[] args) {
		/*
		 * 증감연산자
		 *  ++ : 변수에 담긴 값을 1 증가 시켜주는 연산자
		 *  -- : 변수에 담긴 값을 1 감소 시켜주는 연산자
		 *  
		 *  (증감 연산)변수 : 전위연산 -> 선 증감, 후 처리
		 *  변수(증감 연산) : 후위연산 -> 선 처리, 후 증감 
		 */
		
		int num1 = 0;
		System.out.println(num1++);
		System.out.println(++num1);
		System.out.println(num1--);
		System.out.println(++num1);
		System.out.println(++num1);
		System.out.println(num1++);
		System.out.println(num1--);
		System.out.println(--num1);
		System.out.println(--num1);
	}
	
}
