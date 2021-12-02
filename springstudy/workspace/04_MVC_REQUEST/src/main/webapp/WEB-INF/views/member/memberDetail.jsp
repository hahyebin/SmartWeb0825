<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		
	<h2>회원번호 : ${member.idx} </h2>
	<h2>회원아이디 : ${member.id}  </h2>
	<h2>회원이름 : ${member.name} </h2>
	
	<a href="/ex04">index로 돌아가기</a> <!-- @GetMapping("/") 매핑과 연결됨 -->  <!-- 홈으로 가기위해서는 contextPath로 설정하기  -->
	<br>
	<a href="/ex04/index.do">index로 돌아가기</a>   <!-- @GetMappiong("index.do") 매핑과 연결됨   -->
</body>
</html>