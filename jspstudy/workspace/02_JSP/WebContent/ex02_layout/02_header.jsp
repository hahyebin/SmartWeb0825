<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");    // request 나 response 는 jsp 에는 내장객체가 포함되어 있어 그냥 부른다. 
	String title = request.getParameter("title");
	if( title == null || title.isEmpty()){
		title = " 환영합니다";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=title%></title>
</head>
<body>

	<header>
		<h1>로고</h1>
		<nav>
			<ul>
				<li>메뉴1</li>
				<li>메뉴2</li>
				<li>메뉴3</li>
				<li>메뉴4</li>
				<li>메뉴5</li>
			</ul>
		</nav>
	</header>
	
	<section>