<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .container{
            padding: 58px 24px;
            flex-direction: column; /* 세로 정렬 */
            display: flex;
            justify-content: center;
            align-items: center;
            gap: 24px;
        }

        .container table tr{
            height: 52px;
        }
    </style>
    
</head>
<body>
    <jsp:include page="/views/common/menubar.jsp" />
    <div class="container">
        <h2>회원가입</h2>
        <form id="enroll-form" action="${pageContext.request.contextPath}/insert.me" method="post">
            <table>
                <tr>
                    <td><input type="text" class="form-control" name="userId" placeholder="아이디" required></td>
                    <td><button type="button" class="btn btn-primary" onclick="idDuplicateCheck()" >중복확인</button></td>
                </tr>
                <tr>
                    <td><input type="password" class="form-control" name="userPwd" placeholder="비밀번호" required></td>
                    <td></td>
                </tr>
                <tr>primary
                    <td><input type="password" class="form-control" name="userPwdCheck" placeholder="비밀번호 확인" required></td>
                    <td></td>
                </tr>
                <tr>
                    <td><input type="text" class="form-control" name="userName" placeholder="이름" required></td>
                    <td></td>
                </tr>
                <tr>
                    <td><input type="text" class="form-control" name="phone" placeholder="전화번호"></td>
                    <td></td>
                </tr>
                <tr>
                    <td><input type="email" class="form-control" name="email" placeholder="이메일"></td>
                    <td></td>
                </tr>
                <tr>
                    <td><input type="text" class="form-control" name="address" placeholder="주소"></td>
                    <td></td>
                </tr>
                <tr>
                    <td colspan="2" class="form-check">
                        <label class="form-check-label"><input type="checkbox" name="interest" value="sports">운동</label>
                        <label class="form-check-label"><input type="checkbox" name="interest" value="hiking">등산</label>
                        <label class="form-check-label"><input type="checkbox" name="interest" value="fishing">낚시</label><br>
                        <label class="form-check-label"><input type="checkbox" name="interest" value="cooking">요리</label>
                        <label class="form-check-label"><input type="checkbox" name="interest" value="game">게임</label>
                        <label class="form-check-label"><input type="checkbox" name="interest" value="movie">영화</label>
                        <label class="form-check-label"><input type="checkbox" name="interest" value="etc">기타</label>
                    </td>
                </tr>
            </table>

            <br><br>
            <div class="">
                <disabled id="enroll-btn" input type="submit" class="btn btn-primary" value="회원가입">
                <input type="reset" class="btn btn-primary" value="다시입력">
            </div>
        </form>
    </div>
    <script>
       
            // 중복확인 버튼 클릭 시 사용자가 입력한 아이디가 이미 존재하는지에 대한 결과를 알고싶다.
            // 만약 존재한다면 -> 사용불가 -> alert 메시지 출력 (이미 존재하는 id입니다.)
            // 만약 존재하지 않는다면 -> 사용가능 -> 정말 사용가능한지 yes -> 더이상 변경 x
            //                                                   no -> 다시 입력 

            // Ajax란? 
            // 웹페이지를 새로고침 없이 서버와 데이터를 요청하고 응답받는 기술이다.
            // ex: 게시판에서 댓글을 달았는데 페이지가 새로고침 되지 않고 댓글 목록이 수정된다. (to-do리스트)  --> ajax를 사용
            // 기존 웹 개발 방식
            // -> 버튼을 클릭할 때 마다 페이지 전체가 서버에 전송되며, 응답을 받기 전 잠시 화면 전체를 흰 화면에서 대기한다. 
            //    서버에서 새로운 HTML을 만들어서 리턴을 해준다면 이때 화면을 그려준다 -> 매번 화면이 깜빡인다. (클리커 현상?)
            

            /*
                js를 사용해서 Ajax를 구현할 때는 기본적으로 제공해주는 XMLHttpRequest 객체를 사용한다.
                기본적으로 XML의 데이터 형식을 사용했지만 최근에는 전부 JSON 형식을 사용한다.
                

                const xhr = new XMLHttpRequest();
                xhr.open("요청방식", "idDuplicateCheck.me?checkId=" + encodeURIComponent(("사용자가 입력한 아이디"), true));

                xhr.onreadystatechange = function(){
                    if(xhr.readyState === 4){  // 요청이 완료되었을 때
                        if(xhr.status === 200){  // 요청이 성공했을 때(http status code 200)
                            const result = JSON.parse(xhr.responseText); // 문자열로 응답 (json 형식)
                            if(result.result === "생각했던 결과과"){
                                // 성공 시 실행할 코드  
                            } else {
                                // 실패 시 실행할 코드
                            }
                        }
                    }
                }
            */

           

            // ajax란 jQuery에서 Ajax 기능을 쉽게 사용할 수 있도록 만든 함수이다.
            /*
            $.ajax({
                url : "요청을 보낼 주소",
                type : "요청 방식",
                data : {},
                success : function(){
                    성공 시 실행 코드
                },
                error : function(){
                    실패 시 실행 코드
                }
            })
            */
        function idDuplicateCheck(){ 

            const idInput = document.querySelector("#enroll-form input[name=userId]").value;
            $.ajax({
                url : "idDuplicateCheck.me",
                type : "get",
                data : {checkId : idInput},
                success : function(result){
                    if(result === "NNNNN"){
                        alert("이미 존재하는 아이디입니다.");
                        idInput.focus();
                    } else {
                        alert("사용 가능한 아이디입니다. 사용하시겠습니까?");
                        idInput.setAttribute("readonly", true);
                    }
                },
                error : function(err){
                    console.log("아이디 체크 요청 실패");
                }
            })
        }
    </script>
</body>
</html>