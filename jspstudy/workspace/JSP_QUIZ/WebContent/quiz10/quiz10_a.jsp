<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.Date" %>
<%@page import="quiz10.Board"%>
<%@page import="java.time.LocalDate"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");	
   		
		// 날짜 함수 외우기...
   		Date date = Date.valueOf(LocalDate.now());
   		 	    	
    	List<Board> board = new ArrayList<>();
    	// 위에서 정의한 필드 넣기 
    	board.add(new Board(title, writer, content, date));
    	pageContext.setAttribute("board", board);
	
	
	%>
		<c:forEach var="board" items="${board}" varStatus="k">
   		  제목 : ${board.title}<br>
   		  작성 : ${board.writer}<br>
   		  내용 : ${board.content}<br>
   		  게시 : ${board.date}
     	</c:forEach>
     	
     	
     	<%--
     		디폴트 생성자 만들고  값을 지정하는 방법도 있음..
	        Board board = new Board();
			board.setTitle(request.getParameter("title"));
			board.setWriter(request.getParameter("writer"));
			board.setContent(request.getParameter("content"));
			board.setDate(new Date(System.currentTimeMillis()));
		
     	 --%>
     	
     	
     	
     	
     	
     	
     	
     
	
</body>
</html>