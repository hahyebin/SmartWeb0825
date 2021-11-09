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
		<form method="post" action="/QUIZ2/insertForm.board">
     	 <p>총 게시글 : 
			<c:choose>
				<c:when test="${empty boardList}">0</c:when>
				 <c:otherwise>
				 	<c:forEach var="boardList" items="${boardList}" varStatus="v">
							<c:set var="count" value="${v.count}" />
			       </c:forEach>	
			       ${count}
				 </c:otherwise>
			</c:choose>개</p>
				
			
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
							<c:when test="${empty boardList}">    
								<tr>
									<td colspan="4" >게시물이 없습니다.</td>
								</tr>
							</c:when>
							 <c:otherwise>
								<c:forEach var="boardList" items="${boardList}">
									<tr>
											<td>${boardList.idx}</td>
											<td>${boardList.writer}</td>
											<td><a href="/QUIZ2/seleteDTO.board?idx=${boardList.idx}">${boardList.title}</a></td>    <!--  상세정보 보기로 -->
											<td>${boardList.register}</td>
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