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
	
		String fileName = request.getParameter("filename");
		String realPath = request.getServletContext().getRealPath("storage");
		File file = new File(realPath, fileName);
		
		if(file.exists()){
			file.delete();
		}
		boolean isExist = file.exists();// 삭제여부 확인 
		
	
	%>
	<script>
		if(<%=isExist %>){
			alert("탈퇴되지 않았습니다.");
			history.back();
		} else {
			alert("탈퇴되었습니다. 이용해 주셔서감사합니다.");
			location.href = "Tquiz05A.jsp";
		}
	
	</script>
	
	
</body>
</html>