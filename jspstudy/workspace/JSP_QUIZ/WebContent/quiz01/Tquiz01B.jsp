<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String site = request.getParameter("site");


response.sendRedirect(site);
// forward의 경우엔 url이 변경되지 않음. 
// 1. Tquiz01A에서 -> B로 요청 
// 2. B -> 각 사이트로 forward 한 경우는 서버간의 이동이므로 A에는 변화가 없음.. url이동 xx 

// 그렇기 때문에 클라이언트 측에서도 url이동이 가능한 sendredirect를 사용해야함 
%>