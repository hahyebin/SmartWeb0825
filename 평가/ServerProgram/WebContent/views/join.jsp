<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		width: 700px;
		margin: 50px auto;	
	}
	h2 { text-align:center; }
	form{
		width: 500px;
		margin: 10px auto;	
		text-align:center;
	}
	label {
		display :inline-block;
		width: 100px;
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
<h2>회원 가입 폼</h2>
	<form action="/ServerProgram/join.do" method="post">
		<label for="id">아이디</label>
		<input type="text" name="id"><br>
		<label for="name">이름</label>
		<input type="text" name="name"><br>
	
	<button>회원가입</button>
	<input type="button" value="돌아가기" id="back" onclick="location.href='/ServerProgram/loginPage.do'">
	</form>
</div>	
</body>
</html>