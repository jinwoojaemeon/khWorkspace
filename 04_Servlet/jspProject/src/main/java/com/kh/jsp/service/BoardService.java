package com.kh.jsp.service;

import static com.kh.jsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.jsp.common.vo.PageInfo;
import com.kh.jsp.model.dao.BoardDao;
import com.kh.jsp.model.vo.Attachment;
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
	
	public Attachment selectAttachmentByBoardNo(int boardNo) {
		Connection conn = getConnection();
		
		Attachment attachment = new BoardDao().selectAttachmentByBoardNo(conn, boardNo);
	
		close(conn);
		return attachment;
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
    public int insertBoard(Board b, Attachment at) {
		Connection conn = getConnection();
		
		BoardDao bDao = new BoardDao();
		
		int result = bDao.insertBoard(conn, b);
		
		if(at != null && result > 0) {
			// 게시글 삽입 성공 후 첨부파일의 refBoardNo 설정
			at.setRefBoardNo(b.getBoardNo());
			result *= bDao.insertAttachment(conn, at);
		}
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
    
    // 페이지네이션을 위한 게시글 목록 조회
    public ArrayList<Board> selectBoardList(int currentPage, int boardLimit) {
        Connection conn = getConnection();
        
        ArrayList<Board> list = new BoardDao().selectBoardList(conn, currentPage, boardLimit);
        close(conn);
        
        return list;
    }
    
    // 전체 게시글 수 조회
    public int selectListCount() {
        Connection conn = getConnection();
        
        int listCount = new BoardDao().selectListCount(conn);
        close(conn);
        
        return listCount;
    }
    
    // PageInfo를 활용한 게시글 목록 조회 (개선된 메서드)
    public ArrayList<Board> selectBoardListWithPageInfo(PageInfo pi) {
        Connection conn = getConnection();
        
        ArrayList<Board> list = new BoardDao().selectBoardList(conn, pi.getCurrentPage(), pi.getBoardLimit());
        close(conn);
        
        return list;
    }
    
    // 게시글과 첨부파일 업데이트
    public int updateBoardWithAttachment(int boardNo, int categoryNo, String boardTitle, String boardContent, 
                                       Attachment newAt, Attachment originAt) {
        Connection conn = getConnection();
        BoardDao bDao = new BoardDao();
        
        // 1. 게시글 업데이트
        Board board = new Board();
        board.setBoardNo(boardNo);
        board.setCategoryNo(categoryNo);
        board.setBoardTitle(boardTitle);
        board.setBoardContent(boardContent);
        
        int result = bDao.updateBoard(conn, board);
        
        if(result > 0) {
            // 2. 첨부파일 처리
            if(newAt != null) {
                // 새로운 파일이 업로드된 경우
                if(originAt != null) {
                    // 기존 파일이 있으면 삭제
                    result *= bDao.deleteAttachment(conn, boardNo);
                }
                // 새로운 파일 정보 삽입
                result *= bDao.insertAttachment(conn, newAt);
            }
            // 새로운 파일이 없고 기존 파일도 없으면 아무것도 하지 않음
        }
        
        if(result > 0) {
            commit(conn);
        } else {
            rollback(conn);
        }
        
        close(conn);
        return result;
    }
}
