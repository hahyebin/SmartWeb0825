<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	
	Cookie[] cookies = request.getCookies();
	if( cookies != null && cookies.length != 0){
		for(Cookie cookie : cookies){
		%>
			쿠키이름 : <%= cookie.getName()%><br>
			쿠키 값: <%=cookie.getValue()%>
	<% 	}
	}
	
	%>
</body>
</html>