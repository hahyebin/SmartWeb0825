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
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.css" integrity="sha512-4wfcoXlib1Aq0mUtsLLM74SZtmB73VHTafZAvxIp/Wk9u1PpIsrfmTvK0+yKetghCL8SHlZbMyEcV8Z21v42UQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<style>
	  *{
		padding:0;
		margin:0;
		box-sizing: border-box;
		}
	  header {
		width: 700px;
		text-align : center;
		margin: 40px auto;
	}
	  h1 { text-align : center; }
	  a{
	  	text-decoration: none;
	  	color: black;
	  }
	  a:hover{   font-weight: bold;  }
	  .reply_link{
	  	   font-size: 8px;
	  	    color : crimson;
	  }
	  .reply_link:hover{	cursor:pointer;     }
	  .reply_form {	display:none; }
	  table { 
	  	width : 600px; 
	  	border-collapse: collapse;
	  	margin: 0 auto;
	  }
	  #insertFrom_wrap {
	  	width: 600px;
		text-align : left;
		margin: 0 auto;
	   }
	  .totalrecord {
	  	display : block;
	  	width:600px;
	  	text-align : right;
	  	margin: 0 auto;
	  }
	  main {
	  	width : 900px;
	  	margin: 20px auto;
	  }
	  table tr td:last-of-type {
	   text-align:center;
	}
	#search_wrap {
		width: 600px;
		text-align : left;
		margin: 20px auto;
	}
	
	 
	</style>
	<script>
		$(document).ready(function(){
			$('.reply_link').on('click',function(){
				$(this).parents('tr').next().toggleClass('reply_form');
				// this누르면 this기준의 부모들 중 tr의 다음형제에 reply_form class를 넣고 빼기를 반복한다.
			})
		}); // load
	</script>

</head>
<body>

	<header>
		<h1><a href="index.jsp">WEB PAGE TITLE</a></h1>
	</header>
	<hr>
   <main>
   
	
   
	<!-- 작성 링크 -->
	<div id="insertFrom_wrap">
		<c:if test="${loginUser != null }">
			<a href="insertForm.free">새글작성</a>
		</c:if>
	</div>
	
	

	
	<!-- 목록 -->
	<span class="totalrecord">전체 게시글 : ${totalRecord}개</span><br>
	<table border="1">
		<thead>
			<tr>
				<td width="50">번호</td>
				<td width="100">작성자</td>
				<td width="250">내용</td>
				<td width="50">조회수</td>
				<td width="100">최종수정일</td>
				<td width="50"></td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="6">게시글이 없습니다.</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach var="free" items="${list}">
					 <c:if test="${free.state == 0}">
							<tr>
								<td>${free.fNo}</td>
								<td>${free.writer}</td>
								<td>
										<!--  depth만큼 들여쓰기  -->
										<c:forEach begin="1" end="${free.depth}" >
											&nbsp;&nbsp;
										</c:forEach>
										<!--  댓글(depth 1이상) [re] -->
										<c:if test="${free.depth >= 1}">
										   ㄴ&nbsp;
										</c:if>
									<!--  20자 이내는 그대로 표시 -->
									<c:if test="${free.content.length() < 20 }">
										<a href="view.free?fNo=${free.fNo}">${free.content}</a>&nbsp;&nbsp;&nbsp;
									</c:if>
									<!--  20자 이상은 20자까지 표시 -->
									<c:if test="${free.content.length() >= 20 }">
										<a href="view.free?fNo=${free.fNo}">${free.content.substring(0,20)}</a>&nbsp;&nbsp;&nbsp;
									</c:if>		
										<a class="reply_link">댓글 달기</a>
								</td>
								<td>${free.hit}</td>
								<td>${free.lastModified}</td>
								<td>
									<c:if test="${ loginUser.id == free.writer }">
										<a href="delete.free?fNo=${free.fNo}"  onclick="fnDelete(this)"><i class="far fa-times-circle"></i></a>
											<script type="text/javascript">
												function fnDelete(a) {
													$(a).on('click',function(event){
														if( confirm('삭제할까요?') == false){
															event.preventDefault();
															return false;
														}
														return true;
													})
												}
											</script>
									</c:if>
								</td>
							</tr>
							<tr class="reply_form">
								<td colspan="6">
									<form action="insertReply.free" method="post">
									 <!--  원글의 DEPTH, GROUPNO, GROUPORD를 넘겨줌 -->
										<input type="hidden" name="depth" value="${free.depth}">
										<input type="hidden" name="groupNo" value="${free.groupNo}">
										<input type="hidden" name="groupOrd" value="${free.groupOrd}">
										<input type="text" name="writer" value="${loginUser.id}" readonly>
										<input type="text" name="content"  placeholder="내용">
										<button>댓글달기</button>
									</form>
								</td>
							</tr>
					   </c:if>
					
					 <c:if test="${free.state == -1}">
						<tr>
							<td>${free.fNo}</td>
							<td colspan="5">삭제된 게시글입니다.</td>
						</tr>
					</c:if>
				</c:forEach>
			</c:if>
		</tbody>
		<tfoot>
			<tr style="text-align:center">
