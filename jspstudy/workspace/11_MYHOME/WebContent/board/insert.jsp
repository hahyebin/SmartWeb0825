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
			fnInsertBoard();
		})		
		
		function fnFileCheck(){
			$('#fileName').on('change',function(event){
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
	
			
		function fnInsertBoard(){
			$("#insert_btn").on('click',function(){
				if( $("#title").val() == '' ){
					alert("제목은 필수입니다.");
					$("#title").focus();
					return;
				} else if ( $("#fileName").val() == '' ){
					alert("이미지 첨부는 필수입니다.");
					return;
				}
				$('#f').attr('action', 'insert.board');
				$('#f').submit();
			})		
		}			
	</script>
</head>
<body>
	
	<div id="imageForm_wrap">
		
		<!--  파일 첨부 폼  -->
		<!-- 
				1. method="post"
				2. enctpye="multipart/form-data"
		 -->
		<form id="f" method="post" enctype="multipart/form-data">
			
			<label for="writer">작성자</label>
			<input type="text" id="writer" name="writer" value="${loginUser.id}" readonly="readonly">
			
			<label for="title">제목</label>
			<input type="text" id="title" name="title" autofocus autocomplete="false">
			
			<label for="fileName">첨부 이미지</label>
			<input type="file" name="fileName" id="fileName">
			
			<label for="content">내용</label>
			<textarea id="content" name="content" ></textarea>
			
			<br><br>
			
			<div class="btn_area">
				<input type="button" value="입력완료" id="insert_btn">
				<input type="reset" value="입력초기화" >
				<input type="button" value="목록"  onclick="location.href='list.board'">
			</div>
			
		</form>
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>