package com.kh.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;



public class Run {
	/*
	 * Map
	 * key와 value를 쌍으로 저장하는 자료구조 
	 * key는 중복불가, value 중복이 가능하다 . key는 식별의 역할을 하기 때문에 중복이 되면 안된다.
	 * HashMap : 가장 보편적이고 속도 향상
	 * LinkedHashMap : 입력 순서 보장
	 * TreeMap : 정렬된 key순서유지
	 */
	public static void main(String[] args) {
		Map<Integer, Human> hMap = new HashMap<>();
		
		// 1. put() : map에 key, value 쌍으로 값을 추가 
		hMap.put(10, new Human("오타니", 35));
		hMap.put(15, new Human("밸린저", 32));
		hMap.put(20, new Human("게레로", 37));
		hMap.put(25, new Human("김혜성", 28));
		hMap.put(30, new Human("김혜성", 28)); // value는 동일해도 된다. 
		hMap.put(25, new Human("류현진", 39)); // 동일한 key 사용시 값을 덮어 쓴다. 
		System.out.println(hMap); // 값에 순서 유지가 안된다.
		
		// 2. get(key) : 해당 key 값을 가지는 value를 반환
		System.out.println(hMap.get(30));
		
		// 3. size() : 담겨있는 객체 수 
		System.out.println("Size : " + hMap.size());
		
		// 4. remove(key) : 해당 key의 값을 찾아서 k-v쌍으로 제거한다.
		hMap.remove(25);
		System.out.println(hMap);
		
		// map에 전체 요소를 탐색하는 방법 
		// Iterator 이용 불가능 
		// for each 사용 불가. 
		// 다른 자료구조로 변경 후 반복
		// 1. key를 모아서 Set자료구조 형태로 변환 
		Set keySet = hMap.keySet(); // 모든 key를 Set에 담아서 반환 
		for(Object key : keySet) {
			System.out.println("키 : " + key + " 값 : " + hMap.get(key));
		}
		
		// Map은 key와 value를 쌍으로 저장하기 때문에 단순하게 keySet(), values() 만으로는
		// key와 값을 가져올 수 없다. 	
		// 2. entrySet을 이용한 전체탐색 

		// Set<Map.Entry<K,V>> 
		Set entrySet = hMap.entrySet();
		for(Object entry : entrySet) {
			Entry e = (Entry)entry;
			System.out.println(e.getKey() + " " + e.getValue());
		}
		
		
	}

} 