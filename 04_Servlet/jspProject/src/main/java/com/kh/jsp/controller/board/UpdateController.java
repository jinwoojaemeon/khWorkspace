package com.kh.jsp.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.kh.jsp.model.vo.Board;
import com.kh.jsp.model.vo.Member;
import com.kh.jsp.service.BoardService;

@WebServlet("/update.bo")
public class UpdateController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public UpdateController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 로그인 체크
            HttpSession session = request.getSession();
            Member loginMember = (Member)session.getAttribute("loginMember");
            
            if(loginMember == null) {
                session.setAttribute("alertMsg", "로그인 후 이용 가능합니다.");
                response.sendRedirect(request.getContextPath());
                return;
            }
            
            // 전달받은 데이터 추출
            int boardNo = Integer.parseInt(request.getParameter("boardNo"));
            int category = Integer.parseInt(request.getParameter("category"));
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            
            // Board 객체 생성
            Board b = new Board();
            b.setBoardNo(boardNo);
            b.setCategoryNo(category);
            b.setBoardTitle(title);
            b.setBoardContent(content);
            b.setBoardWriter(loginMember.getMemberNo());
            
            // 게시글 수정
            int result = new BoardService().updateBoard(b);
            
            if(result > 0) {
                session.setAttribute("alertMsg", "성공적으로 게시글을 수정하였습니다.");
                response.sendRedirect(request.getContextPath() + "/detail.bo?bno=" + boardNo);
            } else {
                request.setAttribute("errorMsg", "게시글 수정에 실패하였습니다.");
                request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
            }
            
        } catch (NumberFormatException e) {
            request.setAttribute("errorMsg", "잘못된 데이터입니다.");
            request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("게시글 수정 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
            request.setAttribute("errorMsg", "게시글 수정 중 오류가 발생했습니다.");
            request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
