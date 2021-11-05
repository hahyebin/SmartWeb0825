<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<!-- JSTL 배열.. ${paramValues.name}-->
		<c:forEach var="singer" items="${paramValues.singers}" varStatus="k">
   		<p>좋아하는 가수${k.count} : ${singer }</p>
     	</c:forEach>
     
	
</body>
</html>