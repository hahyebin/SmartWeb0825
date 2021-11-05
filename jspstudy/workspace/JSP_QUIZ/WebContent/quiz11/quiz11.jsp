<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	caption { font-weight:bold;}
	table { border-collapse: collapse;}
	tr td:nth-of-type(1) { background-color : beige;}
	td { border:1px solid black; }
	tr td:nth-of-type(2) { width : 250px;}
	#submit{
	background-color:white;
	text-align:center;
	}
	input[type="text"] { width: 100px;}

</style>
</head>
<body>
	<form action="quiz11_a.jsp">
	
	<table >
		<caption>개인정보처리</caption>
		<tr>
			<td class="info">성명</td>
			<td><input type="text" name="userName"></td>
		</tr>
		<tr>
			<td class="info">나이</td>
			<td><input type="text" name="userAge"></td>
		</tr>
		<tr>
			<td class="info">성별</td>
			<td>
				<input type="radio" name="userGender" value="남">남
				<input type="radio" name="userGender" value="여">여
			</td>
		</tr>
			<tr>
			<td class="info">취미</td>
			<td>
				<input type="checkbox" name="hobby" value="운동">운동
				<input type="checkbox" name="hobby" value="여행">여행
				<input type="checkbox" name="hobby" value="영화">영화
				<input type="checkbox" name="hobby" value="휴식">휴식
			</td>
		</tr>
			<tr>
			<td class="info">주소</td>
			<td>
				<select name="addr">
					<option value="서울">서울</option>
					<option value="인천">인천</option>
					<option value="경기">경기</option>
				</select>
			</td>
		</tr>
			<tr>
			<td class="info">좋아하는음식</td>
			<td>
				<select name="food" multiple>
					<option value="짜장">짜장</option>
					<option value="짬뽕">짬뽕</option>
					<option value="볶음밥">볶음밥</option>
					<option value="탕수육">탕수육</option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2" id="submit">
			<button>전송</button>
			</td>
		</tr>
	</table>	
	</form>
	
	<%
	
	request.setCharacterEncoding("utf-8");
	
	%>


</body>
</html>