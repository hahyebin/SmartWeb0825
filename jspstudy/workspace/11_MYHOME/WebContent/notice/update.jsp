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
			$("#f").on("submit",function(event){
				if($("#title").val() == '${notice.title}' && $("#content").val() == '${notice.content}'){
					alert('수정된 내용이 없습니다.');
					event.preventDefault();
					return false;
				}
				return true;
			}); // form
		})	
	</script>
</head>
<body>
	<div>
		<form action="update.notice" method="post" id="f">
		<!--  세션 저장된 notice 갖고오기 -->
			작성자 ${notice.writer}<br>   
			
			<label for="title">제목</label>
			<input type="text" name="title" id="title" value="${notice.title}"><br>
			<textarea rows="5" cols="30" name="content" placeholder="내용을 입력하세요" id="content">${notice.content}</textarea><br><br>
			
			<input type="hidden" name="nNo"  value="${notice.nNo}">
			
			<button>수정완료</button>
			<input type="reset" value="초기화">
			<input type="button" value="목록 이동" onclick="location.href='list.notice'">
			
		</form>
	</div>
	
	
</body>
</html>