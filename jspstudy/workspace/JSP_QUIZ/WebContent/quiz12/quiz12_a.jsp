<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	
	
		
   	%>
	 ${param.num}의 절대값은 
	 <c:set var ="num" value="${param.num}"> </c:set>
	 <c:choose>
	 	<c:when test="${ num > 0 }"> ${param.num}이다.</c:when>
	 	<c:when test="${ num < 0 }"> ${param.num}
	 		
	 	</c:when>	
	 </c:choose>
</body>
</html>