<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

</head>
<body>


	<%	request.setCharacterEncoding("utf-8");	%>
	<h2>일반 forEach 연습</h2>
	<div>
	<c:forEach var="num" begin="${param.minNum}" end="${param.maxNum}" step="1">
		<p style="font-size:${num}px">폰트사이즈 : ${num} </p>
		<!--  font tag  존재함 .. -->
		<font size="${num}">폰트 사이즈 ${num}<br></font>
	</c:forEach>
	</div>

	
	<h2>향상 forEach 연습</h2>
	<ul>
	<c:forEach var="food" items="${paramValues.foods}" varStatus="v" >
		<li>${v.count}번째 음식: ${food}</li>
	</c:forEach>
	</ul>
</body>
</html>