<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<style>
		label{
			display : inline-block;
			width: 100px;
		}
		
	</style>
</head>
<body>
	<% 
	// 쿠키 이름 : getName();
	// 쿠키 값 : getValue();
	    // 쿠키 이름이 userId인 쿠키를 찾는다.
		// userId 쿠키가 있으면 id="userId"인 요소에 값을 넣는다.
		String userId = null;
		Cookie[] cookies =  request.getCookies();
		
		// cookie 점검 
		if( cookies != null && cookies.length != 0){
		    for(Cookie cookie : cookies){
		    	if( cookie.getName().equals("userId")){
		    		userId = cookie.getValue();
		    		break;
		    	}
		    }
	     }
	%>
	<script>
		$(document).ready(function(){
			if('<%=userId%>' != 'null'){   /* 값에 표현된 것이 null인데 문자열로 표현되기 때문에 null을 문자열로변환함*/
				$("#userId").val( '<%=userId%>');
				$("#checkSaveId").attr('checked',"checked");  /* = prop('checked', true)*/
			} 
		});
	
	</script>
	
	<form action="06_saveIdB.jsp" method="post">
		<div>
			<label for="userId">아이디</label>
			<input type="text" name="userId" id="userId" placeholder="아이디">
		</div>
		<div>
			<label for="userPw">비밀번호</label>
			<input type="text" name="userPw" id="userPw" placeholder="비밀번호">
		</div>
		<div>
			<button>로그인</button>
		</div>
		<div>
			<input type="checkbox" name="checkSaveId" id="checkSaveId">
			<label for="checkSaveId">아이디기억</label>
		</div>
	</form>
	
</body>
</html>