package com.kh.jsp.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kh.jsp.common.JDBCTemplate;
import com.kh.jsp.model.vo.Board;

public class BoardDao {
    public int insertBoard(Board b, Connection conn) {
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("insertBoard");
        int result = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, b.getBoardType());
            pstmt.setInt(2, b.getCategoryNo());
            pstmt.setString(3, b.getBoardTitle());
            pstmt.setString(4, b.getBoardContent());
            pstmt.setString(5, b.getBoardWriter());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        return result;
    }
}
