<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
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
	<%-- a가 보낸 데이터를 B에서 먹고  버린 후 c로 가라는 응답을 함 
	 	이때 이 때 기존 데이터는 사라진채로 다시 c에게 요청되어 c의 데이터는 모두 NULL이 됨  
	 --%>
	<%
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
	%>
	<h1>이름 : <%=name %></h1>
	<h1>나이 : <%=age %></h1>
</body>
</html>