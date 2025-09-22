package com.kh.example.oop6;

public class StudentMenu {
	
	private StudentController sc = new StudentController();
	public StudentMenu() {
		super();
		System.out.println("==========학생 정보 출력==========");
		Student[] stArr = sc.printStudent();   // Student 객체 배열을 가져옴.
		for(Student st : stArr) {
			if(sc == null) {
				break;
			}
			System.out.println(st.inform());
		}
		
		System.out.println("\n==========학생 성적 출력==========");
		double[] scoreArr = sc.avgScore();
		System.out.println("학생 점수 합계: " +scoreArr[0]);
		System.out.println("학생 점수 평균: " +scoreArr[1]);
		
		System.out.println("\n==========성적 결과 출력==========");
		for(Student st : stArr) {
			if(st.getScore() < sc.CUT_LINE) {
				System.out.println(st.getName()+"학생은 재시험 대상입니다.");
			}else
				System.out.println(st.getName()+"학생은 통과입니다.");
		}
		
	}
	
}
