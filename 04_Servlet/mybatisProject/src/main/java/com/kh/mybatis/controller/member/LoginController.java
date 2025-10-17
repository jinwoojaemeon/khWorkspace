package com.kh.mybatis.controller.member;

import java.io.IOException;

import com.kh.mybatis.model.vo.Member;
import com.kh.mybatis.service.MemberService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login.me")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청시 전달한 값을 추출
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		Member loginMember = new MemberService().loginMember(userId, userPwd);
		
		if(loginMember == null) { 
			request.setAttribute("errorMsg", "로그인에 실패하였습니다.");
			request.getRequestDispatcher("views/common/error.jsp").forward(request, response);
		} else { 
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
			session.setAttribute("alertMsg", "로그인 성공");
			
			response.sendRedirect(request.getContextPath());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
