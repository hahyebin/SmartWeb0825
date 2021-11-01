<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ch12_Cookie_Session.Member" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String keepLogin = request.getParameter("keep_login");
	
		Member m1 = new Member();
		m1.setId(id);
		m1.setPw(pw);
		
		Member loginUser = null;
		
		if (m1.getId().equals("heaven") && m1.getPw().equals("1234")){
			
			loginUser = new Member();
			loginUser.setId("heaven");
			loginUser.setPw("1234");
			loginUser.setName("혜빈");
			
			// 자동로그인 체크했으면 쿠키 만들기 
			if( keepLogin != null){
				Cookie ck1 = new Cookie("id",loginUser.getId());
				ck1.setMaxAge(14*60*60);
				response.addCookie(ck1);
				Cookie ck2 = new Cookie("name",loginUser.getName());
				ck2.setMaxAge(14*60*60);
				response.addCookie(ck2);
		} else {   // 자동로그인 안하면 그냥 세션에만 저장해서 브라우저 끄면 저장 안됨 
			session.setAttribute("id", loginUser.getId());
			session.setAttribute("name", loginUser.getName());
		}
	}
		response.sendRedirect("session_Result.jsp");
	
		
	%>
</body>
</html>