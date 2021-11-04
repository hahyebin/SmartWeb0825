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
	<% request.setCharacterEncoding("utf-8"); 
	  
	%>
	
	<p>총합 : ${param.kor  + param.eng + param.mat} </p>
	<c:set var="avg" value=" ${ (param.kor  + param.eng + param.mat) div 3 }"></c:set>
	<p>평균 : ${avg} </p>
	<c:choose>
		<c:when test="${avg-90>=0 }">학점 : A</c:when>
		<c:when test="${avg-80>=0}">학점 : B</c:when>
		<c:when test="${avg-70>=0}">학점 : C</c:when>
		<c:when test="${avg-60>=0}">학점 : D</c:when>
	    <c:otherwise>학점 : F</c:otherwise>
	</c:choose>

</body>
</html>