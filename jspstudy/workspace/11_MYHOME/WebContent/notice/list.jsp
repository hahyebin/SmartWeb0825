<%@page import="dto.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Welcome</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>


</head>
<body>

	
	<c:if test="${loginUser.id == 'admin'}">
		<div>
			<a href="insertForm.notice">공지사항 작성하기</a>
		</div>
	</c:if>
	<table border="1">
		<thead>
			<tr>
				<td>순번</td>
				<td>제목</td>
				<td>작성자</td>
				<td>조회수</td>   <!--  세션에 노티스 객체 있으면 한 번 열었기 때문에 조회수 변화 없도록 만들고 , 세션이 null이면 조회수 1이 증가되어야함  -->
				<td>작성일</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr><td colspan="5">게시물이 없습니다.</td></tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach var="notice" items="${list}">
					<tr>
						<td>${notice.nNo}</td>
						<td><a href="view.notice?nNo=${notice.nNo}">${notice.title}</a></td>
						<td>${notice.writer}</td>
						<td>${notice.hit}</td>
						<td>${notice.nDate}</td>
					</tr>
				</c:forEach>
			</c:if>
			
		
		
		</tbody>
	</table>
</body>
</html>