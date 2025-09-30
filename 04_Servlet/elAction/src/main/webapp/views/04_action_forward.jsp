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
    <h1>jsp:forward</h1>
    <p>
        서버 내부에서 "내부 리다이렉트(다시요청)"을 활용하며 현재 요청의 처리를 다른 페이지(jsp)에 위임하는 기능 <br>
        현재 jspp에서 요청과 응답 객체를 그대로 다음 리소스(jsp/servlet)으로 내부 전달하고 현재 페이지의 처리를 즉시 종료한다. <br>
        브라우저는 다른 페이지로 전달된 사실을 알 수 없다. >> url이 변경되지 않는다.
    </p>
    <jsp:forward page="footer.jsp" />
</body>
</html>