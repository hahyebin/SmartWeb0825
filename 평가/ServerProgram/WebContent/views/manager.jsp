<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			// 탈퇴 버튼 클릭하면 confirm
			$('#outof').on('click',function(){
				if ( confirm('탈퇴하시겠습니까?')){
					location.href='/ServerProgram/outof.do?no='+$('#no').val();
				} 
			}) // outof
			
			$('#f1').on('submit',function(event){
				if( $('#name').val() == '${member.name}' &&   $('#point').val() == '${member.point}'){
					alert('수정사항이없습니다');
					event.preventDefault();
					return false;
				}
				return true;
			}); // 수정 폼		
		}) // load
	
	</script>
	<style>
	*{		
		padding: 0;
		margin-left: 10px;
		box-sizing: border-box;
	}
	h3{
		margin: 20px 0;
	}
	#t1{
		margin-top:10px;
		width: 500px;
		border-collapse: collapse;
	}
	#t1 thead tr{
		border-top: 3px solid gray;
	}
	#t1 tfoot tr{
		border-bottom: 3px solid gray;
	}
	#t1 tr {
		height : 40px;
	}
	#t1 tbody tr {
		border-top: 1px solid gray;
		border-bottom: 1px solid gray;
	}
	#t1 td { text-align: center; }
	.input {
		border:0;
		outline:0;
		width: 80px;
	}
	button {
		display :inline-block;
		margin-top: 8px;
		margin-right:5px;
	}

	</style>
</head>
<body>
	<h3>회원관리시스템</h3>
	<a href="/ServerProgram/logout.do?id=${member.id}&name=${member.name}">로그아웃</a> <!--  세션삭제.. -->
	<hr>
	<form action="/ServerProgram/update.do" method="post" id="f1">
		<table id="t1">
			<thead>
				<tr>
					<td>아이디 </td>
					<td>이름 </td>
					<td>등급</td>
					<td>포인트</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" name="id" value="${member.id}" readonly class="input">
						<input type="hidden" name="no" value="${member.no}" id="no">
					</td>
					<td><input type="text" name="name" value="${member.name}"  id="name"></td>
					<td><input type="text" name="grade" value="${member.grade}" readonly  class="input"></td>
					<td><input type="text" name="point" value="${member.point}" id="point"></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4">
						<button>수정하기</button>
						<input type="button" value="탈퇴하기" id="outof">
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>