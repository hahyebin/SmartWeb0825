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
	<h2>성적처리결과</h2>
	<ul>
		<li> 국어 : ${param.kor} </li>
		<li> 영어 : ${param.eng} </li>
		<li> 수학 : ${param.mat} </li>
		
		<!-- 평균구하기 -->
		<c:set var="avg" value="${ (param.kor +param.eng + param.mat) div 3}" />
		<li> 평균 : ${avg} </li>
		
		<li> 학점 :
		<c:choose>
			<c:when test="${avg-90>=0}">A학점</c:when>
			<c:when test="${avg-80>=0}">B학점</c:when>
			<c:when test="${avg-70>=0}">C학점</c:when>
			<c:when test="${avg-60>=0}">D학점</c:when>
			<c:otherwise>F학점</c:otherwise>
		</c:choose>
		</li>
		
		<li> 합격여부 : 
			<c:if test="${avg-60>=0}">합격</c:if>
			<c:if test="${avg-60<0}">불합격</c:if>
		</li>	
   </ul>


</body>
</html>