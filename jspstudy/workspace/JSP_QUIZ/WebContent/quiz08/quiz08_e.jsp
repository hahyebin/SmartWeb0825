<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
			//내용읽기 
			
			String filename = (String)session.getAttribute("filename");
			String realpath = request.getServletContext().getRealPath("storage2");
			
			File file = new File(realpath, filename);
			BufferedReader br = new BufferedReader(new FileReader(file));
			StringBuilder sb = new StringBuilder();
			String text = null;
			while( (text = br.readLine()) != null ) { sb.append(text + "<br>"); }
			if( br!=null){  br.close(); }

	%>




		<h2>가입되었습니다.</h2>
		 <h3>가입내용 </h3>
		   <%=sb.toString() %>
		   <form action="quiz08_f.jsp" method="post">
		   	<input type="hidden" name=filename value="<%=filename%>">
		   	<input type="submit" value="탈퇴하기">
		   </form>
	
		<script>
			$("form").on('submit',function(event){
				if(confirm("정말  탈퇴하시겠습니가?") == false ){
					event.preventDefault();
					return false;
				}
				return true;
			
			
			});
		
		</script>
</body>
</html>