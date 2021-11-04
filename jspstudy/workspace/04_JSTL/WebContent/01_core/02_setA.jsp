<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%-- age는 문자열로 저장된다. --%>
<%-- <% request.setAttribute("age", "26"); 와 같음  %> --%>	
	
	<c:set var="age" value="26" scope="request" />
	<jsp:forward page="02_setB.jsp"></jsp:forward>
</body>
</html>