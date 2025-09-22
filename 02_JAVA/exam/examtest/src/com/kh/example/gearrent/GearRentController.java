package com.kh.example.gearrent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class GearRentController {
	private HashMap<String, Device> catalog = new HashMap<>();
	private HashMap<String, Member> members = new HashMap<>();
	private HashMap<String, Loan> activeLoans  = new HashMap<>();

	public boolean addDevice(Device device) {
		if(catalog.containsKey(device.getId())) {
			return false;
		}
		catalog.put(device.getId(), device);
		return true;
	}
	
	public boolean addMember(Member member) {
		if(members.containsKey(member.getId())) {
			return false;
		}
		members.put(member.getId(), member);
		return true;
	}
	public Loan borrow(String memberId, String itemId, LocalDate today) {
		Device d = catalog.get(itemId);
		int limitDays = d.getBorrowLimitDays();
		LocalDate dueDay = today.plusDays(limitDays);
		Loan l = new Loan(itemId, memberId, today, dueDay);
		activeLoans.put(itemId, l);
		d.increaseBorrowCount();
		return l;
	}
	
	public int returnItem(String itemId, LocalDate today) {
		Loan l = activeLoans.get(itemId);
	    Device d = catalog.get(itemId);
	    l.returnedDate = today;
	    
	    if(l.isOverdue(today)) {
	        int overdueDays = l.overdueDays(today);
	        if(overdueDays > 0) {
	            int fee = d.calcLateFee(overdueDays);
	            activeLoans.remove(itemId);  
	            return fee;
	        }
	    }
	    activeLoans.remove(itemId);
	    return 0;
	}
	
	public ArrayList<Device> findByTag(String tag){
		 if (tag == null) {
		        return new ArrayList<>();
		    }
		    ArrayList<Device> result = new ArrayList<>();
		    for (Device device : catalog.values()) {
		        if (device.hasTag(tag)) {
		            result.add(device);
		        }
		    }
		    return result;
	}
	
	public ArrayList<Device> findByKeyword(String keyword){
		if (keyword == null || keyword.equals(" ")) {
	        return new ArrayList<>();
	    }
	    ArrayList<Device> result = new ArrayList<>();
	    String lowKey = keyword.toLowerCase();
	    for (Device device : catalog.values()) {
	        if (device.getName().toLowerCase().contains(lowKey)) {
	            result.add(device);
	        }
	    }
	    return result;
	}
	public Collection<Device> getAllDevices() {
		// return Collections.unmodifiableCollection(catalog.values());  // 읽기 전용 뷰로 만들어준다.
	    return new ArrayList<>(catalog.values());
	}

	public Collection<Loan> getActiveLoans() {
		// return Collections.unmodifiableCollection(activeLoans.values());
	    return new ArrayList<>(activeLoans.values());
	}
	
	
	
}
