package com.kh.spring.controller;

import com.kh.spring.service.BoardService;
import com.kh.spring.common.vo.PageInfo;
import com.kh.spring.model.vo.Attachment;
import com.kh.spring.model.vo.Board;
import com.kh.spring.model.vo.Category;
import com.kh.spring.model.vo.Reply;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 게시글 목록
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

    // 게시글 검색
    @GetMapping("search.bo")
    public ModelAndView searchBoard(@RequestParam(value = "cpage", required = false) Integer cpage, 
                                   @RequestParam(value = "condition") String condition, 
                                   @RequestParam(value = "keyword") String keyword, 
                                   ModelAndView mv){
        int currentPage = cpage != null ? cpage : 1;
        int listCount = boardService.selectSearchBoardCount(condition, keyword);
        PageInfo pi = new PageInfo(currentPage, listCount, 5, 5);
        ArrayList<Board> list = boardService.selectSearchBoard(pi, condition, keyword);
        mv.addObject("list", list);
        mv.addObject("pi", pi);
        mv.addObject("condition", condition);
        mv.addObject("keyword", keyword);
        mv.setViewName("board/listView");
        return mv;
    }

    // 게시글 상세보기
    @GetMapping("detail.bo")
    public ModelAndView detailBoard(@RequestParam("bno") int boardNo, ModelAndView mv){
        Board board = boardService.selectBoardByBoardNo(boardNo);
        Attachment attachment = boardService.selectAttachment(boardNo);
        ArrayList<Reply> replyList = boardService.selectReplyByBoardNo(boardNo);
        
        if(board != null) {
            boardService.increaseCount(boardNo);
            mv.addObject("board", board);
            mv.addObject("attachment", attachment);
            mv.addObject("replyList", replyList);
            mv.setViewName("board/detailView");
        } else {
            mv.addObject("errorMsg", "게시글 조회 실패");
            mv.setViewName("common/error");
        }
        return mv;
    }

    // 게시글 작성 폼
    @GetMapping("enrollForm.bo")
    public ModelAndView enrollFormBoard(ModelAndView mv){
        ArrayList<Category> categoryList = boardService.selectAllCategory();
        mv.addObject("categoryList", categoryList);
        mv.setViewName("board/enrollForm");
        return mv;
    }

    // 게시글 작성 처리
    @PostMapping("insert.bo")
    public String insertBoard(Board board, 
                            @RequestParam(value = "upfile", required = false) MultipartFile upfile,
                            RedirectAttributes redirectAttributes){
        
        // 임시로 작성자 번호 설정 (실제로는 세션에서 가져와야 함)
        board.setBoardWriter(1);
        
        Attachment attachment = null;
        
        // 파일이 업로드된 경우
        if(upfile != null && !upfile.isEmpty()) {
            attachment = new Attachment();
            attachment.setOriginName(upfile.getOriginalFilename());
            attachment.setChangeName("kh_" + System.currentTimeMillis() + "_" + (int)(Math.random() * 100000) + ".jpg");
            attachment.setFilePath("resources/board-file/");
            
            // 실제 파일 저장 로직 (여기서는 간단히 처리)
            try {
                // 파일 저장 경로 설정
                String savePath = "C:/workspace/05_Spring/spring/spring/src/main/webapp/resources/board-file/";
                upfile.transferTo(new java.io.File(savePath + attachment.getChangeName()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        int result = boardService.insertBoard(board, attachment);
        
        if(result > 0) {
            redirectAttributes.addFlashAttribute("alertMsg", "게시글 작성 성공");
            return "redirect:list.bo";
        } else {
            redirectAttributes.addFlashAttribute("errorMsg", "게시글 작성 실패");
            return "redirect:enrollForm.bo";
        }
    }

    // 게시글 수정 폼
    @GetMapping("updateForm.bo")
    public ModelAndView updateFormBoard(@RequestParam("bno") int boardNo, ModelAndView mv){
        Board board = boardService.selectBoardByBoardNo(boardNo);
        Attachment attachment = boardService.selectAttachment(boardNo);
        ArrayList<Category> categoryList = boardService.selectAllCategory();
        
        if(board != null) {
            mv.addObject("board", board);
            mv.addObject("attachment", attachment);
            mv.addObject("categoryList", categoryList);
            mv.setViewName("board/updateForm");
        } else {
            mv.addObject("errorMsg", "게시글 조회 실패");
            mv.setViewName("common/error");
        }
        return mv;
    }

    // 게시글 수정 처리
    @PostMapping("update.bo")
    public String updateBoard(Board board, 
                            @RequestParam(value = "upfile", required = false) MultipartFile upfile,
                            @RequestParam(value = "originFileNo", required = false) Integer originFileNo,
                            RedirectAttributes redirectAttributes){
        
        Attachment attachment = null;
        
        // 파일이 업로드된 경우
        if(upfile != null && !upfile.isEmpty()) {
            attachment = new Attachment();
            attachment.setOriginName(upfile.getOriginalFilename());
            attachment.setChangeName("kh_" + System.currentTimeMillis() + "_" + (int)(Math.random() * 100000) + ".jpg");
            attachment.setFilePath("resources/board-file/");
            
            if(originFileNo != null) {
                attachment.setFileNo(originFileNo); // 기존 파일이 있는 경우
            }
            
            // 실제 파일 저장 로직
            try {
                String savePath = "C:/workspace/05_Spring/spring/spring/src/main/webapp/resources/board-file/";
                upfile.transferTo(new java.io.File(savePath + attachment.getChangeName()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        int result = boardService.updateBoard(board, attachment);
        
        if(result > 0) {
            redirectAttributes.addFlashAttribute("alertMsg", "게시글 수정 성공");
            return "redirect:detail.bo?bno=" + board.getBoardNo();
        } else {
            redirectAttributes.addFlashAttribute("errorMsg", "게시글 수정 실패");
            return "redirect:updateForm.bo?bno=" + board.getBoardNo();
        }
    }

    // 게시글 삭제
    @GetMapping("delete.bo")
    public String deleteBoard(@RequestParam("bno") int boardNo, RedirectAttributes redirectAttributes){
        int result = boardService.deleteBoard(boardNo);
        
        if(result > 0) {
            redirectAttributes.addFlashAttribute("alertMsg", "게시글 삭제 성공");
        } else {
            redirectAttributes.addFlashAttribute("errorMsg", "게시글 삭제 실패");
        }
        return "redirect:list.bo";
    }

    // 썸네일 게시판 목록
    @GetMapping("list.th")
    public ModelAndView thumbnailListBoard(ModelAndView mv){
        ArrayList<Board> list = boardService.selectThumbnailList();
        mv.addObject("list", list);
        mv.setViewName("board/thumbnailListView");
        return mv;
    }

    // 썸네일 게시판 상세보기
    @GetMapping("detail.th")
    public ModelAndView thumbnailDetailBoard(@RequestParam("bno") int boardNo, ModelAndView mv){
        Board board = boardService.selectThumbnailBoardByBoardNo(boardNo);
        ArrayList<Attachment> attachmentList = boardService.selectAttachmentList(boardNo);
        
        if(board != null) {
            boardService.increaseCount(boardNo);
            mv.addObject("board", board);
            mv.addObject("attachmentList", attachmentList);
            mv.setViewName("board/thumbnailDetailView");
        } else {
            mv.addObject("errorMsg", "게시글 조회 실패");
            mv.setViewName("common/error");
        }
        return mv;
    }

    // 썸네일 게시판 작성 폼
    @GetMapping("enrollForm.th")
    public String thumbnailEnrollFormBoard(){
        return "board/thumbnailEnrollForm";
    }

    // 썸네일 게시판 작성 처리
    @PostMapping("insert.th")
    public String insertThumbnailBoard(Board board, @RequestParam("attachmentList") ArrayList<Attachment> attachmentList, 
                                     RedirectAttributes redirectAttributes){
        int result = boardService.insertThumbnailBoard(board, attachmentList);
        
        if(result > 0) {
            redirectAttributes.addFlashAttribute("alertMsg", "썸네일 게시글 작성 성공");
            return "redirect:list.th";
        } else {
            redirectAttributes.addFlashAttribute("errorMsg", "썸네일 게시글 작성 실패");
            return "redirect:enrollForm.th";
        }
    }

    // 댓글 작성 (Ajax)
    @PostMapping("rinsert.bo")
    @ResponseBody
    public String insertReply(@RequestBody Reply reply){
        int result = boardService.insertReply(reply);
        return result > 0 ? "success" : "fail";
    }

    // 댓글 목록 조회 (Ajax)
    @PostMapping("rlist.bo")
    @ResponseBody
    public ArrayList<Reply> selectReplyList(@RequestParam("bno") int boardNo){
        return boardService.selectReplyByBoardNo(boardNo);
    }

    // 댓글 삭제 (Ajax)
    @PostMapping("rdelete.bo")
    @ResponseBody
    public String deleteReply(@RequestParam("replyNo") int replyNo){
        int result = boardService.deleteReply(replyNo);
        return result > 0 ? "success" : "fail";
    }
}
