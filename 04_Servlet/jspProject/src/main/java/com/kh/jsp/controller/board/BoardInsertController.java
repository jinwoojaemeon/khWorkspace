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

/**
 * Servlet implementation class BoardInsertController
 */
@WebServlet("/insert.bo")
public class BoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 체크
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if(loginMember == null) {
			session.setAttribute("alertMsg", "로그인 후 이용 가능합니다.");
			response.sendRedirect(request.getContextPath());
			return;
		}
		
		int category = Integer.parseInt(request.getParameter("category"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// Board 객체 생성 (DB 구조에 맞춤)
		Board b = new Board();
		b.setBoardType(1);  // 일반 게시판
		b.setCategoryNo(category);
		b.setBoardTitle(title);
		b.setBoardContent(content);
		b.setBoardWriter(loginMember.getMemberNo()); 
		
		// 게시글 작성
		int result = new BoardService().insertBoard(b);
		
		if(result > 0) {
			session.setAttribute("alertMsg", "성공적으로 게시글을 작성하였습니다.");
			response.sendRedirect(request.getContextPath() + "/list.bo");
		} else {
			request.setAttribute("errorMsg", "게시글 작성에 실패하였습니다.");
			request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
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
