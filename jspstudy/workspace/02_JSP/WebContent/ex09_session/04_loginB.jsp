<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="ex09_session.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

		<%
			request.setCharacterEncoding("utf-8");
			String userId = request.getParameter("userId");
			String userPw = request.getParameter("userPw");
	
			
			Member m1 = new Member();
			m1.setUserId(userId);
			m1.setUserPw(userPw);
			
			// 자바 연습용 DB - > Map
			// Map <Key, value>
			Map<String, String> db = new HashMap<>();
			db.put("admin", "1234");
			db.put("superman", "1234");
			db.put("superwoman", "1234");
	
			
		    if(db.containsKey(m1.getUserId())){ // db에 userId 포함 여부 점검 
			    if( db.get(m1.getUserId()).equals(m1.getUserPw())){  // 비밀번호 점검 
			    	session.setAttribute("loginUser", m1);	
		    	}
		  	 }
			if( session.getAttribute("loginUser") == null){
				response.sendRedirect("04_loginA.jsp");
			} else {
				response.sendRedirect("04_cartA.jsp");
			}
			
			
			
		    /*
			Member userCart = null;
			if ( m1.getUserId().equals("admin") && m1.getUserPw().equals("1234")){
				
				userCart = new Member();
				userCart.setUserId("admin");
				userCart.setUserPw("1234");
				
				session.setAttribute("userId",userId);
				
				response.sendRedirect("04_cartA.jsp");
			} else {
				response.sendRedirect("04_loginA.jsp");
			}
			*/
		%>


