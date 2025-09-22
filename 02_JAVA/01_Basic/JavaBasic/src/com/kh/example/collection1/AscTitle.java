package com.kh.example.collection1;
import java.util.Comparator;
public class AscTitle implements Comparator{
	 public int compare(Object o1, Object o2) {
		 Music m1 = (Music)o1;
	     Music m2 = (Music)o2;
	     // 곡명 오름차순, 동일 제목시 가수명 오름차순
	     int titleCompare = m1.getTitle().compareTo(m2.getTitle());
	     if (titleCompare != 0) {
	         return titleCompare;
	     }
	     return m1.getSinger().compareTo(m2.getSinger());
	}
}
