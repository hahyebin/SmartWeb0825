<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Welcome</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			
			$("#id").on('keyup',function(){
				$.ajax({
					url : 'idCheck.member',
					type : 'post',
					data : 'id=' + $('#id').val(),
					dataType: 'json',               // 받아올 데이터 타입
					success : function(resData){
						 if( resData.result == true ){
							 $('#id_check').text('사용 가능한 아이디');
						 }else {
							 $('#id_check').text('이미 사용중인 아이디');
						 }
					},
					error : function(xhr, ajaxOptions, thrownError) {
				       alert(xhr.responseText);
				//		console.log(xhr.status);
				  //      console.log(thrownError);
					}
					
				}) // ajax
			}); // id
			
			$('#f').on('submit',function(event){
			if( $("#pw").val() != $("#pwCheck").val()){
					alert("비밀번호가 일치하지 않습니다.");
				    event.preventDefault();
					return false;
				} return true;
			}) // form
		}) // load
	</script>
</head>
<body>
	
	<div class="container">
	<h3>회원가입</h3>
		<form action="join.member"  id="f" method="post">
			<input type="text" name="id" id="id" placeholder="아이디">
			<span id="id_check" ></span><br>
			<input type="password" name="pw" id="pw" placeholder="비밀번호"><br>
			<input type="password" name="pwCheck" id="pwCheck" placeholder="비밀번호 재확인"><br>
			<input type="text" name="name" id="name" placeholder="이름"><br>
			<input type="text" name="email" id="email" placeholder="이메일"><br>
			<button>가입하기</button>
			<input type="reset" value="입력취소">
			<input type="button" value="가입취소" onclick="location.href='index.jsp'">
		</form>
	</div>
</body>
</html>