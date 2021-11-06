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
<%    
	//다시 시작할때 비워있기 
	session.invalidate();

%>



<form action="quiz07_a.jsp">
	<label for="writer">설문작성자</label><br>
	<input type="text" name="writer" id="writer">
	<br><br>
	<h2>1. 좋아하는 연예인은 누구인가요?</h2>
	<input type="text" name="talent" >
	<button>다음</button>
</form>
	
	
</body>
</html>