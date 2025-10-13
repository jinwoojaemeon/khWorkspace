package com.kh.jsp.service;

import static com.kh.jsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.jsp.model.dao.BoardDao;
import com.kh.jsp.model.vo.Board;
import com.kh.jsp.model.vo.Category;

public class BoardService {
    
	public ArrayList<Board> selectAllBoard(){
		Connection conn = getConnection();
		
		ArrayList<Board> list = new BoardDao().selectAllBoard(conn);
		close(conn);
		
		return list;
	}
	
	public int increaseCount(int boardNo) {
		Connection conn = getConnection();
		
		int result = new BoardDao().increaseCount(conn, boardNo);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
	
	public Board selectBoardByBoardNo(int boardNo) {
		Connection conn = getConnection();
		
		Board board = new BoardDao().selectBoardByBoardNo(conn, boardNo);
	
		close(conn);
		return board;
	}
	
	public ArrayList<Category> selectAllCategory() {
		Connection conn = getConnection();
		
		ArrayList<Category> categroyList = new BoardDao().selectAllCategory(conn);
	
		close(conn);
		return categroyList;
	}
	
	public int updateBoard(int boardNo,int categoryNo,String boardTitle,String boardContent) {
		Connection conn = getConnection();
		Board b = new Board();
		b.setBoardNo(boardNo);
		b.setCategoryNo(categoryNo);
		b.setBoardTitle(boardTitle);
		b.setBoardContent(boardContent);
		
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
    public int deleteBoard(int boardNo) {
        Connection conn = getConnection();
        int result = new BoardDao().deleteBoard(conn, boardNo);
        
        if(result > 0) {
            commit(conn);
        } else {
            rollback(conn);
        }
        
        close(conn);
        return result;
    }
    
    // 게시글 작성
    public int insertBoard(Board board) {
        Connection conn = getConnection();
        int result = new BoardDao().insertBoard(conn, board);
        
        if(result > 0) {
            commit(conn);
        } else {
            rollback(conn);
        }
        
        close(conn);
        return result;
    }
}
