<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <% 
        String year = new java.text.SimpleDateFormat("yyyy").format(new java.util.Date());
    %>
    
    Copyright © 1998-<%=year %> KH Information Educational Institute All Right Reserved <br>
    test : ${param.test}
</body>
</html>