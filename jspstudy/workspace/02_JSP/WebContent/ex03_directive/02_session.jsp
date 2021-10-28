<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page session="true"  %>  <!--  session : 서버측저장소. 보안이 필요한 경우 사용함! 페이지가 이동해도 저장됨  -->

<%
	session.setAttribute("id", "admin");
	String id = (String)session.getAttribute("id");
%>

<script>
	let id = '<%=id%>';
	alert(id);

</script>