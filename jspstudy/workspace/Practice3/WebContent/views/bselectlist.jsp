<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	 <link rel="stylesheet" type="text/css" href="css/bBoard.css">
	<script type="text/javascript">
		$(document).ready(function(){

			$('#insert_btn').on('click',function(){
				$('#title').focus();          // 글등록하기 누르면 글등록폼제목으로 포커스이동
			});
			
			$('#f1').on('submit',function(){   // f1서브밋 누르면 ajax실행
			  $.ajax({
				url : "/Practice3/insert.do",
				type : 'post',
				dataType: 'json',
				data : $('#f1').serialize(),
				success: function(resData) {
					alert("등록 성공 ");
				},
				error : function(xhr, ajaxOptions, thrownError) {
			        console.log(xhr.status);
			        console.log(thrownError);
				}
			}); // end of ajax
		}); // form
	}); // load

	</script>
</head>
<body>
	<h2 id="board">게시판</h2>
	
	<c:if test="${not empty id and not empty pwd}">
		<h3 id="user_id">${id}님 반갑습니다.</h3>
	</c:if>
	<form id="f" method="post"> 
	 	<span id="count" >게시물 수 : ${cnt}</span> 
		<table class="t1">
			<thead>
				<tr id="first_tr">
					<td>글번호</td>	
					<td>제목</td>
					<td>글쓴이</td>
					<td>카테고리</td>
					<td>조회수</td>
					<td>등록일</td>
				</tr>
			</thead>
			<tbody>
				<c:if test="${cnt eq 0}">
					<tr>
						<td colspan="5">게시물 없습니다.</td>
					</tr>
				</c:if>
				<c:if test="${cnt  gt 0}">
					<c:forEach var="board" items="${list}">
						<tr>
							<td>${board.idx}</td>	
						<!--<td><a id="a_link" href="/Practice3/select.do?idx=${board.idx}&readCount=${board.readCount+1}">${board.title}</a></td>  -->	
						<td><a id="a_link" href="/Practice3/select.do?idx=${board.idx}">${board.title}</a></td>
							<td>${board.writer}</td>
							<td>${board.category}</td>
				            <td>${board.readCount}</td>
							<td>${board.register}</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
			 <input type="button" value="글등록" id="insert_btn" id="insert_btn"><br>
	</form>
	
	<h2>새글등록</h2>
	<form id="f1"  method='post'>
		<table class="bInsert">
				<tr>
					<td>카테고리</td>
					<td id="td">
					
						<select name="category" id="category" >
							<option value="배송">배송</option>
							<option value="교환">교환</option>
							<option value="환불">환불</option>
							<option value="기타">기타</option>
						</select>
					</td>
				</tr>	
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" id="title"></td>
				</tr>	
				<tr>
					<td>글쓴이</td>
					<c:if test='${empty id and empty pwd}'>
						<td><input type="text" name="writer" ></td>
					</c:if>
					<c:if test="${not empty id and empty pwd}">
						<td><input type="text" name="writer" ></td>
					</c:if>
					<c:if test="${not empty id and not empty pwd}">
						<td><input type="text" name="writer" value="${id}" readonly></td>
					</c:if>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="content" cols="65" rows="14"> </textarea></td>
				</tr>
				<tr>
					<td colspan="3" class="btn_td">
					<!-- input인 경우엔 ajax에서 post설정만해도 주소창에정보가
					표시되지 않지만 폼-submit인 경우엔 폼에도 post처리를 해야한ㄷ. -->
						<button id="insert_btn">등록</button>
						<input  id="reset" type="reset" value="다시 작성">
						<input  id="go_login"  type="button" value="로그인하러 가기" onclick="location.href='index.jsp'">
					</td>
				</tr>
		</table>
	</form>
</body>
</html>