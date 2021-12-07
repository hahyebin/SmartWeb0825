<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>게시글 수정화면</h1>
    <form action="/ex07/board/updateBoard.do" method="post">
    	<input type="text" name="title" value="${board.title}">
    	<input type="text" name="content" value="${board.content}">
    	<input type="hidden" name="no" value="${board.no}">
    	<button>수정하기</button>
    	<input type="button" value="목록"  onclick="location.href='/ex07/board/selectBoardList.do'">
    </form>



</body>
</html>