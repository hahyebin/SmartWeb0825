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


</head>
<body>
<%
		request.setCharacterEncoding("UTF-8");
		String userEmail = request.getParameter("userEmail");
		String userTel = request.getParameter("userTel");
		String userAddr = request.getParameter("userAddr");
		
		Cookie cookie4 = new Cookie("userEmail", userEmail);
		cookie4.setMaxAge(60*60);
		response.addCookie(cookie4);
		Cookie cookie5 = new Cookie("userTel", userTel);
		cookie5.setMaxAge(60*60);
		response.addCookie(cookie5);
		Cookie cookie6 = new Cookie("userAddr", userAddr);
		cookie6.setMaxAge(60*60);
		response.addCookie(cookie6);
%>

	<form action="quiz06_c.jsp">
	<h3>추가정보를 입력하세요.</h3>
	<div>
		<label for="userYear">생년월일&nbsp;&nbsp;&nbsp;</label>
		<input type="text" name="userYear" id="userYear" style="width:40px">년
		<input type="text" name="userMonth" id="userMonth" style="width:40px">월
		<input type="text" name="userDay" id="userDay" style="width:40px">일
	</div>
	<div>
		<label for="userIsMarried">결혼여부</label>
		<label><input type="radio" name="userIsMarried" value="미혼" id="userIsMarried" checked>미혼</label>
		<label><input type="radio" name="userIsMarried" value="기혼"checked>기혼</label>
	</div>
	<div>
		<label for="userJob">직업&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
		<select name="userJob">
			<option value="developer">개발자</option>
			<option value="talent">연예인</option>
		</select>
	</div>
		
	
	     <br><br><br>
		<button>확인</button>
	</form>
	

</body>
</html>