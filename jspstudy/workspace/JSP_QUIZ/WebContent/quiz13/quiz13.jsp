<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="quiz13_a.jsp">
	<label for="kor">국어 <input type="text" name="kor" class="reset"></label><br>
	<label for="eng">영어 <input type="text" name="eng" class="reset"></label><br>
	<label for="mat">수학 <input type="text" name="mat" class="reset"></label><br><br>
	
	<button>결과 보기</button>&nbsp;
	<!-- input 타입이 reset인 경우 존재함... -->
	<input id="reset_btn" type="button" value="다시 작성">
</form>	
<script>
	$("#reset").on("click",function(){
		$(".reset").val('');
	})

</script>

</body>
</html>