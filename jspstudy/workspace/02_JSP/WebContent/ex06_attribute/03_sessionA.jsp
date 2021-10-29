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

	<%-- session에 속성 저장하기 --%>
	<% 
		session.setAttribute("name", "하혜빈");
	// 페이지이동에서 데이터를 전달하지 않았지만 세션은 페이지가 변경해도 브라우저를 나가지 않는다면 날라가지 않기 때문에 다른 페이지에서 속성사용가능!@!!!!!
	%>
	<%-- 페이지 이동 (그냥 가는 태그. 데이터 보내지 않음) --%>
	<a href="03_sessionB.jsp">이동</a>
</body>
</html>