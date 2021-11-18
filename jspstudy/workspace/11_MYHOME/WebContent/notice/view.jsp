<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Welcome</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<style>
		span {
			display: inline-block;
			width: 100px;
		}
	</style>
</head>
<body>
	<div>
	
		<span>게시글 번호</span> : ${notice.nNo}<br>  <!-- = requestScope.notice.nNo -->
		<span>작성자</span> : ${notice.writer}<br>
		<span>조회수</span> : ${notice.hit}<br>
		<span>IP</span> : ${notice.ip}<br>
		<span>작성일</span> : ${notice.nDate}<br>
		<span>최종수정일</span> : ${notice.nLastModified}<br>
		<span>제목</span> : ${notice.title}<br>
		내용<br>
		<pre>${notice.content}</pre>
		<br>

	<!--  
		목록 : 누구나 
		수정. 삭제 : 작성자만
	 -->
		<input type="button" value="목록" onclick="location.href='list.notice'">
		<c:if test="${notice.writer == loginUser.id}">		
			<input type="button" value="수정" onclick="location.href='updateForm.notice'">
			<input type="button" value="삭제" onclick="fnNoticeDelete()">
		</c:if>

		
		<script>
			function fnNoticeDelete(){
				if(confirm('게시글을 삭제할까요?')){
					location.href='delete.notice?nNo=${notice.nNo}';
				}
			}
		</script>
		
		<hr>
		<!--  게시글에 댓글을 다는 작업이므로 insert reply이다. 해당 댓글내용이외에 댓글을 다는 게시판 번호가 함께 전달되어야한다. -->
	<!-- 
		작성자 : 로그인 유저 아이디
		댓글달기 : 로그인 유저만 오픈
	 -->
		<form action="insert.reply" method="post">
			<label for="writer">작성자</label>
			<input name="writer" id="writer" value="${loginUser.id}" readonly><br>
			<textarea rows="5" cols="30" name="content" id="content"></textarea><br>
			<input type="hidden" name="nNo" value="${notice.nNo}">
			<c:if test="${loginUser != null}">			
				<button>댓글달기</button>
			</c:if>
		</form>
		
		<hr>
		
		<!--  있는 댓글 리스트 -->
		<div>
			<c:if test="${empty replyList}">
				첫 댓글의 주인공이 되어 보자
			</c:if>
			<c:if test="${not empty replyList}">
				<c:forEach items="${replyList}" var="reply">
					${reply.writer}&nbsp;&nbsp;
					${reply.ip}&nbsp;&nbsp;
					${reply.rDate}<br>
					<pre>${reply.content}</pre>				
				</c:forEach>
			</c:if>
		</div>
		
	</div>
	
</body>
</html>