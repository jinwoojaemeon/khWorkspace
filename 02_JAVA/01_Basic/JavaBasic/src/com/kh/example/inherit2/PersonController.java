package com.kh.example.inherit2;

public class PersonController {
	private Student[] s = new Student[3];
	private Employee[] e = new Employee[10];
	
	public int[] personCount() {
		int cnt=0;
		int[] pCnt = new int[2];
		for(Student st : s) {
			if(st == null) {
				break;
			}
			cnt++;
		}
		pCnt[0] = cnt;
		
		cnt=0;
		for(Employee emp : e) {
			if(emp == null) {
				break;
			}
			cnt++;
		}
		pCnt[1] = cnt;
		return pCnt;
		//return new int[]{stCnt, empCnt}; 각각 따로 센 카운트를 담고, return과 함께 배열 초기화 
	}
	
	public void insertStudent(String name, int age, double height, double weight, int grade, String major) {
		for(int i=0; i<s.length; i++) {
			if(s[i] == null) {
				s[i] = new Student(name, age, height, weight, grade, major);
				break;
			}
		}
	}
	
	public Student[] printStudent() {
		return s;
	}
	
	public void insertEmployee(String name, int age, double height, double weight, int salary, String dept) {
		for(int i=0; i<e.length; i++) {
			if(e[i] == null) {
				e[i] = new Employee(name, age, height, weight, salary, dept);
				break;
			}
		}
	}
	
	public Employee[] printEmployee() {
		return e;
	}
}
