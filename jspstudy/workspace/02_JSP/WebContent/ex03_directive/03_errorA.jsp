<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--  현재 페이지에서 에러가 나면 03_errorB.jsp로 이동하라. -->
<%@ page errorPage="03_errorB.jsp" %>    

<% 
	//Integer.parseInt("안녕");
	String name= request.getParameter("name");
	if(name.equals("홍길동")){  //equals() 호출시 값이 없으므로 NullPonterException 강제발생;
		
	}
%>