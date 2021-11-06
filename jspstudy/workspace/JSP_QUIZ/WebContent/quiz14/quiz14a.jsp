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


</head>
<body>
	<form action="quiz14b.jsp">
		<h2>일반 forEach 연습</h2>
		<p>아래의 크기를 입력하면 폰트 크기를 확인할 수 있습니다</p>
		최소크기&nbsp; <input type="text" name="minNum" size="3"><br>
		최대크기&nbsp; <input type="text" name="maxNum" size="3">
		<br><br><br>
		<h2>향상 forEach연습</h2>
		<label><input type="checkbox" name="foods" value="불고기">불고기</label>
		<label><input type="checkbox" name="foods" value="닭갈비">닭갈비</label>
		<label><input type="checkbox" name="foods" value="순대국">순대국</label>
		<label><input type="checkbox" name="foods" value="자장면">자장면</label>
		<label><input type="checkbox" name="foods" value="해장국">해장국</label>
		<br><br>
	<button>전송</button>
	<input type="reset" value="취소">
	</form>
	
</body>
</html>