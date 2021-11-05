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
	<%
	     request.setCharacterEncoding("utf-8");
	
	%>
	<ul>
		<li>이름: ${param.userName}</li>
		<li>나이: ${param.userAge}</li>
		<li>성별: ${param.userGender}</li>
		<li>취미:
		    
		    
		    <!--  배열의 값 꺼낼 수 있는 EL -> paramValues.name -->
			 <c:forEach var="hobby" items="${paramValues.hobby}">
			 	${hobby}&nbsp;
			 </c:forEach>
		 </li>
		<li>주소: ${param.addr}</li>
		<li>좋아하는 음식: 
		   <c:forEach var="food" items="${paramValues.food}" >
		   		${food}&nbsp;
		   </c:forEach>
		   
		</li>

	
	</ul>
	
	

</body>
</html>