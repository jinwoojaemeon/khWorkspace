package com.kh.spring.service;

import com.kh.spring.common.vo.PageInfo;
import com.kh.spring.model.mapper.BoardMapper;
import com.kh.spring.model.vo.Board;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;

    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

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
}
