package com.kh.jsp.model.dao;

import java.awt.List;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.jsp.common.JDBCTemplate;
import static com.kh.jsp.common.JDBCTemplate.*;
import com.kh.jsp.model.vo.Member;

public class MemberDao {
	private Properties prop = new Properties();
	
	public MemberDao() {
		super();
		
		String path = JDBCTemplate.class.getResource("/db/sql/member-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertMember(Member m, Connection conn) {
		//insert -> 처리된 행 수 -> 반환
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPwd());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getAddress());
			pstmt.setString(7, m.getInterest());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	 public ArrayList<Member> loginMember(Member m, Connection conn) {
	    	ResultSet rset = null;
	        ArrayList<Member> list = new ArrayList<>();
	        PreparedStatement pstmt = null;
	        String sql = prop.getProperty("loginMember");
	        
	        try {
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, m.getMemberId());
	            pstmt.setString(2, m.getMemberPwd());
	            rset = pstmt.executeQuery();
	  
	            while(rset.next()) {
	            	new Member();
	                m.setMemberNo(rset.getInt("MEMBER_NO"));
	                m.setMemberId(rset.getString("MEMBER_ID"));
	                m.setMemberPwd(rset.getString("MEMBER_PWD"));
	                m.setMemberName(rset.getString("MEMBER_NAME"));
	                m.setPhone(rset.getString("PHONE"));
	                m.setEmail(rset.getString("EMAIL"));
	                m.setAddress(rset.getString("ADDRESS"));
	                m.setInterest(rset.getString("INTEREST"));
	                m.setEnrollDate(rset.getDate("ENROLL_DATE"));
	                m.setModifyDate(rset.getDate("MODIFY_DATE"));
	                m.setStatus(rset.getString("STATUS"));
	                list.add(m);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
}