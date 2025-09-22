package com.kh.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Run {
	/*
	 * 컬렉션
	 * 자료구조 개념이 내장되어있는 클래스로 자바에서 제공하는 라이브러리이다.
	 * 
	 * - 자료구조 : 데이터를 보다 효율적으로 관리(추가, 삭제, 조회, 정렬, 수정 ...)할 수 있도록 해주는 구조
	 */
	public static void main(String[] args) {
		/*List(순서가 존재, 중복 허용)
		 * ArrayList(배열기반), LinkedList(노드기반), Vector, Stack(Vector 기반 LIFO구조)
		 */
		List list = new ArrayList();  // 크기를 지정하지 않아도 된다.   && LinkedList도 똑같이 사용한다    
		System.out.println(list);      // 빈 배열 상태
		
		// 1. add(E e) : 리스트 공간 끝에 전달된 데이터를 추가 
		list.add(new Human("Karina", 26));
		list.add(new String("Winter"));  // 여러 타입을 저장할 수 있다.
		list.add(new Human("Gigell", 26));
		list.add(new Human("NingNing", 24));
		System.out.println(list);
	 
		// 장점 1. 크기제약 x  -  지정된 크기보다 더 많이 추가해도 에러가 발생하지 않음. 
		// 장점 2. 여러타입 보관가능 다양한 타입의 테이터를 담을 수 있음. 
		
		// 2. add(int index, E e)
		list.add(1, new Human("IAN", 17));
		System.out.println(list);
		
		// 3. remove(int index) : 해당 인덱스 위치의 데이터를 삭제시켜주는 매서드
		list.remove(1);
		System.out.println(list);
		
		// 4. remove(E e) : 객체를 직접 지정해서 삭제 ( 사용을 위해서는 객체의 equals를 적절하게 오버라이딩 해줘야 정상적으로 삭제가 된다. )
		list.remove("Winter");
		list.remove(new Human("Gigell", 26));  // equals 오버라이딩 이후 삭제
		System.out.println(list);  
		
		// 5. set(int index, E e) : 해당 인덱스의 값을 전달받은 e객체로 덮어씌움
		list.set(0, new Human("Winter",25));
		System.out.println(list);     
		
		// 6. size() : 리스트의 사용중인 사이즈를 반환
		System.out.println("list의 크기 : "+list.size());
		
		// 7. get(int index) : 해당 인덱스의 객체를 반환
		System.out.println(list.get(1));
		
		// 8. addAll(Collection c) : 컬렉션을 통째로 뒤에 추가할 수 있음.
		List sub = new ArrayList();
		sub.add("Karina");
		sub.add(new Human("Gigell", 26));
		list.addAll(sub);
		System.out.println(list);
		
		// 9. isEmpty() : boolean > 컬렉션이 비어있는지 확인 
		System.out.println(list.isEmpty());
		
		// 10. clear() : 컬렉션의 내용을 전부 비워버리는 매서드
		list.clear();
		System.out.println(list);
		
		list.addAll(sub);
		list.add(new Human("Winter",25));
		list.add(new Human("NingNing", 24));
		// 리스트 전체 접근방법
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		for(Object h : list) {
			System.out.println(h);
		}
		
		// Stack 자료구조
		Stack<String> stack = new Stack();
		// push() : 데이터 저장하기
		stack.push("첫번째");
		stack.push("두번째");
		stack.push("세번째");
		
		System.out.println(stack);
		
		// peak() : 맨 위 데이터를 확인
		System.out.println(stack.peek());
		
		// pop() : 데이터 꺼내기 
		System.out.println(stack.pop());
		System.out.println(stack);
		
		// 검색 search(E e) 데이터 검색 후 존재하면 위치를 반환한다.(위에서부터 센다) -> equals를 사용하여 비교한다. 
		System.out.println(stack.search("첫번째"));
		
		// stack을 전체 꺼내기 할때는 while문을 사용한다.
		while(!stack.isEmpty()) {
			System.out.println("꺼낸 값 : " + stack.pop());
		}
		
 	}
}
