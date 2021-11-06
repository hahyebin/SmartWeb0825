<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		request.setCharacterEncoding("UTF-8");
	
		String fileName = request.getParameter("fileName");
		String dir = request.getServletContext().getRealPath("storage");
		File file = new File(dir, fileName);
		
		//FileInputStream fis = new FileInputStream(file);
		//InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		StringBuilder sb = new StringBuilder();
		String str = null;
		while( (str = br.readLine()) != null){
			sb.append(str + "<br>");
		}
		// 읽을파일내용저장 
		request.setAttribute("filetext", sb.toString());
		
		if( br != null){ br.close(); }
	
	
	%>
	 <h2>가입되었습니다.</h2>
	 <h3>가입내용 </h3>
		${filetext} 
	<!-- 파일 삭제위한 폼 만들기 -->
	<form action="Tquiz05E.jsp" method="post">
		<input type="hidden" name="filename" value="<%=fileName%>">
		<input type="submit" value="탈퇴">
	</form>
	<script>
		$("form").on("submit",function(){
			alert("탈퇴되었습니다.");
		});

</script>
	
</body>
</html>