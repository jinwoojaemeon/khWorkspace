package com.kh.jsp.service;

import static com.kh.jsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.jsp.model.dao.BoardDao;
import com.kh.jsp.model.vo.Board;
import com.kh.jsp.model.vo.Category;

public class BoardService {
    
    // 게시글 목록 조회 (페이지네이션)
    public List<Board> selectBoardList(int currentPage) {
        Connection conn = getConnection();
        List<Board> list = new BoardDao().selectBoardList(conn, currentPage);
        close(conn);
        return list;
    }
    
    // 게시글 총 개수 조회
    public int selectBoardCount() {
        Connection conn = getConnection();
        int count = new BoardDao().selectBoardCount(conn);
        close(conn);
        return count;
    }
    
    // 페이지네이션 정보 계산
    public int[] calculatePagination(int currentPage, int totalCount) {
        int pageSize = 10; // 한 페이지당 게시글 수
        int paginationSize = 5; // 페이지네이션에 보여줄 페이지 수
        
        // 총 페이지 수 계산
        int totalPages = (totalCount + pageSize - 1) / pageSize; // 올림 계산
        
        // 현재 페이지 유효성 검사
        if(currentPage < 1) currentPage = 1;
        if(currentPage > totalPages) currentPage = totalPages;
        
        // 페이지네이션 시작/끝 페이지 계산
        int startPage = ((currentPage - 1) / paginationSize) * paginationSize + 1;
        int endPage = Math.min(startPage + paginationSize - 1, totalPages);
        
        // 이전/다음 버튼 활성화 여부
        int hasPrev = (startPage > 1) ? 1 : 0;
        int hasNext = (endPage < totalPages) ? 1 : 0;
        
        return new int[]{currentPage, totalPages, startPage, endPage, hasPrev, hasNext};
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
