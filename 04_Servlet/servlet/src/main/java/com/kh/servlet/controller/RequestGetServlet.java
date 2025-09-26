package com.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *  @WebServlet 어노테이션을 통해 해당 객체가 서블릿이며
 *     /gettest.do로 요청을 받으면 실행해줄 servlet이라는 맵핑을 진행한다.
 * 
 *  http://localhost:8001/servlet/gettest.do로 요청시 응답하는 서블릿
 *  servlet의 요청경로는 contextPath 뒤에 작성된다.
 */


@WebServlet("/gettest.do")
public class RequestGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RequestGetServlet() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get 방식으로 요청 시 doGet 메서드를 실행하여 요청을 처리해 준다.(tomcat이 서블릿 객체를 생성해서 메서드 호출까지 해준다.)
		System.out.println("서불릿 응답 완료");
		
		/*
			HttpServletRequest : 요청 시 전달할 내용들이 담겨있는 객체(사용자가 입력한 값, 요청방식, 요청자의 ip, url 등....)
			HttpServletResponse : 요청을 처리 후 응답할 때 사용되는 객체(어떤 타입으로 응답할지, 어떤 값을 응답할지 등을 작성)
			
			요청 처리를 위해서 요청 시 전달된 값을 추출
			request의 parameter영역 안에 전달된 값을 추출 
			request.getParameter("KEY");
			 
		*/
		
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
		
		
		// service > dao > db 
		// 회원 추가에 대한 서비스 로직을 완료했다는 가정하에 
		// 결과는 1 또는 0으로 반환
		
		// 위와 같은 결과에 따라 응답 페이지(html)을 만들어서 응답한다.
		// 즉, 여기 java 코드 내에서 사용자가 보게 될 응답 html을 작성
		
		// reponse 객체를 통해서 응답
		
		// 1) 응답으로 출력할 내용은 html이고 문자셋은 utf-8이다 -> 선언해야한다. 
		response.setContentType("text/html; charset=utf-8");
		
		// 2) 응답받는 사용자와의 스트림을 연결
		PrintWriter out = response.getWriter();
		
		/**
		 * <html>
		 *  <head>
		 *  </head>
		 *  <body>
		 *  	<h2>개인정보 응답화면</h2>
		 *  	<span>jaemeon은</span>
		 *  	<span>나이가 ...이며...</span>
		 *  </body>
		 * </html>
		 */
		out.println("<html>");
		out.println("<head>");
		out.println("<body>");
		out.printf("<h2>개인정보 응답화면</h2>");
		
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
