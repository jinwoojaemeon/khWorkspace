package operator;

public class Operator3 {

	public static void main(String[] args) {
		/*
		 * 산술연산자  + - *  / %
		 * 
		 * 복합대입연산자
		 * 산술연산자와 대입연산자를 결합하여 사용
		 * += -= *= /= %= 
		 * 
		 */
		int a = 5;
		int b = 10;
		int c = (++a) + b;
		int d = 16 / 6;
		int e = c % a;
		int f = e++;
		int g = (--b) + (--d);
		int h = 2;
		int i = (a++) + b / (--c/f) * (g-- - d) % (++e + h); 
		
		System.out.println(i);
	}

}
