<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	label {
		display: inline-block;
		width:100px;
	}
</style>
</head>
<body>

	<h1>게시글 작성 화면</h1>
	<form action="/ex06/board/insertBoard.do" method="post">
		<div>
			<label for="writer">작성자</label>
			<input type="text" name="writer" id="writer" placeholder="작성자">
		</div>
		<div>
			<label for="title">제목</label>
			<input type="text" name="title" id="title" placeholder="제목">
		</div>
		<div>
			<label for="content">작성자</label>
			<input type="text" name="content" id="content" placeholder="내용">
		</div>
		<button>작성완료</button>
	</form>



</body>
</html>