<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>일반게시판</title>

    <style>

        .board-container {
            max-width: 1000px;
            margin: 50px auto;
            padding: 2rem;
        }

        .board-card {
            background: white;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
            padding: 2rem;
        }

        .board-card h2 {
            text-align: center;
            color: #333;
            margin-bottom: 2rem;
            padding-bottom: 1rem;
            border-bottom: 2px solid #4b89fc;
        }

        .write-btn-area {
            text-align: right;
            margin-bottom: 1rem;
        }

        .board-table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 2rem;
        }

        .board-table thead {
            background: #4b89fc;
            color: white;
        }

        .board-table th,
        .board-table td {
            padding: 1rem;
            text-align: center;
            border-bottom: 1px solid #e0e0e0;
        }

        .board-table th {
            font-weight: 500;
        }

        .board-table tbody tr {
            transition: all 0.2s ease;
        }

        .board-table tbody tr:hover {
            background-color: #f5f8ff;
            cursor: pointer;
            transform: translateY(-2px);
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .pagination {
            display: flex;
            justify-content: center;
            gap: 0.5rem;
            margin-top: 2rem;
        }

        .pagination .btn {
            min-width: 40px;
        }
    </style>
</head>
<body>
	<jsp:include page="/views/common/menubar.jsp" />

    <div class="board-container">
        <div class="board-card">
            <h2>일반게시판</h2>

			<c:if test="${not empty loginMember}">
	            <div class="write-btn-area">
	                <a class="btn btn-primary" href="${pageContext.request.contextPath}/enrollForm.bo">글쓰기</a>
	            </div>
            </c:if>

            <table class="board-table">
                <thead>
                    <tr>
                        <th width="70">글번호</th>
                        <th width="100">카테고리</th>
                        <th width="300">제목</th>
                        <th width="100">작성자</th>
                        <th width="70">조회수</th>
                        <th width="100">작성일</th>
                    </tr>
                </thead>
                <tbody>
                 	<c:choose>
                 		<c:when test="${empty list}">
                 			<tr>
                 				<td colspan="6" style="text-align: center; padding: 50px;">
                 					등록된 게시글이 없습니다.
                 				</td>
                 			</tr>
                 		</c:when>
                 		<c:otherwise>
                 			<c:forEach var="b" items="${list}">
		                 	 <tr onclick="location.href='${pageContext.request.contextPath}/detail.bo?bno=${b.boardNo}'">
		                        <td>${b.boardNo}</td>
		                        <td>${b.categoryName}</td>
		                        <td>${b.boardTitle}</td>
		                        <td>${b.memberId}</td>
		                        <td>${b.count}</td>
		                        <td>${b.createDate}</td>
	                    	</tr>
	                 		</c:forEach>
                 		</c:otherwise>
                 	</c:choose>
                </tbody>
            </table>

            <!-- 페이지네이션은 게시글이 있을 때만 표시 -->
            <c:if test="${listCount > 0}">
                <div class="pagination">
                    <!-- 이전 버튼 -->
                    <c:if test="${startPage > 1}">
                        <a class="btn btn-primary" href="${pageContext.request.contextPath}/list.bo?currentPage=${startPage - 1}">
                            &lt; 이전
                        </a>
                    </c:if>
                    
                    <!-- 페이지 번호들 -->
                    <c:forEach var="p" begin="${startPage}" end="${endPage}">
                        <c:choose>
                            <c:when test="${p == currentPage}">
                                <button class="btn btn-primary" disabled>${p}</button>
                            </c:when>
                            <c:otherwise>
                                <a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/list.bo?currentPage=${p}">${p}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    
                    <!-- 다음 버튼 -->
                    <c:if test="${endPage < maxPage}">
                        <a class="btn btn-primary" href="${pageContext.request.contextPath}/list.bo?currentPage=${endPage + 1}">
                            다음 &gt;
                        </a>
                    </c:if>
                </div>
            </c:if>
        </div>
    </div>
</body>
</html>
