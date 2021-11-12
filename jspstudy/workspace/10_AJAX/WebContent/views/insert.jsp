<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>제품목록</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<style>
		 label {  display : block; }
	</style>
	<script>
		$(document).ready(function(){
			// ㅈㅔ품명 중복 체크
			$("#name").on("blur", function(){
				
				$.ajax({
					url: '/AJAX/nameCheck.do',
				   type: 'get',
				   data: 'name=' + $(this).val(),
				   dataType : 'json',                 // 응답하는 쪽은 JSON데이터를 반환해야하기 때문에 그곳에서는 application/json으로 contextPath 다시 설정하기 (text/htmlxxxxxxxxxx)
				   success: function(resData){         // 응답하는쪽에선 obj매개변수로 넘겨줌 
					//  console.log(resData);
					  if(resData.result == false){   
						  alert('동일한 제품이 있습니다.');
					  }
				   },
					error: function () {
						alert('제품명 중복 체크 실패');
					}
					
				});
			});
			
			// 제품 등록 
			$("#insert_btn").on('click', function(){
				
				$.ajax({
					url : '/AJAX/insert.do',
					type : 'post',
			//		data : 'name='+ $('#name').val() + '&price=' + $('#price').val(),    방법1. &로 받기
					data : $('#f').serialize(),  // 폼의 모든 요소를 파라미터로 넘김 
					dataType : 'json',
					success : function(resData){   // resData ======= obj 
						if( resData.result > 0){
							alert('제품 등록 성공');              // DB는 DB데로 저장하면서 페이지 이동은 안하면서 계속 등록할 수 있는 장점이 있는게 ajax이다.
							$('#name').val('');
							$('#price').val('');
						}
					},
					error : function(){
						alert('제품 등록 실패');   // 다음 시간엔 에러메시지 작성하는 법 배울예정!->활용(+예외)
					}
		
				}); // end of ajax
			});
			
		 $('#name_btn').on('click',function(){
			$.ajax({
				url : '/AJAX/prevInsertName.do',
				type: 'get',
			    dataType: 'json',
			    success: function(resData){
			    	alert(resData.name);  // 마지막 제품 나오는 알럿 만들기	
			    },
			    error: function(){
			    	alert('확인 실패')
			    }
			    
			});  // end of ajax
		 });

			
		});  // end of ready
	</script>

</head>
<body>
	
	<div>
		<h1>제품 등록 화면</h1>
		<form id="f" >
			<label for="name">제품명</label>
			<input type="text" name="name" id="name">
			<input type="button" id="name_btn" value="마지막 등록 제품명 확인">
			<label for="price">제품가격</label>
			<input type="text" name="price" id="price">
			<br><br>
			<input type="button" value="제품등록" id="insert_btn">
		</form> 
	</div>

	
</body>
</html>