package com.kh.example.poly2;

public class LibraryController {
	private Member mem = null;
	Book[] bList = new Book[5];

	 {
		 int bookIdx = 0;
		 bList[bookIdx++] = new CookBook("백종원의 집밥", "백종원", "tvN", true);
		 bList[bookIdx++] = new AniBook("한번 더 해요", "미티", "원모어", 19);
		 bList[bookIdx++] = new AniBook("루피의 원피스", "루피", "japan", 12);
		 bList[bookIdx++] = new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false);
		 bList[bookIdx++] = new CookBook("최현석 날 따라해봐", "최현석", "소금책", true);
	 }
	 
	 public void insertMember(Member mem) {
		 this.mem = mem;
	 }
	 
	 public Member myInfo() {
		 return mem;
	 }
	 
	 public Book[] selectAll() {
		 return bList;
	 }
	 
	 public Book[] searchBook(String keyword) {
		 Book[] keywordBook = new Book[bList.length];
		 int keyCnt=0;
		 for(int i=0; i<bList.length; i++) {
			 if(bList[i] != null && bList[i].getTitle().contains(keyword)) {
		//String1.contains(String2) >> String1에 String2가 포함되어 있다면 true.
				 keywordBook[keyCnt++] = bList[i];
			 }
		 }
		 return keywordBook;
	 }
	 
	 public int rentBook(int index) {
		 int result = 0;
		 if(index > bList.length) {
				return result = -1;
			}
		// Book b = bList[index] 후, b로 비교 가능 
		if(bList[index] != null ) {
			if( bList[index] instanceof AniBook 
					&& mem.getAge() < ((AniBook)bList[index]).getAccessAge()) {
				if(mem != null) result = 1;
			}
			if( bList[index] instanceof CookBook 
					&& ((CookBook)bList[index]).isCoupon()==true) {
				 if(mem != null) {
					 mem.setCouponCount(mem.getCouponCount()+1);
					 result = 2;
				 }
			}
		}
		return result;
	 }
}
