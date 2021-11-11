<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<style>
		.wrap {
			width:500px;
			margin: 0 auto;
		}
		h1 {
			text-align: center;
			color: gray;
		}
		table { 
		    width:100% ;
		    border-collapse: collapse; 
		  }
		td {
			border-top: 1px solid grey;
			border-bottom: 1px solid grey;
			text-align: center;
			padding: 3px 5px;
		}
		tbody input {	width :80px;	}
		tfoot input {
			width: 100px;
			height: 30px;
			background-color: lightgrey;
			border: 0;
			outline: 0;
			text-align: center;	
		}
		#insert_btn {
			font-weight: bold;
		}
		tfoot input:hover{
			cursor: pointer;
			background-color: darkgrey;
		}
	</style>
	<script>
		$(document).ready(function(){
			fnSnoCheck();
			
			$('#kor').on('keyup blur', fnKorCheck);
			$('#eng').on('keyup blur', fnEngCheck);
			$('#mat').on('keyup blur', fnMatCheck);
			
			// 전역변수에 event 설정에 대한 boolean을 선언하여 submit막는 event실행하기
			$('#f').on('submit',function(event){
				if ( snoPass == false ){
					alert('학번은 5자리 숫자입니다.');
					$('#sno').focus();
					event.preventDefault();
					return false;
				} else if (korPass == false ){
					alert('국어 점수는 0~100 사이 정수입니다.');
					$('#kor').focus();
					event.preventDefault();
					return false;
				}  else if (engPass == false ){
					alert('영어 점수는 0~100 사이 정수입니다.');
					$('#eng').focus();
					event.preventDefault();
					return false;
				} else if (matPass == false ){
					alert('수학 점수는 0~100 사이 정수입니다.');
					$('#mat').focus();
					event.preventDefault();
					return false;
				}  
				return true;
     	});
	});
		//전역 변수 영역(event막기 위한 설정)
		let snoPass = false;
		let korPass = false;
		let engPass = false;
		let matPass = false;
		
			
		// 학번 체크 함수
		function fnSnoCheck(){
			let regSno = /^[0-9]{5}$/;
			$("#sno").on('keyup blur',function(){
				if ( regSno.test( $(this).val())  ){
					snoPass = true;
				} else {
					snoPass = false;
				}
			});
		}
		
		// 국어 점수 체크 함수 ( 숫자가 아니고 0점 이하고 100점 이상이면 이동 못함 )
		function fnKorCheck(){
			if( isNaN($('#kor').val()) || $("#kor").val() < 0 || $("#kor").val() > 100  ){
				korPass =false;
			} else {
				korPass = true;
			}			
		}
		// 영어 점수 체크 함수
		function fnEngCheck(){
			if(isNaN($('#eng').val()) || $("#eng").val() < 0 || $("#eng").val() > 100  ){
				engPass =false;
			} else {
				engPass = true;
			}			
		}
				
		// 수학 점수 체크 함수 
		function fnMatCheck(){
			if(isNaN($('#mat').val()) || $("#mat").val() < 0 || $("#mat").val() > 100  ){
				matPass =false;
			} else {
				matPass = true;
			}			
		}
	</script>
</head>
<body>
	
	<div class="wrap">
		<h1>학생 등록 화면</h1>
	
		<form action="/BATCH/insertStudent.do" method="post" id="f">
			<table>
				<thead>
					<tr>
						<td>학번</td>
						<td>성명</td>
						<td>국어점수</td>
						<td>영어점수</td>
						<td>수학점수</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="text" name="sno" id="sno" autofocus></td>
						<td><input type="text" name="name" id="name"></td>
						<td><input type="text" name="kor" id="kor"></td>
						<td><input type="text" name="eng" id="eng"></td>
						<td><input type="text" name="mat" id="mat"></td>	
					</tr>	
				</tbody>
				<tfoot>
					<tr>
						<td colspan="5">
							<input type="submit"  id="insert_btn" value="학생 등록하기">							
							<input type="reset"  value="입력 초기화">
							<input type="button"  value="학생 목록"  onclick="location.href='/BATCH/studentList.do'"  >
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
		
		
		
	</div>
</body>
</html>