package com.kh.spring.controller;

import com.kh.spring.service.BoardService;
import com.kh.spring.common.vo.PageInfo;
import com.kh.spring.model.vo.Board;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("list.bo")
    public ModelAndView listBoard(@RequestParam(value = "cpage", required = false) Integer cpage, ModelAndView mv){
        int currentPage = cpage != null ? cpage : 1;
        int listCount = boardService.selectAllBoardCount();
        PageInfo pi = new PageInfo(currentPage, listCount, 5, 5);
        ArrayList<Board> list = boardService.selectAllBoard(pi);
        mv.addObject("list", list);
        mv.addObject("pi", pi);
        mv.setViewName("board/listView");
        return mv;
    }

    @GetMapping("search.bo")
    public ModelAndView searchBoard(@RequestParam(value = "cpage", required = false) Integer cpage, @RequestParam(value = "condition") String condition, @RequestParam(value = "keyword") String keyword, ModelAndView mv){
        int currentPage = cpage != null ? cpage : 1;
        int listCount = boardService.selectSearchBoardCount(condition, keyword);
        PageInfo pi = new PageInfo(currentPage, listCount, 5, 5);
        ArrayList<Board> list = boardService.selectSearchBoard(pi, condition, keyword);
        mv.addObject("list", list);
        mv.addObject("pi", pi);
        mv.setViewName("board/listView");
        return mv;
    }

}
