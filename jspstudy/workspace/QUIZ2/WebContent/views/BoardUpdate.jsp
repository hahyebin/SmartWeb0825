<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
$(document).ready(function(){
		$("#delete_link").on("click",function(event){
			if( confirm('삭제할까요?') == false ){
				event.preventDefault();
				return false;
			}else{
				alert('삭제 성공');
				location.href='/QUIZ2/delete.board?idx='+${board.idx};      // 삭제 성공시 idx 갖고 이동하기 
			}return true;
		});
	});
</script>

</head>
<body>
	<form action="/QUIZ2/modify.board" method="post">
		<table border="1" style="width:300px">
			<tr>
				<td>순번</td>
				<td><input type="text"  name="idx" value="${board.idx}" readonly ></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${board.writer}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text"  name="title" value="${board.title}" ></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content"  cols="30" rows="8" >${board.content}</textarea></td>
			</tr>
			<tfoot>
				<tr>
					<td colspan="2"> 
						<button>수정</button>
						<input type="button" value="목록" onclick="location.href='/QUIZ2/selectList.board'">  
						<input id="delete_link" type="button" value="삭제" >
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>