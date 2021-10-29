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
</head>
<body>
	<%-- pageContext에 속성 저장하기  --%>
	<% 
		pageContext.setAttribute("name", "하혜빈");
		pageContext.setAttribute("age", 26);
	%>
	<%-- 표현식으로 속성 사용 --%>
	<div><%=pageContext.getAttribute("name") %></div>
	<div><%=pageContext.getAttribute("age") %></div>
	<br>
	<%-- pageContext 속성 꺼내기  -> 그냥 사용 말고 꺼내서 변수에 저장하고 싶을때는 꼭 캐스팅! --%>
	 <%
		String name2 = (String)pageContext.getAttribute("name");
		int age2 = (Integer)pageContext.getAttribute("age");
	%>
	<%-- 변수 name, age 사용하기 --%>
	<div>나는 <%=name2.charAt(0) %>씨다.</div>
	<div>내년엔 <%=age2+1 %>살이 된다.</div>
	<br>
	
	<%-- pageContext에 속성을 저장해 두는 이유 : EL로 활용하기 위해서  --%>
	<div>${name}</div>
	<div>${age}</div>
	<%-- 일반 자바 변수는 EL로 인식 안됨! --%>
	<div>${name2}</div> 
	<div>${age2}</div>
	



</body>
</html>




