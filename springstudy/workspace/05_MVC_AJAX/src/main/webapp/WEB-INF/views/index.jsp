<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<title>Ajax</title>
<script>
    // 페이지 로드
	$(document).ready(function(){
		$("#btn1").on('click',function(){	fnAjax1();		});
		$("#btn2").on('click',function(){	fnAjax2();		});
		$("#btn3").on('click',function(){	fnAjax3();		});
		$("#btn4").on('click',function(){	fnAjax4();		});
	});
    
    // 함수 
    function fnAjax1(){
    	$.ajax({
    		url: "member/v1.do",
    		type: "get",
			data : "id=" + $('#id').val(),                 // 'id' parameter로 데이터 보내기
    		dataType: "text",                             // MemberController에서 반환하는타입은 String -> text 이므로 dataType을 맞춰야한다.
    		success : function(result){
    			$('#result').empty();
    			$('#result').text(result);
    		},
    		error : function(xhr){
    			$('#result').empty();
    			$('#result').text(xhr.responseText);
    		}
    	}); // ajax
    };  // end of fnAjax1();
    
    function fnAjax2(){
    	$.ajax({
    		url: "member/v2.do",
    		type : "get",
    		data : $('#f').serialize(),   // form 의 모든 요소를 파라미터로 전송
    		dataType : 'json',          
// 전송: json을 결과로 받기 위해서는 controller의 produces는 application/json으로 설정해야한다.
// 수신: controller에서 Member타입의 객체로 전송했지만 jackson lib를 통해서 json데이터 형식으로 변환되고, 이곳으로 서버가 왔을 때는 이미 json데이터 형식이 되어있다. 
    		success : function(member){        // member = {"id": "aaaa", "pw": "ss"}
    			$('#result').empty();
    			$('<u1>')
    			.append( $('<li>').text(member.id) )
    			.append( $('<li>').text(member.pw) )
				.appendTo('#result');
    		},
    		error : function(xhr){
    				$('#result').empty();
    				$('#result').text(xhr.responseText);
    		}
    	});
    }  // end of fnAjax2();
    
    
    function fnAjax3(){
    	$.ajax({
    		url: "member/v3.do",
    		type: 'get',
    		data: $('#f').serialize(),
    		dataType : "json",
    		success : function(resultMap){
    			$('#result').empty();
    			$('<h1>').text(resultMap.id).appendTo("#result");
    			$('<h1>').text(resultMap.pw).appendTo("#result");
    		},
    		error : function(xhr){
    			$('#result').empty();
				$('#result').text(xhr.responseText);
    		}
    	})
    }// end of fnAjax3();
    
    
    function fnAjax4(){
		$.ajax({
	    	url: "member/v4.do",
	    	type: 'post',  						// json 데이터를 '본문에 포함'시켜서 전송
	    	data: JSON.stringify({ "id" : $('#id').val(),      // 전송 : json 으로 데이터 보내기 -> stringify => 문자열형식으로 묶기
	    		    "pw" : $('#pw').val()
   		   		}), // json 데이터를 서버로 보냄
   		  	contentType: 'application/json',     // 보내는 데이터의 타입 (파라미터 전송이 아닌 json데이터를 직접 서버로 보낼대는 contentType을 설정하기 )
   		  	dataType:'json',
   		   	success : function(map){
   		  		$('#result').empty();
   		  		$('<ol>')
   		  		.append( $('<li>').text(map.id)  )
   		  		.append( $('<li>').text(map.pw)  )
   		  		.append( $('<li>').text(map.addOn)  )
   		  		.appendTo('#result');
   		  	},
   		  	error : function(xhr){
   		  		$('#result').empty();
   		  		$('#result').text(xhr.responseText);
   		  	}
	    })
    }// end of fnAjax4();
</script>
</head>

<body>
	
	<form id="f">
		<input type="text" name="id" id="id" placeholder="ID"><br>
		<input type="password" name="pw" id="pw" placeholder="Password"><br>
		<input type="button" value="전송1" id="btn1">
		<input type="button" value="전송2" id="btn2">
		<input type="button" value="전송3" id="btn3">
		<input type="button" value="전송4" id="btn4">
	</form>
	<div id="result"></div>
	<hr>


	<form id="f2">
	   <input type="text" name="title" id="title" placeholder="제목">
	   <input type="text" name="content" id="content" placeholder="내용">
		<input type="button" value="전송1" id="button1">	  
		<input type="button" value="전송2" id="button2">	  
		<input type="button" value="전송3" id="button3">	  
	</form>
		<div id="result2"></div>

	<script type="text/javascript">
			$('#button1').on('click',function(){
				$.ajax({
					url: "board/v1.do",
					type: 'get',
					data: $('#f2').serialize(),
					dataType: 'json',
					success: function(board){
						$('#result2').empty();	
						$('<h1>').text( board.title).appendTo('#result2');
						$('<h1>').text( board.content).appendTo('#result2');
					},
					error : function(xhr){
						$('#result2').empty();
		   		  		$('#result2').text(xhr.responseText);
					}
				})
			});
			
			$('#button2').on('click',function(){
					$.ajax({
						url : 'board/v2.do',
						type: 'post',
						data: JSON.stringify({
							"title" : $('#title').val(),
							"content" : $('#content').val()
						}),
						contentType : 'application/json',
						dataType: 'json',
						success : function(board){
							$('#result2').empty();	
							$('<h1>').text( board.title).appendTo('#result2');
							$('<h1>').text( board.content).appendTo('#result2');
						},
						error : function(xhr){
							$('#result2').empty();
			   		  		$('#result2').text(xhr.responseText);
						}
					}); //ajax	
			});
			$('#button3').on('click',function(){
				$.ajax({
					url : 'board/v3.do',
					type: 'post',
					data: JSON.stringify({
						"title" : $('#title').val(),
						"content" : $('#content').val(),
						"hit" : 100
					}),
					contentType : 'application/json',
					dataType: 'json',
					success : function(map){
						$('#result2').empty();	
						$('<h1>').text("제목 " + map.title).appendTo('#result2');
						$('<h1>').text("내용 " + map.content).appendTo('#result2');
						$('<h1>').text("조회 " + map.hit).appendTo('#result2');
					},
					error : function(xhr){
						$('#result2').empty();
		   		  		$('#result2').text(xhr.responseText);
					}
				})
			});
	</script>

	<a href="openPapago.do">파파고</a>


	<a href="map.do">지도</a>
	
	
	<a href="address.do">지도</a>
	

</body>
</html>