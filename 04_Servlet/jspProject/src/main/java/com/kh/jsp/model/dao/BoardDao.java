package com.kh.jsp.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.kh.jsp.common.JDBCTemplate.close;
import com.kh.jsp.model.vo.Board;
import com.kh.jsp.model.vo.Category;

public class BoardDao {
    private Properties prop = new Properties();
    
    public BoardDao() {
        try {
            String path = BoardDao.class.getResource("/db/sql/board-mapper.xml").getPath();
            System.out.println("board-mapper.xml 경로: " + path);
            prop.loadFromXML(new FileInputStream(path));
            System.out.println("board-mapper.xml 로드 성공");
        } catch (IOException e) {
            System.out.println("board-mapper.xml 로드 실패: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // 게시글 목록 조회 (페이지네이션)
    public List<Board> selectBoardList(Connection conn, int currentPage) {
        List<Board> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectBoardList");
        
        // 페이지네이션 계산
        int pageSize = 10;
        int startRow = (currentPage - 1) * pageSize + 1;
        int endRow = currentPage * pageSize;
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, startRow);
            pstmt.setInt(2, endRow);
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                Board b = new Board();
                b.setBoardNo(rset.getInt("BOARD_NO"));
                b.setBoardTitle(rset.getString("BOARD_TITLE"));
                b.setBoardWriter(rset.getInt("BOARD_WRITER"));
                b.setWriterName(rset.getString("MEMBER_NAME"));
                b.setCount(rset.getInt("COUNT"));
                b.setCreateDate(rset.getDate("CREATE_DATE"));
                b.setCategoryName(rset.getString("CATEGORY_NAME"));
                
                list.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        
        return list;
    }
    
    // 게시글 총 개수 조회
    public int selectBoardCount(Connection conn) {
        int count = 0;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectBoardCount");
        
        try {
            pstmt = conn.prepareStatement(sql);
            rset = pstmt.executeQuery();
            
            if(rset.next()) {
                count = rset.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        
        return count;
    }
    
    // 카테고리 목록 조회
    public List<Category> selectCategoryList(Connection conn) {
        List<Category> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectCategoryList");
        
        try {
            pstmt = conn.prepareStatement(sql);
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                Category c = new Category();
                c.setCategoryNo(rset.getInt("CATEGORY_NO"));
                c.setCategoryName(rset.getString("CATEGORY_NAME"));
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        
        return list;
    }
    
    // 게시글 작성
    public int insertBoard(Board b, Connection conn) {
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("insertBoard");
        int result = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, b.getCategoryNo());
            pstmt.setString(2, b.getBoardTitle());
            pstmt.setString(3, b.getBoardContent());
            pstmt.setInt(4, b.getBoardWriter());
            
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        return result;
    }
    
    // 게시글 상세 조회
    public Board selectBoard(Connection conn, int boardNo) {
        Board b = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectBoard");
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardNo);
            rset = pstmt.executeQuery();
            
            if(rset.next()) {
                b = new Board();
                b.setBoardNo(rset.getInt("BOARD_NO"));
                b.setBoardType(rset.getInt("BOARD_TYPE"));
                b.setCategoryNo(rset.getInt("CATEGORY_NO"));
                b.setCategoryName(rset.getString("CATEGORY_NAME"));
                b.setBoardTitle(rset.getString("BOARD_TITLE"));
                b.setBoardContent(rset.getString("BOARD_CONTENT"));
                b.setBoardWriter(rset.getInt("BOARD_WRITER"));
                b.setWriterName(rset.getString("MEMBER_NAME"));
                b.setCount(rset.getInt("COUNT"));
                b.setCreateDate(rset.getDate("CREATE_DATE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        
        return b;
    }
    
    // 조회수 증가
    public int increaseCount(Connection conn, int boardNo) {
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("increaseCount");
        int result = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardNo);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        
        return result;
    }
    
    // 게시글 수정
    public int updateBoard(Connection conn, Board b) {
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("updateBoard");
        int result = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, b.getCategoryNo());
            pstmt.setString(2, b.getBoardTitle());
            pstmt.setString(3, b.getBoardContent());
            pstmt.setInt(4, b.getBoardNo());
            pstmt.setInt(5, b.getBoardWriter());
            
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        
        return result;
    }
    
    // 게시글 삭제
    public int deleteBoard(Connection conn, int boardNo, int boardWriter) {
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("deleteBoard");
        int result = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardNo);
            pstmt.setInt(2, boardWriter);
            
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        
        return result;
    }
}
