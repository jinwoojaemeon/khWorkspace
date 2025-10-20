package com.kh.mybatis.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.vo.PageInfo;
import com.kh.mybatis.model.vo.Attachment;
import com.kh.mybatis.model.vo.Board;
import com.kh.mybatis.model.vo.Category;
import com.kh.mybatis.model.vo.Reply;

public class BoardDao {
	public int selectAllBoardCount(SqlSession sqlSession) {
		return sqlSession.selectOne("BoardMapper.selectAllBoardCount");
	}
	
	public int selectAllBoardCount(SqlSession sqlSession, HashMap<String, String> searchMap){
		return sqlSession.selectOne("BoardMapper.selectSearchBoardCount", searchMap);
	}

	public ArrayList<Board> selectAllBoard(SqlSession sqlSession, HashMap<String, String> searchMap, PageInfo pi){
		int offset = (pi.getCurrentPage()-1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		ArrayList<Board> list = (ArrayList)sqlSession.selectList("BoardMapper.selectSearchBoard", searchMap, rowBounds);
		return list;
	}

	public ArrayList<Board> selectAllBoard(SqlSession sqlSession, PageInfo pi){
		//mybatis에서 자체적으로 페이징처리를 위해 RowBounds라는 class를 제공한다.
		//offset : 몇 개의 게시글을 건너뛰고 조회할 것인가
		//boardLimit : 몇 개의 게시글을 가지고 올 것인가
		//ex:51~60 : 50개를 건너뛰고 10개를 가지고 온다.
		
		
		// 한 페이지에 보여줄 boardLimit  1-> 1~10 2 -> 11~20
		int offset = (pi.getCurrentPage()-1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		ArrayList<Board> list = (ArrayList)sqlSession.selectList("BoardMapper.selectAllBoard", null, rowBounds);
		// 다운캐스팅인지 명확하지 않으면 instanceof로 확인
		
		return list;
	}

	
	
	public int increaseCount(SqlSession sqlSession, int boardNo) {
		return sqlSession.update("BoardMapper.increaseCount", boardNo);
	}
	
	public Board selectBoardByBoardNo(SqlSession sqlSession, int boardNo){
		return sqlSession.selectOne("BoardMapper.selectBoardByBoardNo", boardNo);
	}
	
	public Attachment selectAttachment(SqlSession sqlSession, int boardNo){
		return sqlSession.selectOne("BoardMapper.selectAttachment", boardNo);
	}
	
	public ArrayList<Category> selectAllCategory(SqlSession sqlSession){
		return (ArrayList)sqlSession.selectList("BoardMapper.selectAllCategory");
	}
	
	public int updateBoard(SqlSession sqlSession, Board board) {
		return sqlSession.update("BoardMapper.updateBoard", board);
	}
	
	// 게시글 삭제
    public int deleteBoard(SqlSession sqlSession, int boardNo) {
        return sqlSession.update("BoardMapper.deleteBoard", boardNo);
    }
	
	public int insertBoard(SqlSession sqlSession, Board board) {
		return sqlSession.insert("BoardMapper.insertBoard", board);
	}
	
	public int insertAttachment(SqlSession sqlSession, Attachment at) {
		return sqlSession.insert("BoardMapper.insertAttachment", at);
	}
	
	public int insertNewAttachment(SqlSession sqlSession, Attachment at) {
		return sqlSession.insert("BoardMapper.insertNewAttachment", at);
	}
	
	public int updateAttachment(SqlSession sqlSession, Attachment at) {
		return sqlSession.update("BoardMapper.updateAttachment", at);
	}
	
	public int insertReply(SqlSession sqlSession, Reply r) {
		return sqlSession.insert("BoardMapper.insertReply", r);
	}
	
	public ArrayList<Reply> selectReplyByBoardNo(SqlSession sqlSession, int boardNo){
		return (ArrayList)sqlSession.selectList("BoardMapper.selectReplyByBoardNo", boardNo);
	}
	
	public int deleteReply(SqlSession sqlSession, int replyNo) {
		return sqlSession.update("BoardMapper.deleteReply", replyNo);
	}
	
	public ArrayList<Board> selectThumbnailList(SqlSession sqlSession) {
		return (ArrayList)sqlSession.selectList("BoardMapper.selectThumbnailList");
	}
	
	public int insertThumbnailBoard(SqlSession sqlSession, Board board) {
		return sqlSession.insert("BoardMapper.insertThumbnailBoard", board);
	}
	
	public int insertThumbnailAttachment(SqlSession sqlSession, Attachment at) {
		return sqlSession.insert("BoardMapper.insertThumbnailAttachment", at);
	}

	public ArrayList<Attachment> selectAttachmentList(SqlSession sqlSession, int boardNo) {
		return (ArrayList)sqlSession.selectList("BoardMapper.selectAttachmentList", boardNo);
	}
	
	public Board selectThumbnailBoardByBoardNo(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("BoardMapper.selectThumbnailBoardByBoardNo", boardNo);
	}
}
