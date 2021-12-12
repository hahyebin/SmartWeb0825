<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>
	
	<h1>갤러리 상세보기 및 수정</h1>
	
	<hr>
	
	<form id="f"  method="post" enctype="multipart/form-data">
		
		<strong>작성자</strong><br>
		${gallery.writer}<br><br>
		
		<strong>작성일</strong><br>
		${gallery.created}<br><br>
		
		<strong>수정일</strong><br>
		${gallery.lastModified}<br><br>
			
		<strong>작성자 IP</strong><br>
		${gallery.ip}<br><br>
		
		<strong>제목</strong><br>
		<input type="text" name="title" value="${gallery.title}"><br><br>
		
		<strong>내용</strong><br>
		<input type="text" name="content" value="${gallery.content}"><br><br>
			
		첨부변경하기<br>
		<input type="file" name="new_file"><br><br>
		
		기존 첨부 : ${gallery.origin}<br><br>
		<c:set value="${gallery.saved}" var="video"></c:set>
			 <c:if test="${not f:contains(video, 'mp4')}">
					<img alt="${gallery.origin}" src="/video/${gallery.path}/${gallery.saved}" width="400px">
			</c:if>
			<c:if test ="${f:contains(video, 'mp4')}">
			<video autoplay controls loop muted poster="video" width="400px">
				<source src="/video/${gallery.path}/${gallery.saved}"  type="video/mp4">
			</video>
			</c:if>		
	</form>
	
	
	
</body>
</html>