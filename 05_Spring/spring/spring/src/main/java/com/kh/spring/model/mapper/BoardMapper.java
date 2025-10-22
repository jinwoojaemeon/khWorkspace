package com.kh.spring.model.mapper;

import com.kh.spring.model.vo.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.ArrayList;

@Mapper
public interface BoardMapper {
    int selectAllBoardCount();
    ArrayList<Board> selectAllBoard(RowBounds rowBounds);
    int selectSearchBoardCount(String condition, String keyword);
    ArrayList<Board> selectSearchBoard(RowBounds rowBounds, String condition, String keyword);
}
