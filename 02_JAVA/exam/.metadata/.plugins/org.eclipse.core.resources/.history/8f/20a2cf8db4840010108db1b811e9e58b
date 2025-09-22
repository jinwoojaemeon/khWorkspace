package com.kh.jdbc.service;

//static 으로 import 시 static 메서드를 직접 가져와서 사용할 수 있다.
import static com.kh.jdbc.common.JDBCTemplate.close;
import static com.kh.jdbc.common.JDBCTemplate.commit;
import static com.kh.jdbc.common.JDBCTemplate.getConnection;
import static com.kh.jdbc.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.model.dao.MemberDao;
import com.kh.jdbc.model.vo.Member;
/*
 * Service 
 * 트랜잭션 관리와 같은 비즈니스 로직을 처리하는 계층
 * Dao와 Controller의 중간 역할을 한다.
 */
public class MemberService {
	private MemberDao md;
	
	public MemberService() {
		super();
		this.md = new MemberDao();
	}

	public int insertMember(Member m) {
		Connection conn = getConnection();
		
		int result = md.insertMember(m, conn);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
	
	public List<Member> selectMemberList(){
		Connection conn = getConnection();
		
		List<Member> list = md.selectMemberList(conn);
		
		close(conn);
		return list;
	}
	
	public int updateMember(Member m) {
		Connection conn = getConnection();
		int result = md.updateMember(m, conn);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int deleteMember(Member m) {
		Connection conn = getConnection();
		int result = md.deleteMember(m, conn);

		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public ArrayList<Member> searchMemberByKeyword(String keyword) {
		Connection conn = getConnection();
		ArrayList<Member> list  = md.searchMemberByKeyword(conn, keyword);
		close(conn);
		
		return list;
		
	}
	
	public int bulkInsertMembers(ArrayList<Member> list) {
	    Connection conn = getConnection();
	    int successCount = 0;
	    
	    try {
	        int[] result = md.bulkInsertMembers(conn, list);
	        
	        // 성공한 개수 계산
	        for (int r : result) {
	            if (r > 0) successCount++;
	        }
	        
	        if (successCount == list.size()) {
	            // 모든 데이터가 성공했을 때만 커밋
	            commit(conn);
	        } else {
	            // 일부 실패시 롤백
	            rollback(conn);
	            successCount = 0; // 실패로 처리
	        }
	        
	    } catch (Exception e) {
	        rollback(conn);
	        e.printStackTrace();
	        successCount = 0;
	    } finally {
	        close(conn);
	    }
	    
	    return successCount;
	}

	public int bulkDeleteMembers(String[] idArr) {
	    Connection conn = getConnection();
	    int successCount = 0;
	    
	    try {
	        int[] result = md.bulkDeleteMembers(conn, idArr);
	        
	        for (int r : result) {
	            if (r > 0) successCount++;
	        }
	        
	        if (successCount > 0) {
	            commit(conn);
	        } else {
	            rollback(conn);
	        }
	        
	    } catch (Exception e) {
	        rollback(conn);
	        e.printStackTrace();
	        successCount = 0;
	    } finally {
	        close(conn);
	    }
	    
	    return successCount;
	}
}
