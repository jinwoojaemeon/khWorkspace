package com.kh.jsp.service;

import static com.kh.jsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.jsp.model.dao.BoardDao;
import com.kh.jsp.model.vo.Board;
import com.kh.jsp.model.vo.Category;

public class BoardService {
    
    // 게시글 목록 조회
    public List<Board> selectBoardList() {
        Connection conn = getConnection();
        List<Board> list = new BoardDao().selectBoardList(conn);
        close(conn);
        return list;
    }
    
    // 카테고리 목록 조회
    public List<Category> selectCategoryList() {
        Connection conn = getConnection();
        List<Category> list = new BoardDao().selectCategoryList(conn);
        close(conn);
        return list;
    }
    
    // 게시글 작성
    public int insertBoard(Board b) {
        Connection conn = getConnection();
        int result = new BoardDao().insertBoard(b, conn);
        if(result > 0) {
            commit(conn);
        } else {
            rollback(conn);
        }
        close(conn);
        return result;
    }
    
    // 게시글 상세 조회
    public Board selectBoard(int boardNo) {
        Connection conn = getConnection();
        
        // 게시글 조회
        Board b = new BoardDao().selectBoard(conn, boardNo);
        
        if(b != null) {
            // 조회수 증가
            int result = new BoardDao().increaseCount(conn, boardNo);
            if(result > 0) {
                commit(conn);
            } else {
                rollback(conn);
            }
        }
        
        close(conn);
        return b;
    }
    
    // 게시글 상세 조회 (수정용 - 조회수 증가 없음)
    public Board selectBoardForUpdate(int boardNo) {
        Connection conn = getConnection();
        Board b = new BoardDao().selectBoard(conn, boardNo);
        close(conn);
        return b;
    }
    
    // 게시글 수정
    public int updateBoard(Board b) {
        Connection conn = getConnection();
        int result = new BoardDao().updateBoard(conn, b);
        
        if(result > 0) {
            commit(conn);
        } else {
            rollback(conn);
        }
        
        close(conn);
        return result;
    }
    
    // 게시글 삭제
    public int deleteBoard(int boardNo, int boardWriter) {
        Connection conn = getConnection();
        int result = new BoardDao().deleteBoard(conn, boardNo, boardWriter);
        
        if(result > 0) {
            commit(conn);
        } else {
            rollback(conn);
        }
        
        close(conn);
        return result;
    }
}
