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
			String[][] sites = {
				{"구글", "https://www.google.com"},
				{"네이버", "https://www.naver.com"},
				{"다음", "https://www.daum.net"},
				{"네이트", "https://www.nate.com"}				
			};
	%>
		<form action="Tquiz01B.jsp">
		사이트명: 
		<select name="site">
		             <!--  
		             sites.length = 4//  sites[].length = 2;
		             속성으로 이동해야하므로 value에 사이트 인덱스지정하기 
		             --> 
			<% for(int i=0; i<sites.length; i++){ %>
				<option value="<%=sites[i][1]%>"><%=sites[i][0]%></option>
			<% } %>
		</select>
		<button>확인</button>
	</form>
	
	
	
	
</body>
</html>