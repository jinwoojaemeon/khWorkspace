package com.kh.spring.service;

import com.kh.spring.model.vo.Board;
import com.kh.spring.model.vo.Category;
import com.kh.spring.model.vo.Reply;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface BoardService {
    //카테고리 관련
    List<Category> getCategories();

    //게시판 관련
    Map<String, Object> getBoardList(int currentPage);
    Map<String, Object> getSearchBoardList(int currentPage, String condition, String keyword);
    int insertBoard(Board board, MultipartFile file);
    Map<String,Object> getBoardByIdWithCount(int boardNo);
    Map<String,Object> getBoardById(int boardNo);
    int updateBoard(Board board, MultipartFile file, Integer originFileNo);
    int deleteBoard(int boardNo);

    //댓글관련
    int insertReply(Reply reply);
    List<Reply> getReplyListByBoardNo(int boardNo);
    int removeReply(int replyNo);

    //썸네일 게시판 관련
    List<Board> getThumbnailList();
    Map<String, Object> getThumbnailBoardDetail(int boardNo);
    int insertThumbnailBoard(Board board, List<MultipartFile> attachmentList);
}

