<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			// 각 함수 호출하기
			fnSelectProductList();
			fnInsertProduct();
			fnNameCheck();
			fnPrevInsertName();
			fnDeleteProdcuct();
		
		}); // load
		
		function fnDeleteProdcuct(){
			// load할 때는 .delete_btn이 없기 때문에 인식하지 못해서 버튼 이벤트가 작동되지않아서 'body'를 통해 on에 이벤트대상을 넣어 작동시키게한ㄷㅏ.
			$('body').on('click', '.delete_btn',function(){
			  let delete_pno=  $(this).data('pno')   // 클릭 - 삭제될 상품의 번호!
			  if ( confirm('제품번호 ' + delete_pno + ' 제품을 삭제할까요?') ){
				  $.ajax({
					url : "/AJAX/delete.do",
					type : 'get',
					data : 'pno=' + delete_pno,   // 서버로 보내는 데이터, 파라미터 pno로 보냄 
					dataType:'json',
					success : function(resData){
						if( resData.result > 0){
							alert('삭제완료');
							fnSelectProductList();   // 삭제 완료 후 다시 리스트를 봐야 하므로 재호출하기
						} else{
							alert('삭제실패1');      // 삭제할 회원번호 없음 
						}
					},
					error : function(){
						alert('삭제 실패2');         // 코드 수정 필요
					}		
				  }) // ajax
			  } // if문
		   });	
		}
		// 목록을 가지고 와서(보내는게 없음 즉 data가 없음@!!!!) 본문에 추가하기
		function fnSelectProductList(){
			$.ajax({
				url : "/AJAX/selectList.do",   // 목록 맵핑
				type: 'get',
				// data: 없음 (서버로 보내는 데이터)
				dataType : 'json',             // 받아오는 데이터의 타입
				success : function(resData) {  // resData에 SelectListService의 반환 값 arr 저장
					// 제품 목록 초기화(똑같은 제품 중복 입력 방지)
					$("#product_list").empty();
				 	// 제품 목록 만들기 
					if( resData.length == 0 ){
						$('<tr>')
						.append( $('<td colspan="5">').text('등록된 제품이 없습니다.') )
						.appendTo("#product_list");
					} else {
						for( let i =0; i < resData.length; i++){
							$('<tr>')
							.append( $('<td>').text(resData[i].pno) )
							.append( $('<td>').text(resData[i].name) )
							.append( $('<td>').text(resData[i].price) )
						    .append( $('<td>').text(resData[i].made) )
						    .append( $('<td>').html('<input type="button" value="삭제" class="delete_btn" data-pno="'+resData[i].pno +'" >') )
						    .appendTo('#product_list');
						}
					}
				},
				error : function(){
					alert('제품 목록 가져오기 실패');
				}
			}); // ajax
		} // fnSelectProductList
	
		function fnInsertProduct(){
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
							fnSelectProductList();   //★★★★★★★★★★★★★★★★★★★★★★★★★★ fnSelectProductList() 갖고오면 새 상품 로드해줌....★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
						}
					},
					error : function(){
						alert('제품 등록 실패');   // 다음 시간엔 에러메시지 작성하는 법 배울예정!->활용(+예외)
					}
				}); // end of ajax
			}); // insert_btn		
		} //fnInsertProduct
		
		
		// ㅈㅔ품명 중복 체크
		function fnNameCheck(){
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
		}
		// 마지막 등록 제품명 확인
		function fnPrevInsertName(){
			// 마지막 등록 제품명 확인
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
		}
	
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
	
	<hr>
	
	<table border="1">
		<thead>
			<tr>
				<td>제품번호</td>
				<td>제품명</td>
				<td>제품가격</td>
				<td>제조일자</td>
				<td>버튼</td>
			</tr>
		</thead>
		<tbody id="product_list">
		
		</tbody>
	</table>
	
</body>
</html>