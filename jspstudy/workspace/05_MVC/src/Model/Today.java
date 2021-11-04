package model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Today {
	

	
	
	public void excute(HttpServletRequest request,  HttpServletResponse response) {	
		LocalDate result2 = LocalDate.now();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
		String result = sdf.format(new Date());
		request.setAttribute("result", result);
		request.setAttribute("result2", result2);
		
	}
	public void ec(HttpServletRequest request,  HttpServletResponse response) {
		String name = "gopqlkd";
		
	}
}
