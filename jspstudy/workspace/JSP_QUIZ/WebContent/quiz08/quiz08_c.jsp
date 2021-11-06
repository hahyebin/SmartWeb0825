<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.io.*" %>

	<%
	
			 request.setCharacterEncoding("utf-8");	
			 String check = request.getParameter("check");
  	

  		
			String userId   = (String)session.getAttribute("userId");
	        String userPw   = (String)session.getAttribute("userPw");
	        String userName = (String)session.getAttribute("userName");
		   
			String fileName = userId+".txt";
			// 경로지정방법 외우기 
			String realPath = request.getServletContext().getRealPath("storage2");
			File dir = new File(realPath);
			if( dir.exists() == false){
				dir.mkdirs();
			}
			File file = new File(dir, fileName);
		
			BufferedWriter bw = new BufferedWriter (new FileWriter(file));
			bw.write("가입 아이디 : "+userId+"\n");
			bw.write("가입 비밀번호 : "+userPw+"\n");
			bw.write("가입 성명: "+userName);
			if( bw != null){
			bw.close();
		
			}
			session.setAttribute("filename", fileName);
			response.sendRedirect("quiz08_e.jsp");
			
  		%>
  	

  		
		

