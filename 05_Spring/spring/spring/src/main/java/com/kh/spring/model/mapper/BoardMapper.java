package com.kh.spring.model.mapper;

import com.kh.spring.model.vo.Attachment;
import com.kh.spring.model.vo.Board;
import com.kh.spring.model.vo.Category;
import com.kh.spring.model.vo.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Category> selectCategories();

    //게시판
    List<Board> selectBoardList(RowBounds rowBounds);
    int selectBoardListCount();
    int selectSearchBoardCount(String condition, String keyword);
    List<Board> selectSearchBoard(RowBounds rowBounds, String condition, String keyword);
    int insertBoard(Board board);
    int increaseCount(int boardNo);
    Board selectBoardByNo(int boardNo);
    Attachment selectAttachmentByBoardNo(int boardNo);
    int updateBoard(Board board);
    int deleteBoard(int boardNo);

    //첨부파일
    int insertAttachment(Attachment attachment);
    int deleteAttachment(int fileNo);
    List<Attachment> selectAttachmentList(int boardNo);

    //댓글
    int insertReply(Reply reply);
    List<Reply> selectReplyListByBoardNo(int boardNo);
    int deleteReply(int replyNo);

    //썸네일 게시판
    List<Board> selectThumbnailList();
    Board selectThumbnailBoardByBoardNo(int boardNo);
    int insertThumbnailBoard(Board board);
    int insertThumbnailAttachment(Attachment attachment);
}
