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
	label {
		display:inline-block;
		margin-right:50px;
	}
</style>
</head>
<body>
		
  <%
   String check = request.getParameter("check");
  	request.setAttribute("check", check);
  	
  	if( check.equals("agree") ){
  		response.sendRedirect("quiz08_c.jsp");
  	}
  	if( check.equals("disagree") ){
  		response.sendRedirect("quiz08_d.jsp");
  	}
  	
  
  %>
  
	

</body>
</html>