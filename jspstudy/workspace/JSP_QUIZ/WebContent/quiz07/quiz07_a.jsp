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
			 String sport = request.getParameter("sport");
		     String talent = request.getParameter("talent");
		     String writer = request.getParameter("writer");
		 	session.setAttribute("talent", talent);
			session.setAttribute("writer", writer);
	
		%>
	
	<form action="quiz07_b.jsp">
	<h2>2. 좋아하는 운동선수는누구인가요?</h2>
		<input type="text" name="sport" >
		<input type="hidden" name="talent"  value="<%=talent%>">
		<input type="hidden" name="writer"  value="<%=writer%>">
		<button>다음</button>
	</form>
	
</body>
</html>