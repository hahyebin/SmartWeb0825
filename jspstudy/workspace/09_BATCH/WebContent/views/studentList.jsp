<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<style>
		.wrap {
			width:800px;
			margin: 0 auto;
		}
		h1 {
			text-align: center;
			color: gray;
		}
		.btn_area {
			width:800px;
			height: 60px;
			text-align: right;
			line-height: 60px;
			
		}
		#insert_btn {
			width: 150px;
			height: 35px;
			background-color: lightgrey;
			border: 0;
			outline: 0;
			font-size: 15px;
			text-align: center;	
		}
		#insert_btn:hover{
			cursor: pointer;
			background-color: darkgrey;
		}
		table { 
		    width:100% ;
		    border-collapse: collapse; 
		  }
		caption {
			margin-bottom: 10px;
		}
		td {
			border-top: 1px solid grey;
			border-bottom: 1px solid grey;
			text-align: center;
			padding: 3px 5px;
		}
		
	</style>
</head>
<script>
	$(document).ready(function(){  //id가 2개 이상일 때는 이벤트는 한번만 인식!!!!! 그렇기 때문에 for문안에 있는 id는 지양..해서 이벤트 등록하기
	
		$('.update_btn').on('click', function(){
			let sno = $(this).prev().val();
			location.href = '/BATCH/studentDetail.do?sno='+sno;
		});
		

		$('.delete_btn').on('click',function(){
			if ( confirm('삭제할까요?')){
				location.href = '/BATCH/deleteStudent.do?sno='+ $(this).data('sno');
			}	
		});
	
	})

</script>
<body>
	
	<div class="wrap">
		<h1>학생 전체 목록</h1>
			<div class="btn_area">
				<button id="insert_btn" onclick="location.href='/BATCH/insertForm.do' ">학생 등록하기</button>
			</div>
		<table>
			<caption>전체 학생 수 : ${totalCount}명</caption>
			<thead>
				<tr>
					<td>학번</td>
					<td>성명</td>
					<td>국어점수</td>
					<td>영어점수</td>
					<td>수학점수</td>
					<td>평균점수</td>
					<td>학점</td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<c:if test="${totalCount eq 0}">
					<tr>
						<td colspan="8">등록된 학생이 없습니다.</td>
					</tr>
				</c:if>
				<c:if test="${totalCount gt 0}">
					<c:forEach var="student"   items="${list}">   <!-- form을 삽입하게 된다면 학생한명당이므로 for문 내부에 form 삽입해서 데이터를 보내기!!! 전체폼이면 학생전.부데이터를 읽음 -->
						<tr>
							<td>${student.sno}</td>
							<td>${student.name}</td>
							<td>${student.kor}</td>
							<td>${student.eng}</td>
							<td>${student.mat}</td>
							<td><fmt:formatNumber value="${student.ave}" pattern="0.00" /></td>
							<td>${student.grade}</td>
							<td>
								<!--  수정 버튼의 이전 형제에 학번 저장해 둠. -->
								<input type="hidden" value="${student.sno}">
								<input type="button" value="수정"  class="update_btn">
								<!--  삭제 버튼의 data 속성에 학번 저장해 둠. -->
								<input type="button" value="삭제"  data-sno="${student.sno}" class="delete_btn" >
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
			<tfoot>
					<tr>
						<td colspan="5">TOTAL AVERAGE</td>
						<td><fmt:formatNumber value="${avg}" pattern="0.00" /></td>
						<td colspan="2"></td>
					</tr>
			</tfoot>
			
			
		</table>
	</div>
	
	
	
	
</body>
</html>