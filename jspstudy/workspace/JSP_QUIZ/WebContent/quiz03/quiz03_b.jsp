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
		request.setCharacterEncoding("utf-8");
	
		String writer = request.getParameter("writer");
		String fsp = request.getParameter("favoriteSportsPerson");
		String ftp = request.getParameter("talent");
		
	%>
	
	<h3><%=writer%>님의 선호도 조사 결과</h3>
	<ul>
		<li>좋아하는 연예인 : <%=ftp%></li>
		<li>좋아하는 운동선수 :<%=fsp%></li>
	</ul>
	<button id="reset_btn">처음부터 다시하기</button>
	
	<script>
	   $("#reset_btn").on('click',function(){
		   location.href="quiz03.jsp";
	   })
	
	</script>
	
	
</body>
</html>