<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인덱스</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>

	$(document).ready(function(){
		 fnPresentPwCheck();
		 fnPwCheck();
		 fnPw2Check();
		 fnUpdatePw();
		 fnUpdateMember();
		 fnLeaveMember();
	});
	
	// 현재 비밀번호 확인 변수와 함수 
	let presentPwPass = false;
	function fnPresentPwCheck(){
		
		$("#pw0_btn").click(function(){
			$.ajax({
				url: 'presentPwCheck',
				type: 'post',
				data: $('#f').serialize(),
				dataType: 'json',
				success: function(map){
					if (map.result) {
						console.log(map.result);
						presentPwPass = true;
					} else {
						presentPwPass = false;
					}
				}
			});
		})
	} // end fnPresentPwCheck
	
	
	// 비밀번호 변경 변수와 함수
	let pwPass = false;
	function fnPwCheck(){
		$('#pw').keyup(function(){
			let regPw = /^[0-9]{1,10}$/;           // 실제 서비스는 수정해서 사용 
			if( regPw.test( $(this).val() )  == false ){
				$('#pw_result').text('비밀번호는 1~9자리 숫자입니다.').addClass('no').removeClass('ok');
				pwPass = false;
			} else {
				$('#pw_result').text('사용 가능한 비밀번호입니다.').addClass('ok').removeClass('no');
				pwPass = true;
			}
		});
	} // end of fnPwCheck
	
	
	
	// 비밀번호 입력확인 변수와 함수
	let pwPass2 = false;
	function fnPw2Check(){
		 $('#pw2').keyup(function(){
			if( $(this).val() != $('#pw').val()  ) {
				$('#pw2_result').text("비밀번호를 확인하세요").addClass('no').removeClass('ok');
				pwPass2 =false;
			} else {
				$('#pw2_result').text('');
				pwPass2 =true;
			}
		})  
	} // end of fnPw2Check()
	
	// 비밀번호 변경 함수
	function fnUpdatePw() {
		$('#updatePw_btn').click(function(){
			if ( presentPwPass == false ) {
				alert('현재 비밀번호를 확인하세요.');
				return;
			}
			else if ( pwPass == false || pwPass2 == false ) {
				alert('새 비밀번호 입력을 확인하세요.');
				return;
			}
			$('#f').attr('action', '/ex13/member/updatePw');
			$('#f').submit();
		});
	}  // end fnUpdatePw
	
	
	
	
	// 이메일 중복체크 변수와 함수 
	let emailPass = false;
	function fnEmailCheck(){
		   if( $('#email').val() == '${loginUser.email}'  ){
			   emailPass = true;
			   return;
		   }
		   // 세션에 있는 이메일과 다르면 다시 점검하기
			let regEmail = /^[a-zA-Z0-9-_]+@[a-zA-Z0-9]+([.][a-zA-Z]{2,}){1,2}$/;
			if ( regEmail.test($('#email').val()) == false ) {
				alert('이메일 형식을 확인하세요.');
				emailPass = false;
				return;
			}		 
			 
			$.ajax({
				url : '/ex13/member/emaliCheck',
				type: 'post',
				data: 'email=' + $('#email').val(),
				dataType: 'json',
				success: function(map){
					if( map.result == null ) {
						 emailPass=true;
					} else {
						 alert('사용 중인 이메일입니다. 다른 이메일을 입력하세요');
						 emailPass=false;
					}
				},
				error: function(xhr) {
					emailPass = false;
				}				
			}); // end of ajax
	} // end of fnEmailCheck
	

	
	
	// 회원정보 변경 함수
	function fnUpdateMember(){
	    	fnEmailCheck();
			// 이름이랑 이메일 변경안할때
			if ( $("#name").val() == '${loginUser.name}'  &&  $("#email").val() == '${loginUser.email}'	) {
				alert('변경할 내용이 없습니다.');
				return;
			} 
			 if ( emailPass == false ){
					return;
			 }
			$('#f').attr('action', '/ex13/member/updateMember');
			$('#f').submit();
   	}
	
	// 회원탈퇴
	function fnLeaveMember(){
		$('#leave_btn').click(function(){
			if( confirm('탈퇴하시겠습니까?') ){
			//	location.href="/ex13/member/leave?no="+$('#no').val();
			$('#f').attr('action','/ex13/member/leave');
			$('#f').submit();
			}
		})
	}  // end of fnLeaveMember
	
	
</script>

<style type="text/css">
  .no {
  	color : red;
  	font-size: 13px;
  }
  .ok {
    color : #959595;
  	font-size: 13px;
  }
</style>
</head>
<body>
	<h1>마이페이지</h1>
	
	<form id="f" method="post" >
		
		<input type="hidden" name="no" id="no" value="${loginUser.no}">
		<input type="hidden" name="id" id="id" value="${loginUser.id}">
		
 	
		회원번호<br>
		${loginUser.no}<br><br>
		
		아이디<br>
		${loginUser.id}<br><br>
		
		가입일<br>
		${loginUser.registed}<br><br>
		
		현재 비밀번호<br>
		<input type="password" name="pw0" id="pw0">
		<input type="button" value="현재비밀번호확인" id="pw0_btn"><br><br>
		
		새 비밀번호<br>
		<input type="password" name="pw" id="pw" ><span id="pw_result"></span><br><br>
		
		
		비밀번호 확인<br>
		<input type="password" name="pw2" id="pw2"><br>
		<input type="button" value="비밀번호변경하기" id="updatePw_btn">
		<span id="pw2_result"></span><br><br>
		
		이름<br>
		<input type="text" name="name" id="name" value="${loginUser.name}"><br><br>

		이메일<br>
		<input type="text" name="email" id="email" value="${loginUser.email}"><br><br>
		
		<input type="button" value="회원정보 변경하기" id="updateMember_btn">
		<input type="button" value="되돌아가기" onclick="location.href='/ex13'">
		<input type="button" value="탈퇴하기" id="leave_btn" >
		
	</form>
	
</body>
</html>