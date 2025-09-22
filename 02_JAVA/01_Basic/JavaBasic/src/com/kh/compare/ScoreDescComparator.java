package com.kh.compare;

import java.util.Comparator;

public class ScoreDescComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// 내림차순은 o2 vs o1 (오름차순은 o1 vs o2)
		return o2.score - o1.score;
	}

}
