<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
   // 페이지 로드
	$(document).ready(function(){
		fnFindAllMovie();
		fnFindMovie();
	});
   
   
   
   
   // 입력 폼 초기화 함수
   function fnInit(){
	   $('#query').val(''); 
	   fnFindAllMovie();
   }
   
   
   // 전체 도서 목록 가져오는 함수
   function fnFindAllMovie(){
		$.ajax ({
			url: '/integration1/movie/findAllMovie',
			type: 'get',
			dataType: 'json', // 받아오는 데이터타입
			success: function(map){
				$('#movie_list').empty();
					alert(map.message);
				if( map.status == 200){
					let result = '';
					$.each(map.list, function(i, movie) {
						 result += 	'<tr><td class="mTitle">' + movie.title + '</td><td class="mContent">' + movie.content + '</td><td>'+  movie.regDate + '</td></tr>';
					});
					$('#movie_list').html(result);
				}
			},
			error: function(xhr){		
			}		
		});  // ajax
   } // fnFindAllMovie
  
   
   //검색 함수
   function fnFindMovie(){
	   $('#search_btn').click(function(){
		  $.ajax({
				url : '/integration1/movie/findMovie',
				type: 'get',   					             
			//	contentType: 'application/json',    // 보내는 타입
				data: 'column='+ $('#column').val() + '&query='+ $('#query').val(),
				dataType: 'json',
				success: function(map){
					$('#movie_list').empty();
					let result = '';
				if( map.status == 200){
					alert(map.message);
					$.each(map.list, function(i, movie) {
					 result += 	'<tr><td class="mTitle">' + movie.title + '</td><td class="mContent">' + movie.content + '</td><td>'+  movie.regDate + '</td></tr>';
					});
					$('#movie_list').html(result);
				  } else if (map.status == 500){
					  alert(map.message);
					  result += 	'<tr><td colspan="3">검색결과 없음<//td></tr>';
					  $('#movie_list').html(result);
				  }
				},
				error: function(xhr){
				
				}
		  }) // ajax 
	   });
   }  // fnFindMovie
   
</script>
<style>
	.mContent {
		width: 400px;
		overflow:hidden;
	}
	.mTitle { width : 100px; }
</style>

</head>
<body>
   <div>
   		<select name="column" id="column">
   			<option value="TITLE">제목</option>
   			<option value="CONTENT">개요</option>
   		</select>
        <input type="text" name="query" id="query">
        <input type="button" value="검색" id="search_btn">
         <input type="button" value="초기화" onclick="fnInit()">    
   </div>
  <br><hr>
   <table border="1">
   		<thead>
	   		<tr>
	   			<th class="mTitle">제목</th>
	   			<th class="mContent">내용</th>
	   			<th>작성일</th>
	   		</tr>
	   	</thead>
	   	<tbody id="movie_list">
	   	    
	   	</tbody>
   </table>
</body>
</html>