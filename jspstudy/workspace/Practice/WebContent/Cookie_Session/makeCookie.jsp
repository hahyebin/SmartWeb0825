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
	   Cookie cookie = new Cookie("id","heaven");
		cookie.setMaxAge(60*2);
		response.addCookie(cookie);
	%>

	<p>
		쿠키 : 웹 브라우저의 정보를 웹 브라우저에 저장하므로, 이후에 서보로 전송되는 요청에는 쿠키가 가지고 있는 정보가 같이 포함되어서 전송된다.<br>
		이때 웹 서버는 웹 브라우저의 요청에 포함되어 있을 쿠키를 읽어서 새로운 웹 브라우저인지 이전에 요청했던 웹 브라우저인지 판단가능하다. <br>
		<br>
		JSP의 쿠키를 사용하기 위해서는 javax.servlet.http 패키지에 있는 Cookie 클래스의 객체를 생성해서 사용한다.<br>
		<br> 관련 메서드 :
		<br> Cookie cookie = new Cookie(String name, String value) --> cookie 객체 생성 
		<br> response.addCookie(name);  --> 생성한 쿠키 객체 응답자에게 돌려줌
		<br> cookie.setAttribute(newValue);  -> 새로운 값 
		<br> Cookie[] cookies = request.getCookies(); --> request객체에 실려온 쿠키를 읽을 때 get()를 이용하며, 쿠키는 전체를 주므로 배열로 받아온다.
		<br> cookie.serMaxAge(int expiry)   --> 유효시간 
	</p>
	<h2>쿠키를 생성하는 페이지</h2>
	<%= cookie.getName() %>쿠키가 생성되었습니다.
	<form action="useCookie.jsp">
		<input type="submit" value="생성된 쿠키확인">
	</form>
</body>
</html>