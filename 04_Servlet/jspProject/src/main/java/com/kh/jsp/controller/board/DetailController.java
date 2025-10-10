package com.kh.jsp.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kh.jsp.model.vo.Board;
import com.kh.jsp.service.BoardService;

@WebServlet("/detail.bo")
public class DetailController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public DetailController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 게시글 번호 추출
            int boardNo = Integer.parseInt(request.getParameter("bno"));
            System.out.println("게시글 번호: " + boardNo);
            
            Board b = new BoardService().selectBoard(boardNo);
            System.out.println("조회된 게시글: " + b);
            
            if(b != null) {
                request.setAttribute("b", b);
                request.getRequestDispatcher("/views/board/detailView.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMsg", "존재하지 않는 게시글입니다.");
                request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
            }
        }  catch (Exception e) {
            System.out.println("게시글 조회 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
            request.setAttribute("errorMsg", "게시글 조회 중 오류가 발생했습니다.");
            request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
