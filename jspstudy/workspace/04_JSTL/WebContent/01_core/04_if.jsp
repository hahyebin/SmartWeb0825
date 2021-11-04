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

 	<c:set var="a" value="20" />
 	<c:set var="b" value="16" />
 	
 	<%-- 1. 큰 수 출력하기 --%>
	<c:if test="${a-b>0}" >a가 큰수</c:if>
	<c:if test="${a-b<0}" >b가 큰수</c:if>
	<c:if test="${a-b==0}" >a와 b는 같음 </c:if>
	 <br>
	<%-- 2. 10에 가까운 출력하기 --%>
	<c:if test="${a-10 > 0}">
		<c:set var="diff1" value="${a-10}" />
	</c:if>
	<c:if test="${a-10 < 0}">
		<c:set var="diff1" value="${10-a}" />
	</c:if>
	<c:if test="${b-10 > 0}">
		<c:set var="diff2" value="${b-10}" />
	</c:if>
	<c:if test="${b-10 < 0}">
		<c:set var="diff2" value="${10-b}" />
	</c:if>
	<c:if test="${diff1-diff2 > 0}">10과 가까운 수는 b=${b}이다.</c:if><br>
	<c:if test="${diff1-diff2 < 0}">10과 가까운 수는 a=${a}이다.</c:if><br>
	<c:if test="${diff1-diff2 == 0}">${a}와 ${b}는 10과 같은 차이이다.</c:if>
</body>
</html>