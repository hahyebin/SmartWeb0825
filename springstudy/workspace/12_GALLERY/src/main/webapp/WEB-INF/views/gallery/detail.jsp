<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<style type="text/css">
	body {
		 width: 900px;
		 margin: 0 auto;
	}
	form {
		 width: 800px;
		 margin: 0 auto;
	}
</style>
<script type="text/javascript">
	$(document).ready(function(){
			// 수정
		    $('#update_btn').on('click',function(){
		    	if( '${gallery.title}' == $('#title').val()  &&  '${gallery.content}' == $('#content').val() &&  $("#newFile").val() == ''  ){
		    		alert('수정할 내용이 없습니다.');
		    		return;
		    	}
		    	$('#f').attr('action', '/ex12/gallery/updateGallery');
		    	$('#f').submit();
		    });
			
			// 삭제
			$("#delete_btn").on('click',function(){
				if ( confirm('삭제하시겠습니까?') ){
					$('#f').attr("action", '/ex12/gallery/deleteGallery');
					$('#f').submit();
					}
			});
	});
	


</script>
</head>
<body>
	
	<h1>갤러리 상세보기 및 수정</h1>
	
	<hr>
	
	<form id="f"  method="post" enctype="multipart/form-data">
	
		<!--  수정할 때 보낼 값 form의 타입은 multipart -->
		<input type="button" value="수정" id="update_btn" >
		<input type="hidden" name="path" value="${gallery.path}">
		<input type="hidden" name="saved" value="${gallery.saved}">
		<input type="hidden" name="origin" value="${gallery.origin}">
		<input type="hidden" name="created" value="${gallery.created}">  <!-- 사진이 없던 갤러리에 사진 추가할경우 최초작성일로 만든 파일경로가 필요하기 때문에 정보를 전달해야 새롭게 저장가능하다 -->
		
		
		
		<!--  삭제할 때 보낼 값 form의 타입은 multipart  -->
		<input type="button" value="삭제" id="delete_btn" >
		<input type ="hidden" value="${gallery.no}" name ="no" id="no">

		<input type="button" value="목록" onclick="location.href='/ex12/gallery/selectGalleryList'"><br>
		
		<strong>작성자</strong><br>
		${gallery.writer}<br><br>
		
		<strong>작성일</strong><br>
		${gallery.created}<br><br>
		
		<strong>수정일</strong><br>
		${gallery.lastModified}<br><br>
			
		<strong>작성자 IP</strong><br>
		${gallery.ip}<br><br>
		
		<strong>제목</strong><br>
		<input type="text" name="title" value="${gallery.title}" id="title"><br><br>
		
		<strong>내용</strong><br>
		<input type="text" name="content" value="${gallery.content}" id="content"><br><br>
			
		<strong>첨부변경하기</strong><br>
		<input type="file" name="newFile" id="newFile"><br><br>
		
	</form>
		
		<c:if test="${not empty gallery.origin}">
			<strong>기존 첨부 :</strong> ${gallery.origin}<br><br>
			<img alt="${gallery.origin }" src="/ex12/${gallery.path}/${gallery.saved}" width="400px"><br>
			  	<form action="/ex12/gallery/download" method="post">
					<input type="hidden" name="origin" value="${gallery.origin}">
					<input type="hidden" name="path" value="${gallery.path}">
					<input type="hidden" name="saved" value="${gallery.saved}">
					<button>다운로드</button>
			  	</form>
  		
		</c:if>
		

		 
	
	
	
	
</body>
</html>