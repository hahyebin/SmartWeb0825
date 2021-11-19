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
	<style>
		* {
			padding: 0;
			margin: 0;
			box-sizing: border-box;
		}
		.wrap{
			width: 1500px;
			margin: 0 auto;
			padding: 10px;
			display:flex;
		}
		.input_area {
			width: 300px;
			padding: 10px;
		}
		.list_area {
			width: 1200px;
			padding: 10px;
		}
		.list_area table {
			width:1000px;
			border-collapse: collapse;
			
		}
		.list_area table td{
			border-top: 1px solid gray;
			border-bottom: 1px solid gray;
			padding: 3px 5px;
			text-align: center;
		}
		
	</style>
	<script>
		$(document).ready(function(){
			fnSelectBoardList();
			fnInsertBoard();
			fnDeleteBoard();
		}); // load
		
		// 전체 게시판 리스트 ajax 함수
		function fnSelectBoardList(){	
			$.ajax({
				url :'selectBoardList.do',
				type: 'get',
				// data : 보내는 파라미터 
				dataType: 'json',
				success : function(boards){
					//$.each(배열, function(인덱스, 요소){});
					// 기존 목록 지우기 
				$('#board_list').empty();
					$.each(boards, function(i, board){
						$('<tr>')
						.append( $('<td>').text(board.bNo) )
					    .append( $('<td>').text(board.writer) )
					    .append( $('<td>').text(board.content) )
					    .append( $('<td>').text(board.bDate) )
				//	    .append( $('<input type="hidden" name="bNo"> ').val(board.bNo) ) // 삭제버튼입장에선  부모의 윗 형제이다
					    .append( $('<td>').html( '  <input type="hidden" name="bNo" value="' +board.bNo +  '">  <input type="button" value="삭제"  class="delete_btn">   ' ) )
						.appendTo($('#board_list') )		
					}) // each
				},
				error : function(){   // 예외상황이 발생해서 에러가 난다면 별도의 catch 작성이 필요하다 하지만 리스트에선 별도의 에러를 자바단에서 throws로 던졌다,
					alert('실패');
				}
			}) // ajax	
		}
		
		
		
		// 게시판 등록 ajax 함수
		function fnInsertBoard(){
			
			$('#insert_btn').on('click',function()  {
				if(	$("#bNo").val().length != 5  ){
					alert('게시글 번호는 5자리입니다.');
					return;
				}
			    //	$.ajax({})  == JQuery.ajax({});
				$.ajax({        
					url : "insertBoard.do",
					type: 'post',
					data : $('#f').serialize(),   // 폼의 모든 요소를 파라미터로 보냄.
					dataType: 'json',
					success : function(obj){
						alert(obj.result);
						fnSelectBoardList();
					},
					// xhr.status 상태코드 
					// xhr.responseText -> 서버에서 보낸 오류텍스트 받기
					error: function(xhr){   // 응답 텍스트는 xhr 객체에 responseText 프로퍼티로 전달됨  
					  if(xhr.status == 1111 ){    // response.setStatus(1111); 코드로 보낸 값을 받음 
							alert(xhr.responseText);
					  }
					}			
				}); // ajax
			}); // insert_btn_click
		} //function
		
		function fnDeleteBoard(){
			$('body').on('click', '.delete_btn', function(){
			//	alert($(this).prev().val() );
			
				if(confirm('삭제할까요?')){
					$.ajax({
						url: "deleteBoard.do",
						type: 'get',                   // 번호 하나 전달시 get 사용
						data: 'bNo=' + $(this).prev().val(),
						dataType: 'json',
						success : function(obj){
							if(obj.result){
								alert('삭제 성공');
								fnSelectBoardList();  // 삭제 후 데이터 바꼈으니 목록 다시 부르기 
							} else {
								alert('삭제 실패');
							}
						},
						error : function(){
							alert('실패');
						}
					})//ajax
				} // confirm
					
					
				
			}); // click
		}
	
	</script>
</head>

<body>
	<div class="wrap">
		<div class="input_area">
			<form id="f" >
				<input type="text" name="bNo" id="bNo" placeholder="5자리번호"><br>
				<input type="text" name="writer" id="writer" placeholder="작성자"><br>
				<input type="text" name="content" id="content" placeholder="내용"><br>
				<input type="button" value="등록하기" id="insert_btn">
			</form>
		</div>
		<div class="list_area">
			<table>
				<thead>
					<tr>
						<td>게시글번호</td>
						<td>작성자</td>
						<td>내용</td>
						<td>작성일자</td>
						<td></td>
					</tr>
				</thead>
				<tbody id="board_list"></tbody>
				
			</table>
		</div>
	</div>

</body>
</html>