<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<style>
	label {
	display: block;
	width: 130px;
	margin: 20px;
	}
	button { margin: 20px;}
</style>
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
	 

 });
 

</script>
</head>
<body>
	세션 : 웹 서버 쪽의 웹 컨테이너에 상태를 유지하기 위한 정보 저장 
	<br> 사용자의 정보를 유지하기 위해 HttpSession 인터페이스 구현해서 사용한다. 
	<br> 세션은 웹 브라우저당 1개씩 생성되어 웹 컨테이너에 제공된다. 
	<br> 메서드 
	<br> 1. getAttribute(java.lang.String name) -> 세션 속성명이 name인 속성의 값을 Object타입으로 리턴 
	<br> 2. setAttribute(name, value) : 세션 속성명이 name인 속성에 속성값으로 value 할당 
	<br> 3. invalidate() : 세션무효화
	<br> 4. removeAttribute() : 세션 속성명이 name인 속성 제거
	<br>
	<hr>
	
	<% 
		boolean KeepLogin = false;
		Cookie[] cookies = request.getCookies();
		if( cookies != null && cookies.length!=0){
			for(Cookie cookie : cookies ){
				if(cookie.getName().equals("id")){
					KeepLogin=true;
					break;
				}
			}
		}
	
	%>
	
	<% if ( KeepLogin == false ) { %>
	<h2>정보입력 폼</h2>
	<form action="session_test.jsp">
	<label for="id">아이디 : <input type="text" name="id" id="id" placeholder="아이디"></label>
		<label for="pw">비밀번호 : <input type="password" name="pw" id="pw" placeholder="비밀번호"></label>
		<label><input type="checkbox" name="keep_login">&nbsp;&nbsp;자동 로그인하기 </label>
		<button>로그인하기</button>
	</form>
	<% } else { response.sendRedirect("session_Result.jsp"); } %>
</body>

</html>