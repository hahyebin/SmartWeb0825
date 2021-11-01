<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookie 회원가입</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<style>
	label {
	display: block;
	width: 130px;
	margin: 20px;
	}
	button { margin: 20px;}
</style>
<%
		String idVal = null;
		Cookie[] cookies = request.getCookies();
		if ( cookies != null && cookies.length != 0 ){
			for(Cookie cookie : cookies){
				if ( cookie.getName().equals("id"))
				idVal = cookie.getValue();
			}
		}
	%>


<script>
 $(document).ready(function(){
	 $("form").on("submit",function(event){
		 if( $("#id").val() == ''){
			 alert("아이디를 입력해주세요");
			 $("#id").focus();
			 event.preventDefault();
		 } else if ( $("#pw").val() == ''){
			 alert("비밀번호를 입력해주세요");
			 $("#pw").focus();
			 event.preventDefault();
		 }   
	 })
	 
	 
	 if( '<%=idVal%>' != 'null'){
			$("#id").val( '<%=idVal%>');
			$("#id").attr('checked',"checked");  /* = prop('checked', true)*/
		} 
	 
 });
 

</script>
<body>
	
	
	</script>

	<form action="Cookie_test.jsp">
		<label for="id">아이디 : <input type="text" name="id" id="id" placeholder="아이디"></label>
		<label for="pw">비밀번호 : <input type="password" name="pw" id="pw" placeholder="비밀번호"></label>
		<label><input type="checkbox" name="keep_id">&nbsp;&nbsp;아이디 기억하기 </label>
		<button>로그인하기</button>
	</form>
</body>
</html>