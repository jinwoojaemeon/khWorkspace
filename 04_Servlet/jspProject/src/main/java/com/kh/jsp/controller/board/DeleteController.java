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

@WebServlet("/delete.bo")
public class DeleteController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public DeleteController() {
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
            
            // 게시글 작성자 확인을 위해 게시글 조회
            Board b = new BoardService().selectBoardForUpdate(boardNo);
            
            if(b == null) {
                request.setAttribute("errorMsg", "존재하지 않는 게시글입니다.");
                request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
                return;
            }
            
            // 작성자 체크
            if(b.getBoardWriter() != loginMember.getMemberNo()) {
                request.setAttribute("errorMsg", "본인이 작성한 게시글만 삭제할 수 있습니다.");
                request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
                return;
            }
            
            // 게시글 삭제
            int result = new BoardService().deleteBoard(boardNo, loginMember.getMemberNo());
            
            if(result > 0) {
                session.setAttribute("alertMsg", "성공적으로 게시글을 삭제하였습니다.");
                response.sendRedirect(request.getContextPath() + "/list.bo");
            } else {
                request.setAttribute("errorMsg", "게시글 삭제에 실패하였습니다.");
                request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
            }
            
        } catch (NumberFormatException e) {
            request.setAttribute("errorMsg", "잘못된 게시글 번호입니다.");
            request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
        } catch (Exception e) {
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
