<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 상세 보기</h1>
	<ul>
		<li>게시글 번호 : ${board.no}</li>
		<li>게시글 작성자 : ${board.writer}</li>
		<li>게시글 제목 : ${board.title}</li>
		<li>게시글 내용 : ${board.content}</li>
		<li>최초등록일 : ${board.created}</li>
		<li>최종수정일 : ${board.lastModified}</li>
	</ul>

	<form>
		<input type="hidden" name="no" value=" ${board.no}">
		<input type="hidden" name="title" value=" ${board.title}">
		<input type="hidden" name="content" value=" ${board.content}">
		<input type="button" value="수정하러가기"  onclick="fnUpdateBoardForm(this.form)">  <!--  this.form 현재 폼의 모든 요소 보냄  -->
		<input type="button" value="삭제"  onclick="fnDeleteBoard(this.form)">
		<input type="button" value="목록"  onclick="fnSelectBoardList()">
	</form>
	<script>
		function fnUpdateBoardForm(f){  // f = this.form
			f.action = '/ex06/board/updateBoardForm.do';
			f.submit();  					// form의 submit
		}
		function fnDeleteBoard(f){
			f.action = '/ex06/board/deleteBoard.do';
			f.submit();
		}
		function fnSelectBoardList(){
			location.href = '/ex06/board/selectBoardList.do';
		}
		
	</script>
</body>
</html>







