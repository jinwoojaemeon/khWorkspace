package com.kh.spring.model.mapper;

import com.kh.spring.model.vo.Attachment;
import com.kh.spring.model.vo.Board;
import com.kh.spring.model.vo.Category;
import com.kh.spring.model.vo.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface BoardMapper {
    // 기본 게시판 기능
    int selectAllBoardCount();
    ArrayList<Board> selectAllBoard(RowBounds rowBounds);
    int selectSearchBoardCount(String condition, String keyword);
    ArrayList<Board> selectSearchBoard(RowBounds rowBounds, String condition, String keyword);
    
    // 게시글 상세보기
    Board selectBoardByBoardNo(int boardNo);
    Attachment selectAttachment(int boardNo);
    int increaseCount(int boardNo);
    
    // 게시글 작성/수정/삭제
    int insertBoard(Board board);
    int insertAttachment(Attachment at);
    int insertNewAttachment(Attachment at);
    int updateBoard(Board board);
    int updateAttachment(Attachment at);
    int deleteBoard(int boardNo);
    
    // 카테고리
    ArrayList<Category> selectAllCategory();
    
    // 댓글 기능
    int insertReply(Reply r);
    ArrayList<Reply> selectReplyByBoardNo(int boardNo);
    int deleteReply(int replyNo);
    
    // 썸네일 게시판
    ArrayList<Board> selectThumbnailList();
    Board selectThumbnailBoardByBoardNo(int boardNo);
    int insertThumbnailBoard(Board board);
    int insertThumbnailAttachment(Attachment at);
    ArrayList<Attachment> selectAttachmentList(int boardNo);
}
