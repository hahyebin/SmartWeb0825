<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${param.writer }님의 선호도 조사 결과</h3>
	<ul>
		<li>좋아하는 연예인 : ${param.talent }</li>
		<li>좋아하는 운동선수 : ${param.sport}</li>
	</ul>
	<button id="reset_btn">처음부터 다시하기</button>
	
	<script>
	   $("#reset_btn").on('click',function(){
		   location.href="quiz03.jsp";
	   })
	
	</script>
	
</body>
</html>