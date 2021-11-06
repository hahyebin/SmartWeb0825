<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

   
<%@page import="java.net.URLEncoder"%>

<%
		request.setCharacterEncoding("UTF-8");
	
		String userJob = request.getParameter("userJob");
		String userIsMarried = request.getParameter("userIsMarried");
		String userYear = request.getParameter("userYear");
		String userMonth = request.getParameter("userMonth");
		String userDay = request.getParameter("userDay");
		
		Cookie cookie7 = new Cookie("userJob", userJob);
		cookie7.setMaxAge(60*60);
		response.addCookie(cookie7);

		Cookie cookie8 = new Cookie("userIsMarried", userIsMarried);
		cookie8.setMaxAge(60*60);
		response.addCookie(cookie8);

		Cookie cookie9 = new Cookie("birthday", URLEncoder.encode(userYear + "년 " + userMonth + "월 "  + userDay + "일", "UTF-8") );
		cookie9.setMaxAge(60*60);
		response.addCookie(cookie9);
		
		// 결과는 다음 페이지에서 확인
		// 쿠키에 저장된 데이터는 페이지를 계속 이동해도 확인할 수 있으므로 그냥 redirect 해도 됨. -> redirect / forward특징과 연관 없음 
		response.sendRedirect("quiz06_d.jsp");
		
%>

