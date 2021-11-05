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

	<%
		request.setCharacterEncoding("utf-8");
	
		String strA = request.getParameter("a");
		String strB =request.getParameter("b");
		//연산자 
		String arrOp =request.getParameter("arrRandom");
		//결과로 받은 값 
		String strResult = request.getParameter("result");
		
		String answer = "";
		String result2 = "";
		int a = strA.isEmpty() ? 0 : Integer.parseInt(strA);
		int b = strB.isEmpty() ? 0 : Integer.parseInt(strB);
	
		switch(arrOp){
			case "+":
			  result2 =  (a + b)+"";
			case "-":
				 result2 = (a-b)+"";
			case "/":
				 result2 = (a/b)+"";
			case "*":
				 result2 = (a*b)+"";
			case "%":
				 result2 = (a%b)+"";
		}
	    // 문장으로 응답 보내야하기 때문에 result2를 finalResult에 저장 
		String finalResult = result2;
				
		if( strResult.equals(result2)){
			answer = "정답입니다";	
		} else { 
			answer = "정답 : " + a +arrOp+b+" = "+ finalResult;
		}
				
		
	%>
        제출 : <%=strA %><%=arrOp %><%=strB %> = <%=strResult %><br>
   		<%=answer %>	<br>
		<a href="quiz04.jsp">다시풀기</a>
</body>
</html>