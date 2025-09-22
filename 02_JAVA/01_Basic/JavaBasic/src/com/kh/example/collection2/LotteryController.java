package com.kh.example.collection2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;


public class LotteryController {
	private HashSet<Lottery> lottery = new HashSet<>();
	private HashSet<Lottery> win = new HashSet<>();
	
	public boolean insertObject(Lottery l) {
		return lottery.add(l);  // .add(l) 은 return값이 boolean이다.
	}
	
	public boolean deleteObject(Lottery l) {
//		for(Lottery lo : lottery)
//			if(lo.equals(l)) {
//				lottery.remove(l);
//				win.remove(l);
//				return true;
//			}
//		return false;
		boolean isRemove = lottery.remove(l);
		if(win != null && isRemove)
			win.remove(l);
		
		return isRemove;
	}
	
	public HashSet<Lottery> winObject() {
		if(win.size() < 4) {
			Random random = new Random();
			ArrayList<Lottery> winList = new ArrayList<>();
			winList.addAll(lottery);
			while(winList.size() < 4 && win.size() != lottery.size()) { // 로터리 크기가 3이하일 경우면 안된다.
				int idx = random.nextInt(winList.size());  // 0~size()-1 중 랜덤으로 정수 호출 
				win.add(winList.get(idx));
			}
		}
		return win;
	}
	
	public TreeSet<Lottery> sortedWinObject() {
		return null;
	}
	
	public boolean searchWinner(Lottery l) {
		return win.contains(l);
	}
	
}
