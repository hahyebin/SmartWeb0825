<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>
	<a href="/ServerProgram/loginPage.do">로그인 하러 가기</a>
	<hr>
	<h1>회원 목록</h1>
	
		<table border="1">
			<thead>
				<tr>
					<td>회원번호</td>
					<td>아이디</td>
					<td>이름</td>
					<td>등급</td>
					<td>포인트</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${list}">
					<tr>
						<td>${list.no}</td>
						<td>${list.id}</td>
						<td>${list.name}</td>
						<td>${list.grade}</td>
						<td>${list.point}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>