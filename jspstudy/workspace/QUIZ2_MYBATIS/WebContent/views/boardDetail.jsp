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
	     // textarea 비교 하는 법 	
		$("#f").on('submit',function(event){
			if ( $("#title").val() == '${Oneboard.title}' && $("#content").val() == '${Oneboard.content}' ){
				alert('수정 사항이 없습니다.');
				event.preventDefault();
				return false;
			} return true;
			
		});
		
		$("#delete_link").on("click",function(event){
			if( confirm('삭제할까요?') == false ){
				event.preventDefault();
				return false;
			}else{
				alert('삭제 성공');
				location.href='/Q_MYBATIS/boardDelete.do?idx='+${Oneboard.idx};      // 삭제 성공시 idx 갖고 이동하기 
			}return true;
		});

	});
</script>

</head>
<body>
	<form action="/Q_MYBATIS/boardModify.do" method="post" id="f">
		<table border="1" style="width:300px">
			<tr>
				<td>순번</td>
				<td><input type="text"  name="idx" value="${Oneboard.idx}" readonly ></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${Oneboard.writer}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text"  name="title" value="${Oneboard.title}" id="title" ></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content"  cols="30" rows="8" id="content" >${Oneboard.content}</textarea></td>
			</tr>
			<tfoot>
				<tr>
					<td colspan="2"> 
						<button>수정</button>
						<input type="button" value="목록" onclick="location.href='/Q_MYBATIS/boardAllList.do'">  
						<input id="delete_link" type="button" value="삭제" >
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>