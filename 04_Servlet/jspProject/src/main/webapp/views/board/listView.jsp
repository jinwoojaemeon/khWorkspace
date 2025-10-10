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

        .empty-state {
            text-align: center;
            padding: 60px 20px;
            color: #999;
            font-size: 18px;
        }
    </style>
</head>
<body>
	<jsp:include page="/views/common/menubar.jsp" />

    <div class="board-container">
        <div class="board-card">
            <h2>일반게시판</h2>

            <div class="write-btn-area">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/enrollForm.bo">글쓰기</a>
            </div>

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
                                <td colspan="6" class="empty-state">
                                    게시글이 없습니다. 첫 게시글을 작성해보세요!
                                </td>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <c:forEach var="board" items="${list}">
                                <tr onclick="location.href='${pageContext.request.contextPath}/detail.bo?bno=${board.boardNo}'">
                                    <td>${board.boardNo}</td>
                                    <td>${board.categoryName}</td>
                                    <td>${board.boardTitle}</td>
                                    <td>${board.writerName}</td>
                                    <td>${board.count}</td>
                                    <td>${board.createDate}</td>
                                </tr>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>

            <!-- 페이지네이션 정보 표시 -->
            <div style="text-align: center; margin-bottom: 1rem; color: #666;">
                총 ${totalCount}개의 게시글 (${currentPage}/${totalPages} 페이지)
            </div>

            <!-- 페이지네이션 -->
            <div class="pagination">
                <!-- 이전 버튼 -->
                <c:choose>
                    <c:when test="${hasPrev == 1}">
                        <button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/list.bo?page=${startPage - 1}'">
                            &lt; 이전
                        </button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-secondary" disabled style="opacity: 0.5; cursor: not-allowed;">
                            &lt; 이전
                        </button>
                    </c:otherwise>
                </c:choose>
                
                <!-- 페이지 번호들 -->
                <c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
                    <c:choose>
                        <c:when test="${pageNum == currentPage}">
                            <button class="btn btn-primary" style="background-color: #007bff; border-color: #007bff;">
                                ${pageNum}
                            </button>
                        </c:when>
                        <c:otherwise>
                            <button class="btn btn-outline-primary" onclick="location.href='${pageContext.request.contextPath}/list.bo?page=${pageNum}'">
                                ${pageNum}
                            </button>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                
                <!-- 다음 버튼 -->
                <c:choose>
                    <c:when test="${hasNext == 1}">
                        <button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/list.bo?page=${endPage + 1}'">
                            다음 &gt;
                        </button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-secondary" disabled style="opacity: 0.5; cursor: not-allowed;">
                            다음 &gt;
                        </button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</body>
</html>