package com.kh.jsp.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.kh.jsp.model.vo.Board;
import com.kh.jsp.service.BoardService;

@WebServlet("/delete.bo")
public class DeleteController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public DeleteController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 게시글 번호 추출
            int boardNo = Integer.parseInt(request.getParameter("bno"));
            
            // 게시글 작성자 확인을 위해 게시글 조회
            Board b = new BoardService().selectBoardByBoardNo(boardNo);
            
            if(b == null) {
                request.setAttribute("errorMsg", "존재하지 않는 게시글입니다.");
                request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
                return;
            }

            
            // 게시글 삭제
            int result = new BoardService().deleteBoard(boardNo);
            
            if(result > 0) {
                // alertMsg를 세션에 저장해야 redirect 후에 전달된다.
                request.getSession().setAttribute("alertMsg", "성공적으로 게시글을 삭제하였습니다.");
                response.sendRedirect(request.getContextPath() + "/list.bo");
            } else {
                request.setAttribute("errorMsg", "게시글 삭제에 실패하였습니다.");
                request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
            }
            
        }  catch (Exception e) {
            System.out.println("게시글 삭제 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
            request.setAttribute("errorMsg", "게시글 삭제 중 오류가 발생했습니다.");
            request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
