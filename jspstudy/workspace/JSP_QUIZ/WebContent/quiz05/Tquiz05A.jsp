<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	label{
		display : inline-block;
		width:100px;
	}

</style>
</head>
<body>
	<form action="Tquiz05B.jsp" method="post">
	<div>
		<label for="userId">아이디</label>
		<input type="text" name="userId" id="userId">
	</div>
	<div>
		<label for="userPw">비밀번호</label>
		<input type="text" name="userPw" id="userPw">
	</div>
	<div>
		<label for="userName">이름</label>
		<input type="text" name="userName" id="userName">
	</div>
		<button>회원가입</button>
	</form>
	
	
</body>
</html>