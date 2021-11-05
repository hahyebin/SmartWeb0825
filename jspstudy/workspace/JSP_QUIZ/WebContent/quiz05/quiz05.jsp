<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<style>
	label {
		display:inline-block;

	}
</style>
</head>
<body>

	<form action="quiz05_a.jsp">
	<div>
		<label for="userId">아이디&nbsp;&nbsp;&nbsp;</label>
		<input type="text" name="userId" id="userId">
	</div>
	<div>
		<label for="userPw">비밀번호</label>
		<input type="text" name="userPw" id="userPw">
	</div>
	<div>
		<label for="userName">이름&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
		<input type="text" name="userName" id="userName">
	</div>
		<button>회원가입</button>
	</form>
	

</body>
</html>