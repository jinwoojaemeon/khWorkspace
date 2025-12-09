package com.kh.board.service;

import com.kh.board.entity.Board;
import com.kh.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {


    private final BoardMapper boardMapper;

    @Override
    public List<Board> findAll() {
        return boardMapper.findAll();
    }

    @Override
    public int save(Board board) {
        return boardMapper.save(board);
    }

    @Override
    public Board getBoardById(String boardId) {
        Board board = boardMapper.getBoardById(boardId);
        if(board != null){
            return board;
        } else {
            return null;
        }
    }
}
