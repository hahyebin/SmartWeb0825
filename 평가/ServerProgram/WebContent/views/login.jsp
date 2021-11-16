<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<style>
	*{
		margin: 0;
		padding: 0;
		box-sizing: border-box;
	}	
	#container {
		width: 300px;
		margin: 50px auto;	
	}
	h4 { text-align:center; }
	form{
		width: 200px;
		margin: 10px auto;	
		text-align:center;
	}
	button {
		display :inline-block;
		margin-top: 8px;
		margin-right:5px;
	}
</style>


</head>
<body>
	<div id="container">
		<h4>회원관리 프로그램</h4>

		<form action="/ServerProgram/login.do" method="post">
			<input type="text" name="id" placeholder="아이디" id="id"><br>
			<input type="text" name="name" placeholder="이름" id="name"><br>
			<button>로그인</button>		
			<a href="/ServerProgram/views/join.jsp">회원가입</a>
		</form>
	
	
	</div>
</body>
</html>