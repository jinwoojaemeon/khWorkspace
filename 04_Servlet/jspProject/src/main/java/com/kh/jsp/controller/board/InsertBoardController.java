package com.kh.jsp.controller.board;

import java.io.IOException;

import com.kh.jsp.model.vo.Board;
import com.kh.jsp.model.vo.Member;
import com.kh.jsp.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class InsertBoardController
 */
@WebServlet("/insert.bo")
public class InsertBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글 추가
		
		// 로그인 체크
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if(loginMember == null) {
			session.setAttribute("alertMsg", "로그인이 필요합니다.");
			response.sendRedirect(request.getContextPath());
			return;
		}
		
		// 전달받은 데이터를 추출
		int category = Integer.parseInt(request.getParameter("category"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int boardWriter = loginMember.getMemberNo(); // 로그인한 회원번호
		
		// Board 객체 생성
		Board b = new Board();
		b.setBoardType(1);  // 일반 게시판
		b.setCategoryNo(category);
		b.setBoardTitle(title);
		b.setBoardContent(content);
		b.setBoardWriter(boardWriter);
		
		// 게시글 작성
		int result = new BoardService().insertBoard(b);
		
		if(result > 0) { // 작성성공
			request.getSession().setAttribute("alertMsg", "성공적으로 게시글을 작성하였습니다.");
			
			response.sendRedirect(request.getContextPath() + "/list.bo");
		} else { // 작성실패
			request.setAttribute("errorMsg", "게시글 작성에 실패하였습니다.");
			request.getRequestDispatcher("views/common/error.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}