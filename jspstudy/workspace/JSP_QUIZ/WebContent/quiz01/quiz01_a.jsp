<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
	<%   
		String site = request.getParameter("site");
		String move = "";
	switch(site){
	 	case "naver": 
	 		move = "https://www.naver.com";
	 		break;
	 	case "google": 
	 		move = "https://www.google.com";
	 		break;
	 	case "nate": 
	 		move = "https://www.nate.com";
	 		break;
	 	case "daum": 
	 		move = "https://www.daum.net";
	 		break;
	 	}
	
		response.sendRedirect(move);
	 %>