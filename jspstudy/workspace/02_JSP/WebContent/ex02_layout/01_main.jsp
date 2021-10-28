<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
	1. include 지시어
		1) 현재 페이지에 다른 페이지를 포함할 때 사용한다.
		2) 정적 페이지(변화가 없는 페이지)를 포함할 때 사용한다.  -> 헤더 부분이 바껴보이지 않아도 <title>이 바뀌면 정적이지 않기 때문에 include지시어 사용안됨
		3) 주로 footer 영역을 포함할 때 사용한다.
		4) <%@ include file="포함할 파일명" %>
		
	2. 
 --%>
 
 <%@ include file="01_header.jsp" %>

		<div>구역1</div>
		<div>구역2</div>
		<div>구역3</div>	
 
 <%@ include file="01_footer.jsp" %>
 