package com.kh.spring.service;

import com.kh.spring.common.vo.PageInfo;
import com.kh.spring.model.vo.Attachment;
import com.kh.spring.model.vo.Board;
import com.kh.spring.model.vo.Category;
import com.kh.spring.model.vo.Reply;

import java.util.ArrayList;
import java.util.HashMap;

public interface BoardService {
    // 기본 게시판 기능
    int selectAllBoardCount();
    ArrayList<Board> selectAllBoard(PageInfo pi);
    int selectSearchBoardCount(String condition, String keyword);
    ArrayList<Board> selectSearchBoard(PageInfo pi, String condition, String keyword);
    
    // 게시글 상세보기
    Board selectBoardByBoardNo(int boardNo);
    Attachment selectAttachment(int boardNo);
    int increaseCount(int boardNo);
    
    // 게시글 작성/수정/삭제
    int insertBoard(Board b, Attachment at);
    int updateBoard(Board b, Attachment at);
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
    int insertThumbnailBoard(Board b, ArrayList<Attachment> list);
    ArrayList<Attachment> selectAttachmentList(int boardNo);
}
