<%@page import="java.net.URLDecoder"%>
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
	<%
		/* 
			쿠키 변경하기
			1. 모든 쿠키를 읽는다.
			2. 변경할 쿠키와 동일한 이름의 쿠키를 만든다.
			4. 동일한 이름의 쿠키로 덮어쓰기 한다.
		*/	
		// agree 쿠키 값을 no로 수정한다. 
		// agree 쿠기 값의 유효 시간을 10분으로 수정한다. 
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies){
			if( cookie.getName().equals("agree")){
				Cookie ck = new Cookie("agree","no");
				ck.setMaxAge(10*60);
				response.addCookie(ck);
				break;
			}
		}
		// 새 쿠키 오브젝트를 생성하지 않아도 set으로 설정할수도있다.
		for(Cookie cookie : cookies){
			if( cookie.getName().equals("address")){
				cookie.setValue("인천");
				cookie.setMaxAge(10*60);
				response.addCookie(cookie);
			}	
		}			
	%>
</body>
</html>