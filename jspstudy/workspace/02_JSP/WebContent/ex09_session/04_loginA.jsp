<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
		<style>
		label{
			display : inline-block;
			width: 100px;
		}
		</style>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>

			<form action="04_loginB.jsp" method="post">
				<div>
					<label for="userId">아이디</label>
					<input type="text" name="userId" id="userId" placeholder="아이디">
				</div>
				<div>
					<label for="userPw">비밀번호</label>
					<input type="password" name="userPw" id="userPw" placeholder="비밀번호">
				</div>
				<div>
					<button>로그인</button>
				</div>
			</form>



</body>
</html>