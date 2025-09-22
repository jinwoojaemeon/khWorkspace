package com.kh.jdbc.model.dao;

import static com.kh.jdbc.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.jdbc.model.vo.Member;

public class MemberDao {
	private Properties prop = new Properties();
	public MemberDao() {
		super();
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int insertMember(Member m, Connection conn) {
		// DB에 Member를 INSERT  ->  처리된 행 수 (int)
		// JDBC를 사용 
		int result =0;
		PreparedStatement pstmt = null;
		
		// 실행할 sql(sql뒤에 "" 안에 ; 없어야한다.)
		String sql = prop.getProperty("insertMember");
		try {
			// 아prepareStatement> 직 미완성 sql문으로 ?의 값을 채어줘야한다.
			pstmt = conn.prepareStatement(sql);  
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				close(pstmt);
				close(conn);
		}
		return result;
	}
	//전체 회원 목록을 반환하는 메서드
	public ArrayList<Member> selectMemberList(Connection conn){
		//select문(여러개) -> ResultSet -> ArrayList에 담아서 전달
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectMemberList");
		
		try {
			// 완성된 sql 전달 > 
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member m = new Member();
				m.setUserNo(rset.getInt("USER_NO"));
				m.setUserId(rset.getString("USER_ID"));
				m.setUserPwd(rset.getString("USER_PWD"));
				m.setUserName(rset.getString("USER_NAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEmrollDate(rset.getTimestamp("EMROLL_DATE").toLocalDateTime());
			
				list.add(m);
			}
			
			// 반복문이 끝난시점 
			// list = null || m이 들어갔거나.
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				close(rset);
				close(pstmt);
				close(conn);
		}
		return list;
	}
	
	// Member 객체 m을 통해서 update sql을 전달하는 매서드
	public int updateMember(Member m, Connection conn) {
		int result =0;
		PreparedStatement pstmt = null;
		
		// 실행할 sql(sql뒤에 "" 안에 ; 없어야한다.)
		String sql = prop.getProperty("updateMember");
		try {
			// prepareStatement> 아직 미완성 sql문으로 ?의 값을 채어줘야한다.
			pstmt = conn.prepareStatement(sql);  
			pstmt.setString(1, m.getEmail());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getAddress());
			pstmt.setString(4, m.getHobby());
			pstmt.setString(5, m.getUserId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				close(pstmt);
		}
		return result;
	}
	
	public int deleteMember(Member m, Connection conn) {
		int result =0;
		PreparedStatement pstmt = null;
		
		// 실행할 sql(sql뒤에 "" 안에 ; 없어야한다.)
		String sql = prop.getProperty("deleteMember");
		try {
			// prepareStatement> 아직 미완성 sql문으로 ?의 값을 채어줘야한다.
			pstmt = conn.prepareStatement(sql);  
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				close(pstmt);
		}
		return result;
	}
	
	public ArrayList<Member> searchMemberByKeyword(Connection conn, String keyword) {
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("searchMemberByKeyword");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			//pstmt.setString(1, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Member m = new Member();
				m.setUserNo(rset.getInt("USER_NO"));
				m.setUserId(rset.getString("USER_ID"));
				m.setUserPwd(rset.getString("USER_PWD"));
				m.setUserName(rset.getString("USER_NAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEmrollDate(rset.getTimestamp("EMROLL_DATE").toLocalDateTime());
				list.add(m);
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public int[] bulkInsertMembers(Connection conn, ArrayList<Member> list) {
	    PreparedStatement pstmt = null;
	    int[] result = null;
	    
	    String sql = prop.getProperty("insertMember");
	    try {
	        pstmt = conn.prepareStatement(sql);
	        
	        for(Member m : list) {
	            pstmt.setString(1, m.getUserId());
	            pstmt.setString(2, m.getUserPwd());
	            pstmt.setString(3, m.getUserName());
	            pstmt.setString(4, m.getGender());
	            pstmt.setInt(5, m.getAge());
	            pstmt.setString(6, m.getEmail());
	            pstmt.setString(7, m.getPhone());
	            pstmt.setString(8, m.getAddress());
	            pstmt.setString(9, m.getHobby());
	            pstmt.addBatch(); 
	        }
	        
	        result = pstmt.executeBatch();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close(pstmt);
	    }
	    return result;
	}

	public int[] bulkDeleteMembers(Connection conn, String[] idArr) {
	    int[] result = null;
	    PreparedStatement pstmt = null;
	    
	    String sql = prop.getProperty("bulkDeleteMembers");
	    try {
	        pstmt = conn.prepareStatement(sql);
	        
	        for(String id : idArr) {
	            pstmt.setString(1, id.trim());
	            pstmt.addBatch();
	        }
	        
	        result = pstmt.executeBatch();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close(pstmt);
	    }
	    return result;
	}
}
