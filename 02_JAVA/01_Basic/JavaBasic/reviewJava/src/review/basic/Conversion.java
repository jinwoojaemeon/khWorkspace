package review.basic;

public class Conversion {
	public static void main(String[] args) {
		long num1 = 3030301302031032L; // 매우 큰 값 
		int num2 = (int)num1; // 강제 형변환 
		System.out.println(num1);
		System.out.println(num2); // 전혀 다른 값!
	}
}
