package com.kh.jsp.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.kh.jsp.model.vo.Board;
import com.kh.jsp.service.BoardService;

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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 현재 페이지 파라미터 받기 (기본값: 1)
			int currentPage = 1;
			String pageParam = request.getParameter("page");
			if(pageParam != null && !pageParam.isEmpty()) {
				currentPage = Integer.parseInt(pageParam);
			}
			
			// 게시글 총 개수 조회
			int totalCount = new BoardService().selectBoardCount();
			
			// 페이지네이션 정보 계산
			int[] paginationInfo = new BoardService().calculatePagination(currentPage, totalCount);
			int totalPages = paginationInfo[1];
			int startPage = paginationInfo[2];
			int endPage = paginationInfo[3];
			int hasPrev = paginationInfo[4];
			int hasNext = paginationInfo[5];
			
			// board 목록을 가져와서 응답 페이지로 전달 (페이지네이션 적용)
			List<Board> list = new BoardService().selectBoardList(currentPage);
			
			// JSP로 전달할 데이터 설정
			request.setAttribute("list", list);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("hasPrev", hasPrev);
			request.setAttribute("hasNext", hasNext);
			request.setAttribute("totalCount", totalCount);
			
			request.getRequestDispatcher("views/board/listView.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			// 잘못된 페이지 번호인 경우 1페이지로 리다이렉트
			response.sendRedirect(request.getContextPath() + "/list.bo?page=1");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", "게시글 목록 조회 중 오류가 발생했습니다.");
			request.getRequestDispatcher("views/common/error.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
