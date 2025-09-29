package com.kh.jsp.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/confirmPizza.do")

public class PizzaOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PizzaOrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("userName");   
		String phone = request.getParameter("phone");   
		String message = request.getParameter("message"); 
		String address = request.getParameter("address"); 
		
		String pizza = request.getParameter("pizza");
		String[] topping = request.getParameterValues("topping");
		String[] side = request.getParameterValues("side");
		String payment = request.getParameter("payment");
		
		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		request.setAttribute("message", message);
		request.setAttribute("address", address);
		request.setAttribute("pizza", pizza);
		request.setAttribute("topping", topping);
		request.setAttribute("side", side);
		request.setAttribute("payment", payment);
		
	/*
	if(toppingArr != null) {
			for(String topping : toppingArr) {
				switch(topping) {
				case "베이컨":
				case "파인애플" : price += 3000; break;
				case "치즈크러스트":
				case "치즈바이트": price += 2000; break;
				default: price += 1000;
				}
			}
		}
		
		if(sideArr != null) {
			for(String side : sideArr) {
				switch(side) {
				case "콜라":
				case "사이다" : price += 3000; break;
				case "핫소스":
				case "파마산": price += 2000; break;
				default: price += 1000;
				}
			}
		}
		request.setAttribute("price", price);
	 */

		request.getRequestDispatcher("/views/pizza/pizzaPayment.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
