<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>제품목록</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>
	
	<a href="/AJAX/insertForm.do">제품 등록하러 가기</a>
	<table border="1">
		<thead>
			<tr>
				<td>제품번호</td>
				<td>제품명</td>
				<td>제품가격</td>
				<td>제품등록</td>
			</tr>
			
		</thead>
		<tbody>
			<c:if test="${empty list }">
				<tr>
					<td colspan="4">등록된 제품이 없습니다.</td>
				</tr>
			</c:if>
			
			<c:forEach var="list" items="${list}">
				<tr>
					<td>${list.pno}</td>
					<td>${list.name}</td>
					<td>${list.price}</td>
					<td>${list.made}</td>
				</tr>
			</c:forEach>
		
		</tbody>
	
	</table>
	
	
</body>
</html>