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
	
	<h1>getParameter() => 적용x</h1>
	<h3>주소 : <%=request.getParameter("addr") %></h3>
	
	<h1>(Object)request.getAttribute</h1>
	<h3>전화 : <%=(String)request.getAttribute("tel") %></h3>
	<h3>주소 : <%=(String)request.getAttribute("addr") %></h3>
	
	<h1>EL</h1>
	<h3>전화 : ${tel}</h3>
	<h3>주소 : ${addr}</h3>
	<h3>키 : ${height}cm</h3>
	<h3>몸무게 : ${weight}kg</h3>
	<c:set var="bmi" value="${weight div (height*height div 10000)}"  />
	<h3>체지량지수 : ${bmi} </h3>
	<h3>건강상태 : ${ bmi-25>=0 ? "관리필요" : "정상"} </h3>   <!-- EL에서 숫자와 문자열의 크기비교시 문자열이 자동으로 숫자 변환안되기 때문에 연산자를 이용하면 바로 숫자로 변경되기때문에  그냥비교보다 연산자를 이용해야한다. -->
	
		
</body>
</html>