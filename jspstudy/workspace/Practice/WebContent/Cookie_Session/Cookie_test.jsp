<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String keep_id = request.getParameter("keep_id");
		
		if( keep_id != null ){ // 만약 아이디 기억하기 체크박스가 체크된값(널이아님)이면  쿠키를 기억하자 
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(60*20);
			response.addCookie(cookie);
			
		} else {  //  쿠키에서 삭제 
			Cookie[] cookies = request.getCookies();
			 for( Cookie cookie : cookies){
				 if ( cookie.getName().equals("id")){
					 cookie.setMaxAge(0);
					 response.addCookie(cookie);
					 break;
				 }
			 }
			
		}
		// 둘다 로그인 완료 화면이동 
		response.sendRedirect("Cookie_form.jsp");
		
		
			
		
	%>
</body>
</html>