package com.kh.example.collection2;
import java.util.Comparator;

public class SortedLottery implements Comparator<Lottery>{
	public int compare(Lottery o1, Lottery o2) {
	Lottery l1 = (Lottery)o1;
	Lottery l2 = (Lottery)o2;
     int nameCompare = l1.getName().compareTo(l2.getName());
     if (nameCompare != 0) {
         return nameCompare;
     }
     return l1.getPhone().compareTo(l2.getPhone());
	}
}
