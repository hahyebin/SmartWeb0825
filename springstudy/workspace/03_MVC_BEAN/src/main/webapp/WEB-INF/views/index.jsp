<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  
  <h1>회원아이디   : ${member1.id}</h1>
  <h1>비밀번호 : ${member1.pw}</h1>

  <a href="memberView.do">회원정보보기</a>
  <br>
  <a href="boardView.do">게시글보기</a>
  
</body>
</html>