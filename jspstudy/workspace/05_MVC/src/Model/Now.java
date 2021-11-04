package model;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Now {


	
	public void excute(HttpServletRequest request, HttpServletResponse response) {
	  LocalTime result2 = LocalTime.now();
	  SimpleDateFormat sdf = new SimpleDateFormat("a h:mm:ss");
	  String result = sdf.format(new Date());
		
		// 응답 View인 output.jsp로 보내기 위한 데이터 저장 
		request.setAttribute("result", result);
	    request.setAttribute("result2", result2);
	}
}
