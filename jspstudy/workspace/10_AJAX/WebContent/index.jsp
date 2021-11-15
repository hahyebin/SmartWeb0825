<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Welcome</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>
	<a href="/AJAX/selectListFrom.do">제품 목록으로 이동하기</a>
		<!--  목록을 가져오는게 아니라 이동만 하는 방식이여야함 
				이동 후에 selectList에 있는 script의 ajax가 먼저 실행됨에 따라 그곳에서 
				selectList.do로 가 리스트를 갖고와서 텍스트에 뿌림-->

</body>
</html>