<!-- 화면에 삭제된 게시글 칸이 있으면 페이징 처리를 위해 삭제된 게시글이라도 총 게시글물 수에 포함된다.
 하지만 칸이 아예없다면 게시글 수도 조정해야한다. 현재 예제는 칸이 있는 방법(댓글처리위해)이기 때문에 총게시물수는 그대로다 -->
				<td colspan="6">    
					<!-- 첫 페이지로 이동 : 1페이지는 링크가 필요없다. -->
					<c:if test="${p.page == 1 }">
						◀◀&nbsp;&nbsp;  <!-- 첫 페이지일때 링크 필요없다. -->
					</c:if>
					<!-- 첫 페이지가 아닐때는 클릭하면 첫번째 페이지로 이동 -->
					<c:if test="${p.page != 1}">
						<a href="find.free?column=${column}&query=${query}&page=1">◀◀</a>&nbsp;&nbsp;
					</c:if>
					
					<!--  이전 블록으로 이동 : 1블록은 링크가 필요 없다.  -->
					<c:if test="${p.page <= p.pagePerBlock}">
						◀&nbsp;&nbsp;
					</c:if>
					<!--  이전 블록으로 이동 : 2블록부터는 링크가 필요하다.  -->
					<c:if test="${p.page > p.pagePerBlock}">
						<a href="find.free?column=${column}&query=${query}&page=${p.beginPage-1}">◀</a>&nbsp;&nbsp;
					</c:if>
					
					<!--  페이지 번호 : 현재 페이지는 링크가 필요 없다. -->
					<c:forEach var="i" begin="${p.beginPage}" end="${p.endPage}">
						<c:if test="${p.page == i}">
							${i}					
						</c:if>
						<c:if test="${p.page != i}">
							<a href="find.free?column=${column}&query=${query}&page=${i}">${i}</a>					
						</c:if>
					</c:forEach>
					
					
					<!--  다음 블록으로 이동 : 마지막 블록은 링크가 필요 없다. -->
					<c:if test="${p.endPage == p.totalPage}">
						&nbsp;&nbsp;▶
					</c:if>
					<c:if test="${p.endPage != p.totalPage}">
						&nbsp;&nbsp;<a href="find.free?column=${column}&query=${query}&page=${p.endPage+1 }">▶</a>
					</c:if>
					
					<!-- 마지막 페이지로 이동 : 마지막 페이지는 링크가 필요 없다. -->
					<c:if test="${p.page == p.totalPage}">
						&nbsp;&nbsp;▶▶
					</c:if>
					<c:if test="${p.page != p.totalPage}">
						&nbsp;&nbsp;<a href="find.free?column=${column}&query=${query}&page=${p.totalPage}">▶▶</a>
					</c:if>
					
											
				</td>
			</tr>
		</tfoot>
	</table>
	
	
	<!-- 검색란 -->
   	<div id="search_wrap">
		<form action="find.free" >
		<!-- ********** option의 value를 DB칼럼명으로 직접 사용함. **********-->
			<select name="column">
				<option value="WRITER">작성자</option>
				<option value="CONTENT">내용</option>
				<option value="ALL">작성자+내용</option>
			</select>
			<input type="text" name="query" style="width:300px">
			<button>검색</button>
			<input type="button"  value="전체보기" onclick="location.href='list.free'">
		</form>
	</div>	
		
	
	
	
	
	</main>
</body>
</html>