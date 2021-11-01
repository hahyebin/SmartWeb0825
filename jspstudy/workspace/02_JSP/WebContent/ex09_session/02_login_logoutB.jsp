<%@page import="ex09_session.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%
	request.setCharacterEncoding("utf-8");
	
	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");
	
	// DB로 보낼 Bean 생성 
	Member member = new Member();
	member.setUserId(userId);
	member.setUserPw(userPw);
	
	// DB에 admin/1234 회원이 있다고 가정 
	// UserName는 DB에서 가져온 회원으로 가정
	Member loginUser = null;
	if(member.getUserId().equals("admin")){
		if(member.getUserPw().equals("1234")){
			loginUser = new Member();
			loginUser.setUserId("admin");
			loginUser.setUserPw("1234");
			loginUser.setUserName("하혜빈");
		}
	}
	
	
	// 로그인 성공/실패판단 
	// 로그인 성공하면 session에 회원 정보 저장해 둠 
	if( loginUser != null ){
		session.setAttribute("loginUser", loginUser);  // loginUser 객체에는 id pw name  필드가 들어있음 
	}
	
	response.sendRedirect("02_login_logoutA.jsp");
	
	
	
	
	
%>