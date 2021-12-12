<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/functions" prefix="f" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<style type="text/css">
	body{
		width: 900px;
		margin: 0 auto;
	}
	
	table {
		width : 800px;
		margin: 0 auto;
		text-align: center;
	}
</style>

</head>
<body>
	<h2>갤러리 목록</h2>
  
    <a href="/video/gallery/insertPage">새 갤러리 작성</a>
  <hr>
  
  <table border="1">
  	<thead>
  		<tr>
  			<td>번호</td>
  			<td>썸네일</td>
  			<td>제목</td>
  			<td>작성자</td>
  			<td>작성일</td>
  			<td>첨부다운로드</td>
  		</tr>
  	</thead>
  	<tbody>
  		<c:if test="${empty list}">
  			<tr><td colspan="6">갤러리가 없습니다</td></tr>
  		</c:if>
  		<c:if test="${not empty list }">
  			<c:forEach items="${list}" var="gallery">
  				<tr>
  					<td>${gallery.no}</td>
  					<td>
  					<c:set value="${gallery.saved}" var="video"></c:set>
  					<a href="/video/gallery/selectGalleryByNo?no=${gallery.no}">
		  				  <c:if test="${not f:contains(video, 'mp4')}">
		  						
		  						     <img alt="${gallery.origin}" src="/video/${gallery.path}/${gallery.saved}" width="400px">
		  					    
		  				</c:if>
		  				<c:if test ="${f:contains(video, 'mp4')}">
		  				<video autoplay controls loop muted poster="video" width="400px">
		  					<source src="/video/${gallery.path}/${gallery.saved}"  type="video/mp4">
		  				</video>
		  				</c:if>
		  			</a>
		  				
  					</td>
  					<td>${gallery.title}</td>
  					<td>${gallery.writer}</td>
  					<td>${gallery.created}</td>
  					<td><i class="fas fa-paperclip"></i></td>
  				</tr>
  			</c:forEach>
  		</c:if>
  	</tbody>
  </table>
  
  

</body>
</html>