<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%
	request.setCharacterEncoding("utf-8");

	String filename = request.getParameter("filename");
	String realpath = request.getServletContext().getRealPath("storage2");
	
	File file = new File(realpath, filename);
	if( file.exists()){ file.delete();  }
	boolean isExist = file.exists();
	
%>
<script>

	if( <%=isExist%>){
		alert('탈퇴되지않았습니다.');
		history.back();
	}else {
		alert('탈퇴되었습니다. 이용해 주셔서 감사합니다.');
		location.href="quiz08.jsp";
	}

</script>