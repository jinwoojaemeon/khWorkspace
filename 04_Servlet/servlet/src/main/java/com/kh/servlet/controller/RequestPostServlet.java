package com.kh.servlet.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestPostServlet
 */
@WebServlet("/posttest.do") 
public class RequestPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RequestPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST 방식 같은 경우에도 동일하게 데이터를 이용하면 된다.
		String name = request.getParameter("userName");    // 이름 | "" 
		String gender = request.getParameter("gender");    //  M | F | NULL
		int age = Integer.parseInt(request.getParameter("age"));  // "55" -> 55 | ""
		String address = request.getParameter("address");  // "서울" | "대구" ...  | ""
		double height = Double.parseDouble(request.getParameter("height"));  // 178.7  | ""
		
		// checkbox와 같이 여러개의 값을 추출하고자할 때
		String[] foods = request.getParameterValues("food");  // ["한식", "중식" ... ] || NULL
		
		System.out.println("name : " + name);
		System.out.println("gender : " + gender);
		System.out.println("age : " + age);
		System.out.println("address : " + address);
		System.out.println("height : " + height);
		System.out.println("foods : " + String.join(", ", foods));
		
		// 응답 HTML을 생성하는 과정을 JSP 템플릿 엔진에 위임
		// 단, 응답 화면에서 필요로 하는 데이터를 잘 담아서 전달해줘야한다.
		// 데이터를 전달하기 위한 공간 -> request의 attribute영역
		// request.setAttribute("키", "값");
		
		request.setAttribute("name", name);
		request.setAttribute("gender", gender);
		request.setAttribute("age", age);
		request.setAttribute("address", address);
		request.setAttribute("height", height);
		request.setAttribute("foods", foods);
		
		// 현재 요청을 responsePage.jsp로 전달 
		// RequestDispatcher -> 서블릿에 다른 리소스(jsp, 또 다른 서블릿)로 요청을 전달(포워드)하거나
		// 기존 응답에 내용을 추가할 수 있게 해주는 객체 
		RequestDispatcher view = request.getRequestDispatcher("/views/responsePage.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST 요청이나 GET 요청에 대해서 동일하게 응답을 하겠다.
		// GET과 POST를 정하기 이전에 특정 URL로 요청이 되었다는 것은 특정 기능을 수행하겠다는 의미
		// 결과는 같은 페이지를 출력, 응답하는 입장에서 다르게 코드를 작성할 이유가 없다.
		doGet(request, response);
	}

}
