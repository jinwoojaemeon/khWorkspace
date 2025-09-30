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
    <h3>1. 산술연산</h3>
    기존 : 10 + 3 = <%= (int)request.getAttribute("big")%> + <%= (int)request.getAttribute("small")%> <br> <br>

    EL 방식 <br>
    10 + 3 = ${big + small} <br>
    10 - 3 = ${big - small} <br>
    10 * 3 = ${big * small} <br>
    10 / 3 = ${big / small} 또는 ${big div small}<br>
    10 % 3 = ${big % small} <br>

    <h3>2. 대소비교</h3>
    10 &gt; 3 = ${big > small} 또는 ${big gt small} <br>
    10 &lt; 3 = ${big > small} 또는 ${big lt small} <br>
    10 &gt;= 3 =  ${big >= small} 또는 ${big ge small} <br>
    10 &lt;= 3 =  ${big <= small} 또는 ${big le small} <br>

    <h3>3. 동등 비교</h3>
    <p>el에서는 == 비교는 자바에서의 equals()와 같은 동작</p>
    strOne과 strTwo가 일치하는가? ${strOne == strTwo} 또는 ${strOne eq strTwo} <br>
    strOne과 strTwo가 일치하지 않는가? ${strOne != strTwo} 또는 ${strOne ne strTwo} <br>

    <%-- el 구문 안에서 문자열 리터럴 값은 '', ""를 구분하지 않는다 (둘 다 문자열로 구분하는 것 : javaScript와 동일)--%>
    strThree와 "hello"와 일치하는가? ${strThree == "hello"} 또는 ${strThree eq 'hello'}

    <h3>4. 객체가 null인지 아닌지, list가 비어있는지 확인</h3>
    personOne이 null인가? ${ empty personOne} <br>
    personOne이 null인가? ${ personOne == null } 또는 ${personOne eq null} <br>
    personTwo이 null인가? ${ personOne == null } 또는 ${personOne eq null}<br>
    personTwo이 null이 아닌가? ${ personTwo != null } 또는 ${personTwo ne null} 또는 ${ not empty personTwo} <br>

    arrOne은 비어있는가? ${ empty arrOne} <br>
    arrTwo은 비어있는가? ${ empty arrTwo} <br>

    <h4>5. 논리연산자</h4>
    true && true : ${true && true} 또는 ${true and true}<br>
    false || false : ${false || false} 또는 ${false or false}<br>

    big이 small보다 크고 arrOne은 비어있는가?  <br>
    ${big > small && empty arrOne} <br>
    ${big > small and empty arrOne}
</body>
</html>