<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>


    <h2>공지사항 목록 화면</h2>	
	
	<a href="/ex10/notice/noticePage">새 공지사항 작성</a>
	<hr>
	
	
	<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>작성일</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr><td colspan="3">공지사항이 없습니다.</td></tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach items="${list}" var="notice">
					<tr>
						<td>${notice.no}</td>
						<td><a href="/ex10/notice/selectNoticeByNo?no=${notice.no}">${notice.title}</a></td>
						<td>${notice.created}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</body>
</html>