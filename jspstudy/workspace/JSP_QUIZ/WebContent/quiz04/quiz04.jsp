<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	input{
		border:none;
		width:10px;
		outline:none;
	}
</style>
<title>Insert title here</title>
</head>
<%
	int a = (int)(Math.random()*9)+1;
	int b = (int)(Math.random()*9)+1;
	
	String[] arr = {"+","-","*","/","%"};
	String str = "";
	int random = (int)(Math.random()*arr.length);
	
	
%>


<body>
   <form action="quiz04_a.jsp">
   <h3>랜덤 계산기</h3>
   	<input type="text" name ="a" value="<%=a%>">
   	<input type="text" name ="arrRandom" value="<%=arr[random] %>">  	
    <input type="text" name ="b" value="<%=b%>"> 
   	=<input type="text" name="result" style="width:60px; border:1px solid black; outline:1px solid black;">
   	<button>제출</button>
   
   </form>
</body>
</html>