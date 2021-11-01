<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<style>
		label { display: block; }
	</style>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<%-- 디폴트 생성자로 만든 빈과 동일함 --%>
	<jsp:useBean id="p1" scope="page" class="ex07_bean.Book" ></jsp:useBean>
	
	
	<%-- setter 호출  p1에 있는 모든 속성 * 을 저장 --%>
	<jsp:setProperty property="*" name="p1" />
	
	<%-- getter 호출 --%>
	<h1>제목 : <jsp:getProperty property="title" name="p1"/></h1>
	<h1>저자 : <jsp:getProperty property="author" name="p1"/></h1>
	<h1>가격 : <jsp:getProperty property="price" name="p1"/></h1>
	
	<%-- useBean의 기본 scope로 pageContext가 되어있기 때문에 el을 사용할수 있다. --%>
	<h2>제목 : ${p1.title}</h2>
	<h2>저자 : ${p1.author}</h2>
	<h2>가격 : ${p1.price}</h2>
	
	
	<p>===특정 값으로 세팅한 bean===</p>
	<jsp:useBean id="p2" scope="page" class="ex07_bean.Book" ></jsp:useBean>
	<%-- 특정 값으로 세팅한 bean --%>
	<jsp:setProperty name="p2" property="title"  value="소나기" />
	<jsp:setProperty name="p2" property="author"  value="황순원" />
	<jsp:setProperty name="p2" property="price"  value="20000" />
	<h1>제목 : ${p2.title }</h1>
	<h1>저자 : ${p2.author }</h1>
	<h1>가격 : ${p2.price }</h1>
</body>
</html>










