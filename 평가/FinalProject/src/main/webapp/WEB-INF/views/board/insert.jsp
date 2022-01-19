<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fnAdd(f) {
		f.action = '${pageContext.request.contextPath}/board/add';
		f.submit();
	}
</script>
</head>
<body>

	<form method="post">
		<table border="1">
			<tbody>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="bWriter" autofocus /></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="bTitle" /></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows="10" cols="50" name="bContent"></textarea></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="등록" onclick="fnAdd(this.form)" />
						<input type="button" value="목록" onclick="location.href='${pageContext.request.contextPath}/board/list'"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>

</body>
</html>