<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/Q_MYBATIS/insertForm.do">
     	 <p>총 게시글 : 
				${count}개
			<table border="1">
				<thead>
					<tr>
						<td>순번</td>
						<td>작성자</td>
						<td>제목</td>
						<td>작성일</td>
					</tr>
				</thead>
				<tbody>
						<c:choose>
							<c:when test="${empty boards}">    
								<tr>
									<td colspan="4" >게시물이 없습니다.</td>
								</tr>
							</c:when>
							 <c:otherwise>
								<c:forEach var="board" items="${boards}">
									<tr>
											<td>${board.idx}</td>
											<td>${board.writer}</td>
											<td><a href="/Q_MYBATIS/boardOneList.do?idx=${board.idx}">${board.title}</a></td>    <!--  상세정보 보기로 -->
											<td>${board.register}</td>
									</tr>
								</c:forEach>
							</c:otherwise>	
						</c:choose>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="4"><button >새글작성</button></td>
					</tr>
				</tfoot>
			</table>		
		</form>
</body>
</html>