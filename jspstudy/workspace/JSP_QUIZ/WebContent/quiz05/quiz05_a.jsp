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
		margin-right:50px;
	}
</style>
</head>
<body>
	<%
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
	
	%>

	<form action="quiz05_b.jsp">
	--------------------------------------------------------<br>
	1. 회원 정보는 웹 사이트 운영을 위해서만 사용됩니다.<br>
	2. 원치 않으면 정보 제공을 하지 않을 수 있습니다.<br>
	3. 다만 이 경우 정상적인 웹 사이트 이용이 제한됩니다.<br>
	--------------------------------------------------------<br>
	<input type="radio" name="check" value="agree" id="agree">
	<label for="agree">동의 함&nbsp;&nbsp;&nbsp;</label>
	<input type="radio" name="check" value="disagree" id="disagree">
	<input type="hidden" name="userId" value="<%=userId %>">
	<input type="hidden" name="userPw" value="<%=userPw %>">
	<input type="hidden" name="userName" value="<%=userName%>">
	<label for="disagree">동의 안 함</label><br>
	<button>회원가입</button>
	</form>



</body>
</html>