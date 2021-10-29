<%@page import="java.io.*"%>
<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		
		String date = request.getParameter("date");
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Optional<String> optIp = Optional.ofNullable(request.getHeader("X-Forwarded-For"));
		String ip = optIp.orElse(request.getRemoteAddr());
		
		// String ip = request.getHeader("X-Fowarded-For");
		// if(ip==null){  ip = request.getRemoteAddr() ; }
		
		// ip : 0:0:0:0:0:0:1
		// ip : 0_0_0_0_0_0_1
		String filename = ip.replaceAll(":","_")+"_"+date+".txt";
		
		// ip : 127.0.0.1
		// ip : 127_0_0_1
		// String filename = ip.replaceAll("\\.","_");
		
		// 서버 내 저장 경로
		// application을 통해서 realPath 확인 가능 
		// D:\SmartWeb0825-main\jspstudy\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\02_JSP\ex06_attribute
		String realPath = application.getRealPath("ex06_attribute");
		
		// 저장 경로 확실히 생성
		File dir = new File(realPath);
		if( dir.exists() == false ){
			dir.mkdirs();
		}
		
		// 파일 생성 
		File file = new File(dir, filename);  // new File(폴더, 파일명)
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		bw.write("작성일자: "+ date +"\n");  // bw.newLine(); == \n
		bw.write("작성자: "+writer+"\n");
		bw.write("제목: "+title+"\n");
		bw.write(content);
		
		if( bw != null){
			bw.close(); 
			}
		
		// 파일 생성 확인 
		if(file.exists()){
			application.setAttribute("success", true);		
		} else {
			application.setAttribute("success", false);
		}
	%>
	
	<script>
		let exist = <%=file.exists()%>;    // 반환타입 : true  or false
		if( exist ){
			alert('<%=filename%> 파일이 생성되었습니다.');
		} else {
			alert('파일이 생성되지 않았습니다.');
		}
		history.back();
	</script>
	
	
</body>
</html>





