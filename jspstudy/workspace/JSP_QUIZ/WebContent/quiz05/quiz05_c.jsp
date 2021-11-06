<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.io.*" %>
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
			request.setCharacterEncoding("UTF-8");
		    String userId = request.getParameter("userId");
			String userPw = request.getParameter("userPw");
			String userName = request.getParameter("userName");
		   
			String fileName = userId+".txt";
			File file = new File(fileName);
		
			FileWriter fw =new FileWriter(fileName);
			fw.write("가입 아이디 : "+userId+"\n");
			fw.write("가입 비밀번호 : "+userPw+"\n");
			fw.write("가입 성명: "+userName);
			
			fw.close();
		
		%>

	 <h2>가입되었습니다.</h2>
	 <h3>가입내용 </h3>
	 <p>가입 아이디 :  <%=userId %></p>
	 <p>가입 비밀번호 : <%=userPw %></p>
	 <p>가입 성명 : <%=userName %></p>
	  <button>탈퇴</button>
	<script>
		$("button").on("click",function(){
			alert("탈퇴되었습니다.");
			location.href = "quiz05.jsp";
			
		})

</script>
</body>
</html>