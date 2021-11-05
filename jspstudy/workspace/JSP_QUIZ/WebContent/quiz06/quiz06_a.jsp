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
<%
		request.setCharacterEncoding("UTF-8");

		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
	
		Cookie cookie1 = new Cookie("userId", userId);
		cookie1.setMaxAge(60*60);
		response.addCookie(cookie1);
		Cookie cookie2 = new Cookie("userPw", userPw);
		cookie2.setMaxAge(60*60);
		response.addCookie(cookie2);
		Cookie cookie3 = new Cookie("userName", userName);
		cookie3.setMaxAge(60*60);
		response.addCookie(cookie3);
%>

	<form action="quiz06_b.jsp">
	<h3>연락처를 입력하세요</h3>
	<div>
		<label for="userAddr">주소&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
		<input type="text" name="userAddr" id="userAddr">
	</div>
	<div>
		<label for="userTel">전화번호</label>
		<input type="text" name="userTel" id="userTel">
	</div>
	<div>
		<label for="userEmail">이메일&nbsp;&nbsp;&nbsp;</label>
		<input type="text" name="userEmail" id="userEmail">
	</div>
	
	<br><br><br>
		<button>확인</button>
	</form>
	

</body>
</html>