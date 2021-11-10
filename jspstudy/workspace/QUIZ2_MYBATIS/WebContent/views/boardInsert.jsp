<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/Q_MYBATIS/boardInsert.do" method="post">
		<table border="1" style="width:300px">
			<tbody>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="writer"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea cols="30" rows="8" name="content"></textarea></td>
				</tr>
				<tr>
					<td colspan="2" >
					<button>등록</button>
					<input type="button" value="목록" onclick="location.href='/Q_MYBATIS/boardAllList.do'"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>