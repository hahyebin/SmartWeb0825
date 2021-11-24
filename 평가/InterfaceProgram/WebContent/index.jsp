<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<style>
    #list_wrap table { 
    	border-collapse: collapse;
    }
    
	#list_wrap table tr{
		border-top: 1px solid gray;
		border-bottom: 1px solid gray;
		padding: 3px 5px;
		text-align: center;
	}
	#list_wrap table  td {
		width : 120px;
	}
</style>
<script>
	$(document).ready(function(){
			fnInsertStaff();
			fnListStaff();
	}) // load
	 
	// 사원 리스트
	function fnListStaff(){
		$.ajax({
			url : "listStaff.do",
			type : 'get',
			dataType : 'json',
			success : function(staffs){
				$('#staff_list').empty(); // 리스트 반복안되게 비우기 
				$.each(staffs, function(i, staff){
					$('<tr>')
					.append( $('<td>').text(staff.sNo)  )
					.append( $('<td>').text(staff.name)  )
					.append( $('<td>').text(staff.dept)  )
					.append( $('<td>').text(staff.regDate)  )
					.appendTo($('#staff_list'))
				}); //each
			},
			error : function(){
				alert('리스트 실패');
			}
		}) // end ajax
	} // fnListStaff
	
	// 사원 등록 
	function fnInsertStaff(){
		// 사원번호 정규식
		let regNo = /^[0-9]{5}$/;
		// 부서명 정규식 
		let regDept = /^[가-힣]{3,5}$/;
		
		
		$('#insert_btn').on('click',function(){
			if( regNo.test( $('#sNo').val() ) == false){
				alert('사원번호는 5자리 숫자입니다.');
				 $('#sNo').focus();
				return;
			};
			
			if( regDept.test( $('#dept').val() ) == false){
				alert('부서는 3~5자리 한글입니다');
				 $('#dept').focus();
				return;
			};
		
			$.ajax({
				url : "staffInsert.do",
				data : $('#insert_form').serialize(),
				dateType : 'json',
				type : 'post',
				success : function(resData){
					alert('사원 등록이 성공했습니다.');
					fnListStaff();
					$('#sNo').val(''); $('#name').val(''); $('#dept').val('');
				},
				error : function(xhr){
					if( xhr.status== 1001) {
						alert(xhr.responseText);
				  }
			   }
			}) // ajax		
		}) // click event
	} // fnInsertStaff
	
	
	
</script>
</head>
<body>
	
	<h1>사원 정보 등록프로그램</h1>
	<div id="insert_form_wrap">
		<form id="insert_form">
			<input type="text" name="sNo" id="sNo" placeholder="사원번호">
			<input type="text" name="name" id="name" placeholder="사원명">
			<input type="text" name="dept" id="dept"  placeholder="부서명">
			<input type="button" id="insert_btn" value="등록하기">
		</form>
	</div>
	<hr>
	<div id="list_wrap">
		<table>
			<thead>
				<tr>
					<td>사원번호</td>
					<td>사원명</td>
					<td>부서명</td>
					<td>입사일</td>
				</tr>
			</thead>
			<tbody id="staff_list">
				
			</tbody>
		
		</table>
	</div>
	
	
	
</body>
</html>