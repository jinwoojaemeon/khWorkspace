<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList, java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=divice=width, initial-scale=1.0">
<title>DOCUMENT</title>
</head>
<body>	
	<h1> page 지시어 </h1>
    <%
    	ArrayList<String> list = new ArrayList<>();
    	list.add("servlet");
    	list.add("jsp");
    	
    	Date today = new Date();
    %>
    
    0번째 인덱스 : <%=list.get(0) %> <br>
    현재 날짜와 시간 : <%=today %>)
    
    <h1>include 지시어</h1>
    <div style="border:1px solid black">
    	<%@ include file="01_scripting_elements.jsp" %>
    </div>
    정적포함 -> 컴파일 전에 include되는 방식으로 포함한 변수를 가져와 사용할 수 있다.
    1부터 100까지의 총합 : <%=sum %>
</body>
</html>