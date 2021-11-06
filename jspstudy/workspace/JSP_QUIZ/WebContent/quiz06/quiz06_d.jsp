<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@page import="java.io.*"%>
<%@page import="java.net.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
	  public String getCookieValue(Cookie[] cookies, String cookieName){
		String result = null;
		try{
			if( cookies != null || cookies.length!=0){
				for(Cookie cookie : cookies){
					if(cookie.getName().equals(cookieName)){
						result = URLDecoder.decode(cookie.getValue(),"UTF-8"); //생년월일 인코딩설정때문에 디코딩필수 다른건 cookie.getValue()로 출력가능 
					}
				}
			}
		} catch(Exception e) {
			
		}
		return result;
	}
	%>
	<%Cookie[] cookies = request.getCookies();%> 


	<h2>가입 내용</h2>
	<ul>
		<li>아이디: <%=getCookieValue(cookies, "userId")%></li>
		<li>비밀번호: <%=getCookieValue(cookies, "userPw")%></li>
		<li>성명: <%=getCookieValue(cookies, "userName")%></li>
		<li>주소: <%=getCookieValue(cookies, "userAddr")%></li>
		<li>연락처: <%=getCookieValue(cookies, "userTel")%></li>
		<li>이메일: <%=getCookieValue(cookies, "userEmail")%></li>
		<li>생년월일: <%=getCookieValue(cookies, "birthday")%></li>
		<li>결혼여부: <%=getCookieValue(cookies, "userIsMarried")%></li>
		<li>직업: <%=getCookieValue(cookies, "userJob")%></li>
	</ul>
	<p>상기조건으로 가입되었습니다. 감사합니다.</p>
	


</body>
</html>