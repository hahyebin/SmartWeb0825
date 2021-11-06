<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	label {
		display:inline-block;
		margin-right:50px;
	}
</style>

</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
	%>

	<form action="Tquiz05C.jsp" method="post">
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