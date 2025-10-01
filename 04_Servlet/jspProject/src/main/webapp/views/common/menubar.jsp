<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <!-- 부트스트랩 5.3.3 기본 css 설정들이 포함되어 있다. -->
     <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

    <!-- google font noto sans kr -->
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
    <style>
        body{
            font-family: "Noto Sans KR", sans-serif;
            font-optical-sizing: auto;
            font-weight: 400px;
            font-style: normal;
        }
        a{
            text-decoration: none;
            color: black;
        }
        ul, li, ol{
            list-style: none; /* 목록 기호 제거 */
            margin: 0;
            padding: 0;
        }

        h1{
            padding: 24px 0;
        }
        .login-area {
            display: flex; /* 가로 정렬 */
            align-items: center; /* 세로 정렬 */
            justify-content: flex-end; /* 우측 정렬 */
        }

        .login-area input[type=submit],
        .login-area input[type=button]{
            width:50%;
            float: left;
        }
        
        .logout-area {
            display: flex;
            flex-direction: column;
            align-items: flex-end;
        }
        
        .logout-area > div{
            display: flex; 
            justify-content: flex-start; /* 좌측 정렬 */
            align-items: center; 
            padding: 12px 0;
            gap : 12px;
        }
        .main-nav{background: black;}
        .main-nav ul{
            display: flex;
            flex-direction: row;
        }
        .main-nav ul li{
            width: 150px;
            height: 50px;
        }
        .main-nav ul li a{
            color: white;
            font-size: 20px;
            font-weight: bold;
            text-align: center;
            width: 100%;
            height: 100%;
            line-height: 50px;
            text-align: center;
            display: inline-block;
        }
    </style>
</head>
<body>
    <c:if test="${not empty alertMsg}">
        <script>
            alert("${alertMsg}");
        </script>
        <c:remove var="alertMsg" scope="session"/>
    </c:if>
    <h1 align="center">Welcome KH World</h1>
    
    <div class="login-area">
    <c:choose>
    	<c:when test="${empty sessionScope.loginMember}">
            <form action="${pageContext.request.contextPath}/login.me" method="post">
                <table>
                    <tr>
                        <th>아이디</th>
                        <td><input type="text" name="userId" required></td>
                    </tr>
                    <tr>
                        <th>비밀번호</th>
                        <td><input type="password" name="userPwd" required></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="로그인">
                            <input type="button" value="회원가입" onclick="enrollPage();">
                        </td>
                    </tr>
                </table>
            </form>
       </c:when>
            
            <c:otherwise>
                <div class="logout-area">
                    <div>
                        <b>${sessionScope.loginMember.memberName}님</b> 방문을 환영합니다.
                    </div>
                    <div>
                        <a href="">마이페이지</a>
                        <a href="${pageContext.request.contextPath}/logout.me">로그아웃</a>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
    </div>

    <script>
        function enrollPage(){
            // location.href = "http://localhost:8000/jsp/views/member/enrollForm.jsp"; 
            // 내부 디렉터리 구조를 유추할 수 있는 단서가 될 수 있기 때문에 디렉터리 구조를 url에 직접 노출하지 않고 
            // 서블릿을 통해 요청하는 매핑 주소를 사용하는 것이 좋다.
            location.href = "${pageContext.request.contextPath}/enrollForm.me"; // 서버에서 사용하는 코드? jsp>el: server side 랜더링
            // 단순한 페이지 요청도 servlet을 거쳐가도록 할 것이다. (url에는 서버 요청을 위한 매핑값이 나타나도록)
        }
    </script>
    
    <nav class="main-nav">
        <ul>
            <li><a href="">HOME</a></li>
            <li><a href="">공지사항</a></li>
            <li><a href="">일반게시판</a></li>
            <li><a href="">사진게시판</a></li>
        </ul>
    </nav>
</body>
</html>