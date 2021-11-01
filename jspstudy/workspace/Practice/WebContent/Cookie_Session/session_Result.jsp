<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie[ ] cookies = request.getCookies();
			if( cookies != null && cookies.length != 0){
				for(Cookie cookie : cookies){
					if( cookie.getName().equals("id")){
						session.setAttribute("id", cookie.getValue());
					}
					if(cookie.getName().equals("name")){
						session.setAttribute("name", cookie.getValue());
					}
				}
		
			}
	%>
	${name}님 반갑습니다. 
	&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="session_Logout.jsp">로그아웃</a>



</body>
</html>