package com.kh.jsp.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.kh.jsp.model.vo.Member;
import com.kh.jsp.service.MemberService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login.me")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");

		Member loginMember = new MemberService().loginMember(userId, userPwd);
		
		if(loginMember == null) {
			request.setAttribute("errorMsg", "로그인에 실패하였습니다.");

			// forward 방식 -> 해당 url이 변경되지 않고 기존 url에 덮어씌워진다.
			// 기본적으로 localhost:8000/jsp/login.me 의 url을 유지하면서 로그인 실패 페이지를 보여준다.
			// 로그인 실패는 해당 요청에 대한 실패이므로 url을 유지하도록한다.
			// 따라서 error.jsp 페이지를 forward 방식으로 사용하여 보여주면 된다.
			request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
		} else {  // 로그인 성공 -> 성공 메세지를 포함해서 메인으로 이동 
			HttpSession session = request.getSession();  // 세션에다가 로그인 정보를 담아서 메인 페이지로 이동 >> 세션로그인 방식  
			// 서버가 여러개가 되는 분산 시스템 환경에서는 session 방식을 사용하는 것이 좋지 않다. (세션 정보가 유지가 되지 않는다.)
			session.setAttribute("alertMsg", "로그인에 성공하였습니다.");	
			session.setAttribute("loginMember", loginMember);

			// url 재요청 방식
			// 기존에 해당 페이지를 응답하는 url이 존재한다면 굳이 해당 url를 유지하면서 
			// 다른 화면을 보여주는 것이 아니라, 내가 응답을 원하는 url에 다시 요청하도록 한다.
			// 응답 페이지 -> index.jsp -> url : /jsp
			// 성공 시 메인화면(localhost:8000/jsp)로 url 재요청을 응답으로 보낸다.
			response.sendRedirect(request.getContextPath());
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
