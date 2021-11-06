<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	
		<%
			request.setCharacterEncoding("UTF-8");
	     	// 동의 여부 속성 name -> agree or disagree
			String check = request.getParameter("check");
		
	     	
	     	if( check.equals("agree")){   // check값이 agree인 경우 폴더생성!
			String userId = request.getParameter("userId");
			String userPw = request.getParameter("userPw");
			String userName = request.getParameter("userName");
		   
			// 파일이름 
			String fileName = userId+".txt";
		
			// 파일경로 
			String realPath = request.getServletContext().getRealPath("storage");
			File dir = new File(realPath);
			//폴더 없으면 생성하기 
			if( dir.exists() == false){
				dir.mkdirs();
			}
			// 파일이름과 경로 설정 후 파일 생성하기 
			File file = new File(dir, fileName); 
			
			// 파일출력하기 
			//FileOutputStream output = new FileOutputStream(file);
			//OutputStreamWriter writer = new OutputStreamWriter(output,"UTF-8");
			//BufferedWriter bw = new BufferedWriter(writer);
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));		
			bw.write("가입 아이디 : "+userId+"\n");
			bw.write("가입 비밀번호 : "+userPw+"\n");
			bw.write("가입 성명: "+userName);
			if( bw != null){ bw.close();}
	     	
			response.sendRedirect("Tquiz05D.jsp?fileName="+fileName);
			
			
	     	} else { // check값이 disagree인 경우  
		%>
			<h1>가입되지 않았습니다.</h1>
			<a href="Tquiz05A.jsp">다시 가입하기</a>
		<% } %>


</body>
</html>