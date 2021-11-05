<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

    <%-- 예외발생시  예외 페이지 작성 --%>
    <%@page errorPage ="Tquiz_error.jsp" %>
    
    <% 

	request.setCharacterEncoding("UTF-8");
	int age = request.getParameter("age").isEmpty() ? 0 : Integer.parseInt(request.getParameter("age"));
    
    
	Map<String, String> map = new HashMap<>();
	
	if(age < 20){
		map.put("result1", "미성년자");
		map.put("result2", "불가능");
	} else {
		map.put("result1","성인");
		map.put("result2","가능");
	}
    request.setAttribute("map", map);   // -> requset 속성에 map추가 
	
	// forward (request를 그대로 전달한다.)
	// age는 request에 parameter로 들어 있고,
	// map은 request에 attribute로 들어 있다.
	request.getRequestDispatcher("Tquiz02C.jsp").forward(request, response);
	
	
	
    %>