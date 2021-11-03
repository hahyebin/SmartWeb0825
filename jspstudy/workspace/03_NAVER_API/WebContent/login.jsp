<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<h1>로그인</h1>
	<form action="/naver.api/ValidationServlet" method="post">
		<div>
			<input type="text" name="id" placeholder="아이디">
		</div>
		<div>
			<input type="password" name="pw" placeholder="비밀번호">
		</div>
		<br><br>
		 <!-- request의 set속성저장을 불러올때 EL사용 가능 -->
		 <img src= "${folderName}/${filename}" alt="캡쳐이미지">	
		 <input type="button" value="새로고침" onclick="location.href= '/naver.api/LoginServlet'">
		 <br>
		 <input type="text" name="value" placeholder="입력값" >
		 <input type="hidden" name="key" value="${key}">
		 <div>
			<button>로그인</button>
		</div>
	</form>
	
	
	
	
	
	
	
</body>
</html>