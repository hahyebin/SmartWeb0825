<%@page import="ex09_session.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%
	
	// 로그아웃 : session의 초기화 
	session.invalidate();

	// 로그인 화면으로 이동 
	response.sendRedirect("02_login_logoutA.jsp");
	
	
	
	
%>