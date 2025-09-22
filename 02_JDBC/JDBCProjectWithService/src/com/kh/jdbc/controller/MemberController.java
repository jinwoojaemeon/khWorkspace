package com.kh.jdbc.controller;

import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.model.vo.Member;
import com.kh.jdbc.service.MemberService;
import com.kh.jdbc.view.MemberMenu;

/*
 * Controller : View를 통해서 사용자가 요청한 기능에 대해 처리하는 객체 
 * 				해당 매서드로 전달된 데이터를 가공한 후 dao로 전달하여 기능을 수행한다.
 * 				dao로부터 반환받은 결과에 따라서 성공/실패 여부를 판단해서 응답화면 결정 -> 다시 View를 호출 
 */
public class MemberController {
	private MemberService ms = new MemberService();
	public MemberController() {
		super();
	}

	/*
	 * 사용자의 추가 요청을 처리하는 매서드
	 * userId ~ hobby : 사용자가 입력한 정보를 매개변수로 받음. 
	 */
	public void insertMember(String userId, String userPwd, String userName, String gender, String age, String email, String phone,
			String address, String hobby) {
		//View로부터 전달받은 값을 바로 dao에 전달x
		//vo에 잘 담아서 전달 
		Member m = new Member(userId, userPwd, userName, gender, 
				Integer.parseInt(age), email, phone, address, hobby);
		int result = ms.insertMember(m);
		
		if(result > 0) {
			//성공화면
			new MemberMenu().displaySuccess("성공적으로 회원이 추가되었습니다.");
		} else {
			//실패화면
			new MemberMenu().displaySuccess("회원추가에 실패하였습니다.");
		}
	}
	
	// 회원을 전체 조회
	public void selectMemberAll() {
		List<Member> list = ms.selectMemberList();
		
		if(list.isEmpty()) {
			new MemberMenu().displayNoData("회원 목록 조회 결과가 없습니다.");
		}else {
			new MemberMenu().displayList(list, "회원 목록");
		}
	}
	
	// userId, email, phone, address, hobby를 전달받아 Member를 수정하는 매서드
	public void updateMember(String userId, String email, String phone, String address, String hobby) {
		Member m = new Member();
		m.setUserId(userId);
		m.setEmail(email);
		m.setPhone(phone);
		m.setAddress(address);
		m.setHobby(hobby);
		
		int result = ms.updateMember(m);
		
		if(result > 0) {
			new MemberMenu().displaySuccess("성공적으로 회원 정보를 수정하였습니다.");
		} else {
			new MemberMenu().displayFail("회원 정보를 수정하는데 실패하였습니다.");
		}
	}
	
	public void deleteMember(String userId, String userPwd) {
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		
		int result = ms.deleteMember(m);
		if(result > 0) {
			new MemberMenu().displaySuccess("회원 탈퇴를 완료 했습니다.");
		} else {
			new MemberMenu().displayFail("잘못된 아이디 또는 비밀번호 입니다.");
		}
	}
	
	public void searchMemberByKeyword(String keyword) {
		ArrayList<Member> list = ms.searchMemberByKeyword(keyword);
		
		
		if(list.isEmpty()) {
			new MemberMenu().displayNoData("키워드 조회 결과가 없습니다.");
		}else {
			new MemberMenu().displayList(list, "키워드 검색 결과");
		}
	}
	
	public void bulkInsertMembers(ArrayList<Member> list) {
	    int result = ms.bulkInsertMembers(list);
	    if(result == list.size()) {
	        new MemberMenu().displaySuccess(list.size()+"개의 일괄 추가가 모두 완료되었습니다.");
	    } else if(result > 0) {
	        new MemberMenu().displaySuccess(result + "개의 회원이 추가되었습니다.");
	    } else {
	        new MemberMenu().displayFail("회원 추가에 실패하였습니다."); 
	    }
	}

	public void bulkDeleteMembers(String[] idArr) {
	    int result = ms.bulkDeleteMembers(idArr);
	    if(result == idArr.length) {
	        new MemberMenu().displaySuccess(idArr.length+"개의 일괄 삭제가 모두 완료되었습니다.");
	    } else if(result > 0) {
	        new MemberMenu().displaySuccess(result + "개의 회원이 삭제되었습니다.");
	    } else {
	        new MemberMenu().displayFail("회원 삭제에 실패하였습니다."); 
	    }
	}
}
