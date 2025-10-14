package com.kh.jsp.controller.board;

import java.io.IOException;
import java.util.ArrayList;

import com.kh.jsp.model.vo.Board;
import com.kh.jsp.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/list.bo")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//board목록을 가져와서 응답페이지로 전달
		
		// 페이징 처리
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int boardLimit = 10; // 한 페이지에 보여질 게시글 개수
		int pageLimit = 5;   // 한 페이지에 보여질 페이징 개수
		
		BoardService bService = new BoardService();
		
		// 전체 게시글 개수 조회
		int listCount = bService.selectListCount();
		
		// 페이지네이션 계산
		int maxPage = (int)Math.ceil((double)listCount / boardLimit);
		int startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		int endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		// 현재 페이지에 해당하는 게시글 목록 조회
		ArrayList<Board> list = bService.selectBoardList(currentPage, boardLimit);
		
		// request에 데이터 담기
		request.setAttribute("list", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("listCount", listCount);
		
		request.getRequestDispatcher("views/board/listView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
