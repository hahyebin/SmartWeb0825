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
		request.setCharacterEncoding("UTF-8");
		String strAge = request.getParameter("userAge");
		int age = strAge.isEmpty() ? 0 : Integer.parseInt(strAge);
	
		String result = "";
		String pass = "";
		
		if(age<20){
			result = "미성년자";
			pass = "불가능합니다.";
		} else { 
			result = "성인";
			pass = "가능합니다.";
		}
		
		pageContext.setAttribute("age",age);
		pageContext.setAttribute("result", result);
		pageContext.setAttribute("pass", pass);
	%>
	
	
	<h1>${result}</h1>
	<p>당신의 나이는 ${age }살이므로 주류 구매가 ${pass}</p>
	<a href="quiz02.jsp">처음으로 이동</a>
	
	
	
</body>
</html>