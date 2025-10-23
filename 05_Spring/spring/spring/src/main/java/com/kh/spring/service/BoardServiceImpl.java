package com.kh.spring.service;

import com.kh.spring.common.vo.PageInfo;
import com.kh.spring.model.mapper.BoardMapper;
import com.kh.spring.model.vo.Attachment;
import com.kh.spring.model.vo.Board;
import com.kh.spring.model.vo.Category;
import com.kh.spring.model.vo.Reply;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;

    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    // 기본 게시판 기능
    @Override
    public int selectAllBoardCount() {
        return boardMapper.selectAllBoardCount();
    }

    @Override
    public ArrayList<Board> selectAllBoard(PageInfo pi) {
        int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
        RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
        return boardMapper.selectAllBoard(rowBounds);
    }

    @Override
    public int selectSearchBoardCount(String condition, String keyword) {
        return boardMapper.selectSearchBoardCount(condition, keyword);
    }

    @Override
    public ArrayList<Board> selectSearchBoard(PageInfo pi, String condition, String keyword) {
        int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
        RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
        return boardMapper.selectSearchBoard(rowBounds, condition, keyword);
    }
    
    // 게시글 상세보기
    @Override
    public Board selectBoardByBoardNo(int boardNo) {
        return boardMapper.selectBoardByBoardNo(boardNo);
    }

    @Override
    public Attachment selectAttachment(int boardNo) {
        return boardMapper.selectAttachment(boardNo);
    }

    @Override
    @Transactional
    public int increaseCount(int boardNo) {
        return boardMapper.increaseCount(boardNo);
    }
    
    // 게시글 작성/수정/삭제
    @Override
    @Transactional
    public int insertBoard(Board b, Attachment at) {
        int result = boardMapper.insertBoard(b);
        
        if(at != null) {
            result *= boardMapper.insertAttachment(at);
        }
        
        return result;
    }

    @Override
    @Transactional
    public int updateBoard(Board b, Attachment at) {
        int result = boardMapper.updateBoard(b);
        
        if(at != null) {
            if(at.getFileNo() != 0) { // 기존 첨부파일이 존재할 때
                result *= boardMapper.updateAttachment(at);
            } else { // 기존 첨부파일이 존재하지 않을 때
                result *= boardMapper.insertNewAttachment(at);
            }
        }
        
        return result;
    }

    @Override
    @Transactional
    public int deleteBoard(int boardNo) {
        return boardMapper.deleteBoard(boardNo);
    }
    
    // 카테고리
    @Override
    public ArrayList<Category> selectAllCategory() {
        return boardMapper.selectAllCategory();
    }
    
    // 댓글 기능
    @Override
    @Transactional
    public int insertReply(Reply r) {
        return boardMapper.insertReply(r);
    }

    @Override
    public ArrayList<Reply> selectReplyByBoardNo(int boardNo) {
        return boardMapper.selectReplyByBoardNo(boardNo);
    }

    @Override
    @Transactional
    public int deleteReply(int replyNo) {
        return boardMapper.deleteReply(replyNo);
    }
    
    // 썸네일 게시판
    @Override
    public ArrayList<Board> selectThumbnailList() {
        return boardMapper.selectThumbnailList();
    }

    @Override
    public Board selectThumbnailBoardByBoardNo(int boardNo) {
        return boardMapper.selectThumbnailBoardByBoardNo(boardNo);
    }

    @Override
    @Transactional
    public int insertThumbnailBoard(Board b, ArrayList<Attachment> list) {
        int result = boardMapper.insertThumbnailBoard(b);
        
        if(result > 0 && !list.isEmpty()) {
            for(Attachment at : list) {
                result *= boardMapper.insertThumbnailAttachment(at);
            }
        }
        
        return result;
    }

    @Override
    public ArrayList<Attachment> selectAttachmentList(int boardNo) {
        return boardMapper.selectAttachmentList(boardNo);
    }
}
