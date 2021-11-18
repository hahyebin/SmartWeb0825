<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectOne</title>
 <link rel="stylesheet" type="text/css" href="css/bBoard1.css">
 <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function(){
		fnSelectReply();
		fnInsertReply();
		fnUpdateInsertBoard();
	}); // load
	
	
	// 게시글 수정 
	function fnUpdateInsertBoard() {
		$('#update').on('click',function(){
			if( confirm('수정이 가능합니다.')){
				$('#reset').show();
				$('#realupdate').show();
				$('#delete').show();
				$(this).hide();
				$("#title").removeAttr("readonly");
				$("#content").removeAttr("readonly");
		
			$('#realupdate').on('click',function(){
				$.ajax({
					url : "/Practice3/update.do",
					type:"post",
					dataType:'json',
					data: $('form').serialize(),
					success: function(resData){
							alert('수정성공');
					},
					error:  function(xhr, ajaxOptions, thrownError) {
				        console.log(xhr.status);
				        console.log(thrownError);
					}
				}); // ajax		
			 });//real
			}; // if
		})		
	}
	
	// 댓글삽입
	function fnInsertReply(){	
		$('#f1').on('submit',function(){		
				$.ajax({
					url : '/Practice3/insertReply.do',
					type : 'post',
					data : $('#f1').serialize(),  // 폼의 모든 요소를 파라미터로 넘김 
					dataType : 'json',
					success : function(resData){   
						if( resData.result > 0){
							alert('댓글 등록 성공');      
							fnSelectReply();	
						}else{
							aler('등록실패=서버')
						}
					},
					error : function(xhr, ajaxOptions, thrownError){
							 console.log(xhr.status);
					        console.log(thrownError);
					}
				}); // end of ajax	
		});
	} // function	
	
	// 댓글 리스트  - 각 게시물에 맞는 댓글을 가져와야하므로 게시글 번호 데이터 전송하기
	function fnSelectReply(){
			
			$.ajax({
				url : "/Practice3/listReply.do",
				type:"post",
				dataType:'json',
				data: 'idx='+ $("#comment_idx").val(),
				success: function(resData){
						if(resData.length  == 0 ){
							$('<tr>')
							.append( $('<td colspan="3">').text('댓글이 없습니다'))
							.appendTo("#tbody");
						} else {
							for(let i=0; i<resData.length; i++){
							$('<tr>')
							.append( $('<td class="comment_writer">').text(resData[i].writer) )
							.append( $('<td class="comment_content">').text(resData[i].content) )
							.append( $('<td class="comment_register">').text(resData[i].register) )
							.appendTo("#tbody");
						  } //for
					} // else
				},
				error:  function(xhr, ajaxOptions, thrownError) {
			        console.log(xhr.status);
			        console.log(thrownError);
				}
			}); // ajax			
		} // funciotn
</script>

</head>
<body>
<h2>게시판</h2>
	<form >
	
		 <table>
		 	<tr>
		 	<td>조회수
				<input id="hit" type="text" name="readCount" value="${board.readCount}" readonly>
		 	</td>
		 	
		 	<td><span id="regi">등록일</span>
		 	<input  id="register" type="text" name="register" value="${board.register}" readonly></td>
		 	</tr>
		 
		 		<tr>
					<td>글쓴이</td>
						<td><input type="text" name="writer" value="${board.writer}" readonly>
						<input type="hidden" name="idx" value="${board.idx}">
						</td>				
				</tr>
				<tr>
					<td>제목</td>
					<td colspan=2>
					   <input type="text" name="title" id="title" value="${board.title}" readonly >
					</td>
				</tr>	
		
				<tr>
					<td>내용</td>
					<td >
						<textarea name="content" readonly  cols="66" rows="14" id="content"> ${board.content} </textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" class="btn_td">
						<input class="btn1" id="update" type="button" value="수정하기" >
						<input  id="realupdate" type="button" value="수정완료">
						<input  id="reset" type="reset" value="다시 작성">
						<input  id="delete" type="button" value="삭제" onclick="location.href='/Practice3/delete.do?idx=${board.idx}'">
						<input class="btn1"  id="move" type="button" value="게시판 이동" onclick="location.href='/Practice3/selectAllList.do?hit=${hit}'">
					</td>
				</tr>
		</table>
	</form>
	
	
	<!--  댓글 구역이다.  -->
	<hr>
	
	<br><br>
	<div>
		<table id="comment_table">
			<thead>
				<tr>
					<th class="comment_writer">작성자</th>
					<th class="comment_content">댓글</th>
					<th class="comment_register">날짜</th>
				</tr>
			</thead>
		<tbody id="tbody">
			
		</tbody>
		
		</table>
	</div>
	<br>
	<div id="comment">
	
		<form id="f1">
			<input type="text" placeholder="작성자" name="writer" style="width:70px;">
		    <input type="text" placeholder="댓글을 입력주세요" name="content">
			<input type="hidden" name="idx" value="${board.idx}" id="comment_idx">
			<button>입력</button>
		</form>
	</div>

</body>
</html>