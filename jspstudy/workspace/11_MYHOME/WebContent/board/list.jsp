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
	<style>
		table { 
			margin-top: 20px;
			border-collapse: collapse; 
		}
	</style>
</head>
<body>
	<div>
		<c:if test="${loginUser != null }">
			<a href="insertForm.board">새 이미지게시글 작성하기</a>
		</c:if>
	</div>
	
	<table border="1">
		<thead>
			<tr>
				<td width=50>순번</td>
				<td width=100>제목</td>
				<td width=80>작성자</td>
				<td width=100>작성일</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr>		
					<td colspan="4">저장된 이미지가 없습니다.</td>
			    </tr>
			</c:if>
			<c:if test="${not empty list}">
			 <c:forEach items="${list}"  var="board" varStatus="vs">
				<tr>
					<td>${startNum - vs.index}</td>
					<td><a href="view.board?bNo=${board.bNo}">${board.title}</a></td>
					<td>${board.writer}</td>
					<td>${board.created}</td>
				</tr>
				</c:forEach>
			</c:if>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4">${pageEntity}</td>			
			</tr>
		</tfoot>
	</table>
</body>
</html>