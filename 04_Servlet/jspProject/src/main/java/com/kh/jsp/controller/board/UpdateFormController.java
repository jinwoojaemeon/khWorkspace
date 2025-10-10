package com.kh.jsp.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.kh.jsp.model.vo.Board;
import com.kh.jsp.model.vo.Category;
import com.kh.jsp.model.vo.Member;
import com.kh.jsp.service.BoardService;

@WebServlet("/updateForm.bo")
public class UpdateFormController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public UpdateFormController() {
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
            
            // 게시글 번호 추출
            int boardNo = Integer.parseInt(request.getParameter("bno"));
            
            Board b = new BoardService().selectBoardForUpdate(boardNo);
            
            if(b == null) {
                request.setAttribute("errorMsg", "존재하지 않는 게시글입니다.");
                request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
                return;
            }
            
            // 작성자 체크
            if(b.getBoardWriter() != loginMember.getMemberNo()) {
                request.setAttribute("errorMsg", "본인이 작성한 게시글만 수정할 수 있습니다.");
                request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
                return;
            }
            
            // 카테고리 목록 조회
            List<Category> categoryList = new BoardService().selectCategoryList();
            
            request.setAttribute("b", b);
            request.setAttribute("categoryList", categoryList);
            request.getRequestDispatcher("/views/board/updateForm.jsp").forward(request, response);
            
        } catch (NumberFormatException e) {
            request.setAttribute("errorMsg", "잘못된 게시글 번호입니다.");
            request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("게시글 수정폼 조회 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
            request.setAttribute("errorMsg", "게시글 수정폼 조회 중 오류가 발생했습니다.");
            request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
