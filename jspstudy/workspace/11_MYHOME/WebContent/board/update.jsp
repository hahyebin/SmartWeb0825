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
	 #imageForm_wrap {
	 	width: 900px;
	 	margin: 0 auto;
	}	 
	 #f{
		width : 800px;
	  }
	
		label {
			display:block;
			margin-top: 10px; 
		}
	</style>


	<script>
		$(document).ready(function(){
			fnFileCheck();
			fnUpdateBoard();
		})		
		
		function fnFileCheck(){
					// 수정이 아니라 파일이 올라갈 때를 의미함 -> 즉 insert와 같은 기능
			$('#fileName').on('change',function(){
				/* 첨부 파일의 확장 제한하기 */
				let fullname = $(this).val();    // 첨부된 파일 이름이다.
				let extension = fullname.substring(fullname.lastIndexOf('.')+1).toUpperCase();  // 확장자만 추출 (대문자화)
				let extList = ['JPG','JPEG','PNG','GIF'];
				if($.inArray(extension, extList) == -1){ 			//배열에 찾는 요소가 없으면 -1을 반환 
					alert('확장자가 jsp, jpeg, png, gif인 파일만 업로드 할 수 있습니다.');
					$(this).val('');   // 첨부된 파일명을 빈 문자열로 바꿈 => 첨부가 없어짐.
					return false;
				}
				
				/* 첨부파일의 용량 제한하기 */
				let maxSize = 10 * 1024 * 1024;
				//console.log($(this)[0].files[0].size);
				let fileSize = $(this)[0].files[0].size;
				if( maxSize < fileSize){
					alert("10MB 이하의 파일만 업로드 할 수 있습니다.");
					$(this).val('');
					return false;
				}
			});
		}
		function fnUpdateBoard(){
			$("#update_btn").on('click',function(){
				if( $("#title").val() == '${param.title}' && $("#content").val() == '${param.content}' && $("#fileName").val() == '' ){
					alert("변경된 사항이 없습니다.");
					return;
				} 
				$('#f').attr('action', 'update.board');
				$('#f').submit();
			})		
		}			
	</script>
</head>
<body>
	
	<div id="imageForm_wrap">
		<h2>수정</h2>
		<!--  파일 첨부 폼  -->
		<!-- 
				1. method="post"
				2. enctpye="multipart/form-data"
		 -->
		<form id="f" method="post" enctype="multipart/form-data">
			
			<label for="writer">작성자</label>${param.writer}
			
			<label for="title">제목</label>
			<input type="text" id="title" name="title" value="${param.title}" autocomplete="false">
			
			<label for="content">내용</label>
			<textarea id="content" name="content"  >${param.content}</textarea>
			
			<div>
				<img width="300px"  src="${param.path}/${param.saveName}" >
			</div>
			
			<label for="fileName">새로 첨부하기</label>    <!--  saveName : 기존 첨부된 이미지 / fileName : 새로운 첨부(수정할 이미지) -->
			<input type="file" name="fileName" id="fileName" >
			<input type="hidden" name="bNo" value="${param.bNo}">
	<!--  		<input type="hidden" name="path" value="${param.path}">  -->
			<% session.setAttribute("path", request.getParameter("path")); %>
			<input type="hidden" name="saveName" value="${param.saveName}">
			
			<br><br>
			
			<div class="btn_area">
				<input type="button" value="수정하기" id="update_btn">
				<input type="reset" value="입력초기화" >
				<input type="button" value="목록"  onclick="location.href='list.board'">
			</div>
			
		</form>
	</div>
</body>
</html>