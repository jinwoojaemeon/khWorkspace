package com.kh.example.gearrent;

import java.util.Set;

public class Camera extends Device{

	public Camera(String id, String name, String category, Set<String> tags) {
		super(id, name, category, tags);
	}

	@Override
	public int getBorrowLimitDays() {
		int limitDays = 7;
		return limitDays;
	}

	@Override
	public int calcLateFee(int overdueDays) {
		int overdueFee = overdueDays * 300;
		return overdueFee;
	}
}
