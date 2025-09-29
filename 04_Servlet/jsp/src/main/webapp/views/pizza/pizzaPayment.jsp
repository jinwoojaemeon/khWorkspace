<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%  
	String name = (String)request.getAttribute("name");
	String phone = (String)request.getAttribute("phone");
	String message = (String)request.getAttribute("message"); 
	String address = (String)request.getAttribute("address"); 
	
	String pizza = (String)request.getAttribute("pizza"); 
	String[] topping = (String[])request.getAttribute("topping");
	String[] side = (String[])request.getAttribute("side");
	String payment = (String)request.getAttribute("payment");	
	%>
	
	<% 
		int pizzaCost=0;
		if(pizza.equals("콤비네이션")){
			pizzaCost = 20000;
		}else if(pizza.equals("치즈피자") || pizza.equals("포테이토피자")){
			pizzaCost = 23000;
		}else{
			pizzaCost = 25000;
		}
		
		int totalToppCost = 0;
		for(String topp : topping){
			if(topp.equals("베이컨") || topp.equals("파인애플")){
				totalToppCost += 3000;
			}else if(topp.equals("치즈크러스트") || topp.equals("치즈바이트")){
				totalToppCost += 2000;
			}else{
				totalToppCost += 1000;
			}
		}
		int totalSideCost = 0;
		for(String sideMenu : side){
			if(sideMenu.equals("환타") || sideMenu.equals("콜라")){
				totalToppCost += 3000;
			}else if(sideMenu.equals("핫소스") || sideMenu.equals("파마산") || sideMenu.equals("피클")){
				totalToppCost += 2000;
			}else{
				totalToppCost += 1000;
			}
		}
		
		int totalBill = pizzaCost + totalToppCost + totalSideCost;
	%>
<!DOCTYPE html> <!-- HTML은 markup lauguage이기 때문에 한눈에 파악하기 쉬워야 하므로, 최대한 다른 코드들을 html 내부에 넣는 것을 지양하는것이 좋다. -->
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
	<h1>피자 결제 페이지</h1>
	
	<h2>주문내역</h2>
	
	<h3>[주문자 정보]</h3>
	<ul>
		<li>성함 : <%=name %></li>
		<li>전화번호 : <%=phone %></li>
		<li>address : <%=address %></li>
		<li>요청사항 : <%=message %></li>
	</ul>
	
	<h3>[주문 정보]</h3>
	<ul>
		<li>피자 : <%=pizza %></li>
		<li>토핑 : <%= (topping != null ? String.join(", ", topping) : "토핑 선택 안함") %></li>
		<li>사이드 : <%= (side != null ? String.join(", ", side) : "사이드 선택 안함") %></li>
		<li>결제방식 : <%=payment %></li>
	</ul>
	<h3>위와 같이 주문하셨습니다.</h3>
	<h2>총 가격 : <%=totalBill %>원 </h2>
</body>
</html>