<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
	// 페이지 로드
	$(document).ready(function(){
		fnInit();
		fnFindAllMember();
		fnAddMember();
		fnFindMember();
		fnModifyMember();
		fnRemoveMember();
		fnChangePage();
	});
   
	// 입력 폼 초기화
	function fnInit(){
		$('#memberNo').val('');
		$('#id').val('').prop('readonly', false);
		$('#name').val('');
		$('#address').val('');
		$('input:radio[name="gender"]').prop('checked', false);
	}
	
	
	// 전체 회원 목록 + page 전역 변수 
	var page = 1;  // 시작은 무조건 1page
	function fnFindAllMember(){
		$.ajax({
			url: '/ex15/api/members/page/'+page,
			type: 'get',
			dataType: 'json',
			success : function(map){
				fnPrintMemberList(map);
				fnPringtPaging(map.pageUtils);
			}
		});
	} // fnFindAllMember()
	
	
	// 회원 목록 출력만 하는 함수 
	function fnPrintMemberList(map){
		$('#member_list').empty();   // 목록 초기화
		var p = map.pageUtils;       // 페이지 처리 모든 정보를 변수 p에 저장
		
		// 목록 만들기
		if( p.totalRecord == 0 ){
			$('<tr>')
			.append( $('<td colspan="5">').text('등록된 회원이 없습니다.')  )
			.appendTo('#member_list');
		} else {
		   $.each( map.list, function(i, member)  {
			   $('<tr>')
			   .append( $('<td>').text(member.id))
			   .append( $('<td>').text(member.name))
			   .append( $('<td>').text(member.gender))
			   .append( $('<td>').text(member.address))
			   .append( $( '<td>').html( $('<input type="hidden"  name="memberNo"  value="'+member.memberNo+'"><input type="button" value="조회" class="view_btn"> ')  ) )
			   .appendTo('#member_list');
		 });
		}  // 목록만들기 끝
		
	}  // end of fnPrintMemberList(map)
	
	
	
	// 페이징 출력 함수
	function fnPringtPaging(p){
		// 페이징 영역 초기화
		$('#paging').empty();  
		
		// 1페이지 이동 
		if(page == 1 ){
		    $('<div class="disable_link">&lt;&lt;</div>').appendTo('#paging');
		} else {
			$('<div class="enable_link"  data-page="1">&lt;&lt;</div>').appendTo('#paging');		
		}
		
		// 이전 블록으로 이동
		if(page <= p.pagePerBlock ){
			  $('<div class="disable_link">&lt;</div>').appendTo('#paging');
		} else {
			$('<div class="enable_link"  data-page="'+(p.beginPage-1)+'">&lt;</div>').appendTo('#paging');
		}
		
		
		
		// 페이지 번호 
		for(let i=p.beginPage; i<=p.endPage; i++){
			if(i == page ){
				 $('<div class="disable_link now_page">'+i+'</div>').appendTo('#paging');
			} else {
				$('<div class="enable_link"  data-page="'+i+'">'+i+'</div>').appendTo('#paging');
			}
		}
		
		
		
		
		// 다음 블록을 이동
		if( p.endPage == p.totalPage ){
			  $('<div class="disable_link">&gt;</div>').appendTo('#paging');
		} else {
			$('<div class="enable_link"  data-page="'+(p.endPage+1)+'">&gt;</div>').appendTo('#paging');
		}
		
		
		// 마지막 페이지로 이동
		if(page == p.totalPage ){
		    $('<div class="disable_link">&gt;&gt;</div>').appendTo('#paging');
		} else {
			$('<div class="enable_link"  data-page="'+p.totalPage+'">&gt;&gt;</div>').appendTo('#paging');		
		}
	} // end of Printpagin
	
	
	// 페이징 링크 처리 함수  ( 전역변수 page의 값을 바꾸고 fnFindAllMember() 함수를 호출 )
	function fnChangePage(){
		$('body').on('click', '.enable_link', function(){
			page = $(this).data('page');
			 fnFindAllMember();
		})
	} //  fnChangePage()
	
	
	
	// 멤버 등록하기
	function fnAddMember(){
		$('#insert_btn').click(function(){
			let member = JSON.stringify({                    // 자바스크립트 문자열을 제이슨으로 만드는 함수 stringify
				id : $('#id').val(), 
				name : $('#name').val(),
				gender: $('input:radio[name="gender"]:checked').val(),
				address: $('#address').val()
			});
			
			$.ajax({
				url : '/ex15/api/members',   // 목록과 똑같은 주소가... 대신 메소드가 달라진다.
				type : 'post',
				contentType: "application/json",
			    data : member,
			    dataType: 'json',
			    success : function(map){
			    	if(map.result > 0 ){
						alert('회원번호 '+map.memberNo+'인 회원이 등록되었습니다.');
						fnFindAllMember();
						fnInit();
			    	}
			    },
			    error: function(xhr){
					// 중복발생 에러
			    	if( xhr.status == 500){
						alert(xhr.responseText);			    	
			      } else if (xhr.status == 501) {
					    alert(xhr.responseText);
			       }
			    }
			}); // ajax
		});
	} // fnAddMember
	
	
	// 회원 조회 
	function fnFindMember(){
		$('body').on('click', '.view_btn', function(){            // 동적으로 만든 이벤트 버튼(view_btn)은 로드시 없기 때문에 생성 불가 때문에 원래부터 항상 있는 body를 이용하기!
			
		     
		$.ajax({
			url: '/ex15/api/members/'+$(this).prev().val(),    // url(경로)에 각 번호를 적었기 때문에 보내는 데이터는 없다.
			type: 'get',
			dataType: 'json',
			success: function(map){
				if (map.member != null ){
					$('#memberNo').val(map.member.memberNo);
					$('#id').val(map.member.id).prop('readonly', true);
					$('#name').val(map.member.name);
					$('#address').val(map.member.address);
					$('input:radio[name="gender"][value="'+map.member.gender+'"]').prop('checked', true);
				} else {
					alert($(this).prev().val()+'번 회원 정보가 없습니다.');
				}
			}
		});
                  // 버튼을 누른 이전 형제(hidden으로 no준 input태그)의 val()을 나타낸다.  == 각 회원의 조회번호
		});
	} // end of fnFindMember
	
	
	// 회원 정보 수정 함수
	function fnModifyMember(){
		$('#update_btn').click(function(){
			let member = JSON.stringify({                    // 자바스크립트 문자열을 제이슨으로 만드는 함수 stringify
				memberNo : $('#memberNo').val(),
				name : $('#name').val(),
				gender: $('input:radio[name="gender"]:checked').val(),
				address: $('#address').val()
			});
			
			$.ajax({
				url: '/ex15/api/members',   // 목록과 똑같은 주소가... 대신 메소드가 달라진다.(PUT)
				type: 'put',
				contentType: "application/json",
			    data : member,
			    dataType: 'json',
			    success : function(map){
			      if(map.result > 0 ){
			    	 alert("회원 정보가 수정되었습니다.")
			    	 fnFindAllMember();

			      } else {
			    	  alert('회원 정보가 수정되지 않았습니다.');
			      }
			    }
			}); // ajax	
		})
	} // end of fnModifyMember
	
	
	// 회원 삭제
	function fnRemoveMember(){
		$('#delete_btn').click(function(){
			if( confirm('삭제할까요?'))	{
				$.ajax({
					url:  '/ex15/api/members/' + $('#memberNo').val(),
					type: 'delete',
					dataType: 'json',
					success : function(map){
						if( map.result>0 ){
							alert('회원이 삭제되었습니다.');
							fnFindAllMember();
							fnInit();
						} else {
							alert('회원이 삭제되지 않았습니다.');
						}
			        }
				});
			}		
		});	
	 } // end of fnRemoveMember
