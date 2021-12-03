<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script type="text/javascript">
	
</script>
<style>
	.wrap {
		display: flex;
		justify-content: center;
	}
	.left, .right {
		padding: 10px;
	}
</style>
	<script type="text/javascript">
		$(document).ready(function(){
			
			// 언어선택
		$('#source').on('change', function(){
			if ($(this).val() == '') {
				$('#target').val('');
			} else if ($(this).val() == 'ko') {
				$('#target').val('en');
			} else if ($(this).val() == 'en') {
				$('#target').val('ko');
			}
		});
			$('#btn').on('click',function(){
				$.ajax({
					url:  "papago/translatePapago.do",
					type : 'post',
					data : JSON.stringify ({
						"source" : $("#source").val(),
						"target" : $("#target").val(),
						"text" : $("#text").val()
					}),
					contentType: 'application/json',
					dataType: "json",  
					success : function(data){
						$("#translated").val(data.message.result.translatedText);
					},
					error: function(xhr, error){
						$("#translated").val(xhr.responseText);
						$("#translated").val(xhr.error);
						
					}
				})
			});
		});

	</script>


</head>
<body>

	<h1 style="text-align: center;">파파고 번역하기</h1>
	
	<div class="wrap">
	
		<div class="left">
			<form>
				<select id="source" >
					<option value="">언어선택</option>
					<option value="ko">한국어</option>
					<option value="en">영어</option>				
				</select><br>
				<textarea rows="20" cols="60" id="text" placeholder="번역할 내용 입력" ></textarea><br>
				<input type="button" value="번역하기" id="btn">
			</form>
		</div>
		
		<div class="right">
			<form>
				<select id="target" >
					<option value=""></option>
					<option value="ko">한국어</option>
					<option value="en">영어</option>		</select><br>
				<textarea rows="20" cols="60" id="translated"></textarea><br>
			</form>
		</div>
		
	</div>

</body>
</html>