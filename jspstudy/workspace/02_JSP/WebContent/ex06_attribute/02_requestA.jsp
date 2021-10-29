<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%
	/* request에 속성 저장하기 */
	request.setAttribute("name", "혜빈");
	request.setAttribute("age", 26);         // 1.  --> 이렇게 저장한 두 개의 속성을  request객체에 담음 
	
	/* request를 전달하는 forward */
	RequestDispatcher dispatcher = request.getRequestDispatcher("02_requestB.jsp");
	dispatcher.forward(request, response);  // 2. --> 1번에서 저장한 name,age를 B에게 넘김
%>