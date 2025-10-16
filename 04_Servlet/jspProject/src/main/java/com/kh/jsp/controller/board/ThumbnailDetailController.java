package com.kh.jsp.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.kh.jsp.model.vo.Attachment;
import com.kh.jsp.model.vo.Board;
import com.kh.jsp.service.BoardService;

/**
 * Servlet implementation class ThumbnailDetailController
 */
@WebServlet("/detail.th")
public class ThumbnailDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThumbnailDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 조회 수 증가
		// 보드 정보 조회 -> 첨부파일이 여러 개 일 수 있다.
		//thumbnailDetailView.jsp 응답

		int boardNo = Integer.parseInt(request.getParameter("bno"));
		BoardService boardService = new BoardService();
		int result = boardService.increaseCount(boardNo);
		Board board = boardService.selectThumbnailBoardByBoardNo(boardNo);
		if(result > 0 && board != null) {
			ArrayList<Attachment> list = boardService.selectAttachmentList(boardNo);
			request.setAttribute("board", board);
			request.setAttribute("list", list);
			request.getRequestDispatcher("views/board/thumbnailDetailView.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMsg", "정상적인 접근이 아닙니다.");
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
