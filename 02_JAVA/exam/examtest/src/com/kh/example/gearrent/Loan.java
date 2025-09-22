package com.kh.example.gearrent;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Loan {
	private String itemId;
	private String memberId; 
	private LocalDate loanDate;  // 대여일 
	private LocalDate dueDate;   // 반납 예정일 
	public LocalDate returnedDate;  // 실제 반납일 
	
	public Loan(String itemId, String memberId, LocalDate loanDate, LocalDate dueDate) {
		super();
		this.itemId = itemId;
		this.memberId = memberId;
		this.loanDate = loanDate;
		this.dueDate = dueDate;
	}
	
	public boolean isOverdue(LocalDate today) {
	    if(returnedDate != null) {
	        return dueDate.isBefore(returnedDate);
	    }
	    return dueDate.isBefore(today);
	}
	
	public int overdueDays(LocalDate today) {
		 LocalDate toDate = (returnedDate != null) ? returnedDate : today;
		    
		    if(dueDate.isBefore(toDate)) {
		        int overdueDays = toDate.getDayOfYear() - dueDate.getDayOfYear();
		        // long overdueDays = ChronoUnit.DAYS.between(dueDate, toDate);
		        return overdueDays;
		    }
		    return 0;
	}

	@Override
	public String toString() {
		String ret;
		if(returnedDate == null)
			ret = "미반납";
		else
			ret = returnedDate.toString();
		return "Loan [itemId=" + itemId + ", member=" + memberId + ", loan=" + loanDate + ", due=" + dueDate
				+ ", ret=" + ret + "]\n";
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public LocalDate getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(LocalDate loanDate) {
		this.loanDate = loanDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDate getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(LocalDate returnedDate) {
		this.returnedDate = returnedDate;
	}
	
	
	
}