</script>
<style type="text/css">
	#paging {
		display: flex;
		justify-content: center;
	}
	#paging > div {
		width: 20px;
		height: 20px;
		text-align: center;
	}
	.disable_link { color : lightgray;  }
	.enable_link { cursor:pointer;	 }
	.now_page { color: red; }
</style>


</head>
<body>
	<h1>회원 관리</h1>
	<div>
		<input type="hidden" name="memberNo" id="memberNo">
		아이디 <input type="text" name="id" id="id"><br>
		이름   <input type="text" name="name" id="name"><br>
		성별 
		<input type="radio" name="gender" id="male" value="남"><label for="male">남자</label>
		<input type="radio" name="gender" id="female" value="여"><label for="female">여자</label>	<br>
		주소   <input type="text" name="address" id="address"><br>
		
		<input type="button" value="초기화"  onclick="fnInit()">
		<input type="button" value="등록" id="insert_btn">
		<input type="button" value="수정" id="update_btn">
		<input type="button" value="삭제" id="delete_btn">
	</div>
	<hr>
	<table border="1">
		<thead>
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>성별</td>
				<td>주소</td>
				<td></td>
			</tr>
		</thead>
		<tbody id="member_list"></tbody>
		<tfoot>
			<tr>
				<td colspan="5" ><div id="paging"></div></td>
			</tr>
		</tfoot>
	</table>
</body>
</html>