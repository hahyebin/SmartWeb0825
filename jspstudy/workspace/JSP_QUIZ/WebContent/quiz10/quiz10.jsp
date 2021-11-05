<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style>
	label{
		display:inline-block;
		width:50px;
	}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="quiz10_a.jsp">

	<div>
		 <label for="title">제목</label>
		<input type="text" name="title" id="title">
	</div>
	<div>
		 <label for="writer">작성자</label>
		<input type="text" name="writer" id="writer">
	</div>
	<div>
		<label for="content">내용</label>
		<input type="text" name="content" id="content">
	</div>
	<br>
		<button>작성하기</button>
	</form>
	

	
	
</body>
</html>