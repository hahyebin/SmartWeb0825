<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!--  HTML 주석 : 소스보기가 가능하다. -->
<%--  JSP 주석  : 소스보기에서 안 보인다. --%>
  
<%--

     1. JSP
     	1) Java Server Page
     	2) HTML 내부에 Java 코드를 넣을 수 있다.
     	3) Servlet 기반이다.
     		(1) 실행을 하면 JSP는 Servlet으로 변환된다.
     		(2) abc.jsp  ->  abc_jsp.java
     		    JSP            Servlet
     2. JSP 스크립트 요소 
         1) <%@  %> : 지시어(directive)
           (1) <%@ page %>
           (2) <%@ include %>
           (3) <%@ taglib %>
         2) 주석
         3) <%!  %> : 선언부(declaration)
         	(1) 메소드 정의                           --> 메서드를 만들기만 하지 호출은 하지 않는다!! 호출은 일반 자바코드에서 하는거
         	(2) 전역 변수를 선언해 두는 곳
         4) <%=  %> : 표현식(expression)              --> 결과값 나옴 
         	(1) 변수 값 
         	(2) 연산 결과 
         	(3) 메소드 호출                           --> 코드가 아니라 메소드 한개일때만 가능 (변수명에 값을 저장하는 류의 식을 넣으면 안됨)
         5) <%   %> : 스크립트릿(scriptlet)
      		일반 Java 코드   	                     --> 호출은 되지만 값이 출력되지는 않음 값을 확인하고 싶으면 표현식 활용 
      		       
 --%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- 인수 2개 사이 모두 정수의 합을 반환하는 getSum() 메소드 정의 --%>
	<%! 
		// 여기는 선언부 
		public long getSum(long a, long b){
			if( a > b){
				long tmp; 		
			 	tmp = a;
			 	a = b;
			 	b = tmp;
			 	}
			long sum = 0;
			for(long n=a; n<=b; n++){
				sum+=n;
			}
			return sum;
		}
	%>
	
	<%
		// 여기는 스크립트릿(일반 자바 코드)
		long result = getSum(1,10);	
	%>
	<h1>1부터 10사이 모든 정수의 합은 -> <%= result %></h1> 		<!--  결과값 -->
	<h1>1부터 10사이 모든 정수의 합은 -> <%= getSum(1, 100) %></h1> <!--  메소드호출 -->
	<h1>1부터 10사이 모든 정수의 합은 -> <%= 1+100 %></h1>			<!--  연산 -->
	
	
	<%-- 1~5 화면에 출력하기 --%>
	
	<% 
	for(int a=1; a<=5; a++) {	%>
	<h1>1~5 화면에 출력하기 <%= a %></h1>
	<% } %>

</body>
</html>