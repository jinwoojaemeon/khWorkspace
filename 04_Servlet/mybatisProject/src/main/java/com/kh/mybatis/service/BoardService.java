package com.kh.mybatis.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.Template;
import com.kh.mybatis.common.vo.PageInfo;
import com.kh.mybatis.model.dao.BoardDao;
import com.kh.mybatis.model.vo.Attachment;
import com.kh.mybatis.model.vo.Board;
import com.kh.mybatis.model.vo.Category;
import com.kh.mybatis.model.vo.Reply;

public class BoardService {
	private BoardDao boardDao = new BoardDao();
	
	public int selectAllBoardCount() {
		SqlSession sqlSession = Template.getSqlSession();
		
		int listCount = boardDao.selectAllBoardCount(sqlSession);
		
		sqlSession.close();
		
		return listCount;
	}
	
	public int selectSearchBoardCount(HashMap<String, String> searchMap){
		SqlSession sqlSession = Template.getSqlSession();
		
		int listCount = boardDao.selectAllBoardCount(sqlSession, searchMap);
		
		sqlSession.close();
		
		return listCount;
	}
	
	public ArrayList<Board> selectSearchBoard(HashMap<String, String> searchMap, PageInfo pi){
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<Board> list = boardDao.selectAllBoard(sqlSession, searchMap, pi);
		
		sqlSession.close();
		
		return list;
	}
	public ArrayList<Board> selectAllBoard(PageInfo pi){
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<Board> list = boardDao.selectAllBoard(sqlSession, pi);
		
		sqlSession.close();
		
		return list;
	}
	
	public ArrayList<Board> selectAllBoard(PageInfo pi, HashMap<String, String> searchMap){
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<Board> list = boardDao.selectAllBoard(sqlSession, searchMap, pi);
		
		sqlSession.close();
		
		return list;
	}
	
	public int increaseCount(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = boardDao.increaseCount(sqlSession, boardNo);
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return result;
	}
	
	public Board selectBoardByBoardNo(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		
		Board board = boardDao.selectBoardByBoardNo(sqlSession, boardNo);
	
		sqlSession.close();
		return board;
	}
	
	public Attachment selectAttachment(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		
		Attachment at = boardDao.selectAttachment(sqlSession, boardNo);
		
		sqlSession.close();
		return at;
	}
	
	public ArrayList<Category> selectAllCategory() {
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<Category> categoryList = boardDao.selectAllCategory(sqlSession);
	
		sqlSession.close();
		return categoryList;
	}
	
	public int updateBoard(Board b, Attachment at) {
		//새로운 첨부파일이 존재하지 않을 때  -> (b, null) -> board update
		//새로운 첨부파일이 존재하고 기존첨부파일이 존재할 때 -> (b, at(fileNo)) -> board update, attachment update
		//새로운 첨부파일이 존재하고 기존첨부파일이 존재하지 않을 때 -> (b, at(refBoardNo)) -> board update, attachment insert
	
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = boardDao.updateBoard(sqlSession, b);
		
		if(at != null) {
			if(at.getFileNo() != 0) { //기존첨부파일이 존재할 때
				result *= boardDao.updateAttachment(sqlSession, at);
			} else { //기존첨부파일이 존재하지 않을 때
				result *= boardDao.insertNewAttachment(sqlSession, at);
			}
		}
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return result;
	}
	
	// 게시글 삭제
    public int deleteBoard(int boardNo) {
        SqlSession sqlSession = Template.getSqlSession();
        int result = boardDao.deleteBoard(sqlSession, boardNo);
        
        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        
        sqlSession.close();
        return result;
    }
	
	public int insertBoard(Board b, Attachment at) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = boardDao.insertBoard(sqlSession, b);
		
		if(at != null) {
			result *= boardDao.insertAttachment(sqlSession, at);
		}
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return result;
	}
	
	public int insertReply(Reply r) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = boardDao.insertReply(sqlSession, r);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return result;
	}
	
	public ArrayList<Reply> selectReplyByBoardNo(int boardNo){
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<Reply> list = boardDao.selectReplyByBoardNo(sqlSession, boardNo);
		
		sqlSession.close();
		return list;
	}
	
	public int deleteReply(int replyNo) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = boardDao.deleteReply(sqlSession, replyNo);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return result;
	}
	
	public ArrayList<Board> selectThumbnailList() {
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<Board> list = boardDao.selectThumbnailList(sqlSession);
		
		sqlSession.close();
		return list;
	}
	
	public int insertThumbnailBoard(Board b, ArrayList<Attachment> list) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = boardDao.insertThumbnailBoard(sqlSession, b);
		
		if(result > 0 && !list.isEmpty()) {
			for(Attachment at : list) {
				result *= boardDao.insertThumbnailAttachment(sqlSession, at);
			}
		}
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return result;
	}

	public ArrayList<Attachment> selectAttachmentList(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<Attachment> list = boardDao.selectAttachmentList(sqlSession, boardNo);
		
		sqlSession.close();
		return list;
	}
	
	public Board selectThumbnailBoardByBoardNo(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		
		Board board = boardDao.selectThumbnailBoardByBoardNo(sqlSession, boardNo);
	
		sqlSession.close();
		return board;
	}
}
