<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%  
		String name = (String)request.getAttribute("name");
		int age = (Integer)request.getAttribute("age");
		String gender = (String)request.getAttribute("gender"); 
		String address = (String)request.getAttribute("address"); 
		double height = (Double)request.getAttribute("height"); 
		String[] foods = (String[])request.getAttribute("food"); 
	%>
	<h2>개인정보 응답화면</h2>
	<span><%=name %>님은</span> <br>
	<span><%=age %>살이며</span> <br>
	<span><%=address %>에 살고 있습니다.</span>
	
</body>
</html>