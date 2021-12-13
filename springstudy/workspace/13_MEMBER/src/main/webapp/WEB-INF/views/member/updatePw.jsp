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
		 fnPwCheck();
		 fnPw2Check();
		 fnUpdatePw();
	});

	
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
	function fnUpdatePw(){
		$('#f').submit(function(event){
			if ( pwPass == false || pwPass2 == false ) {
				alert('비밀번호 입력을 확인하세요.')
				event.preventDefault();
				return false;
			}
			return true;
		});
	}  // end fnUpdatePw
	
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
	
	<h1>비밀번호 변경 화면</h1>
	
	<form id="f" method="post" action="/ex13/member/updatePw">
		 
		 <input type="hidden" name="email" value="${email}">
		
		비밀번호<br>
		<input type="password" name="pw" id="pw"><br>
		<span id="pw_result"></span><br><br>
		
		비밀번호 확인<br>
		<input type="password" name="pw2" id="pw2"><br>
		<span id="pw2_result"></span><br><br>
		
	
		<button>비밀번호 변경하기</button>

	</form>
	
</body>
</html>