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
	<style>
		label {
			display:inline-block;
			width: 50px;
		}
		textarea {
			margin-top: 5px;
		}
	</style>
	<script>
		$(document).ready(function(){
			$('#f').on('submit',function(event){
				if($('#content').val() == '${param.content}'){
					alert('변경한 내용이 없습니다.');
					event.preventDefault();
					return false;
				}
				return true;
			});
		});
	</script>
</head>
<body>
	<div>
		<form id="f" action="update.free" method="post">
			작성자 : ${loginUser.id}<br>
			<input type="hidden" name="fNo" value="${param.fNo}">
			<textarea rows="5" cols="30" name="content" placeholder="내용을 입력하세요" id="content">${param.content}</textarea><br><br>
			<button>수정하기</button>
			<input type="reset" value="입력초기화">
			<input type="button" value="목록 이동" onclick="location.href='list.free'">
		</form>
	</div>
</body>
</html>