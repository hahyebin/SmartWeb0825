package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;

public class Rectangle implements Shape {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		// 요청처리
		String strWidth = request.getParameter("width");  // 사용자로부터 받은 요청 데이터 
		int width = Integer.parseInt(strWidth);
		String strHeight = request.getParameter("height");
		int height = Integer.parseInt(strHeight);
		
		int area = width * height;
		
		// 응답 처리
		// 1. 결과를 반환한다.
		// 2. 응답 View를 결정한다. 
	    // 3. 이동 방식(redirect, forward)을 결정한다.
		
		// 응답 처리 - 1
		//  결과를 반환하는 경우 : request에 결과 저장
		request.setAttribute("area", area);
	    
		// 응답 처리 - 2 : ModelAndView 클래스가 담당
		//  1) 응답 View : 앞으로 이동할 View(JSP)의 경로 작성  -> String
		//  2) 이동 방식 : forward 또는 redirect         -> boolean
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView("views/rectangle.jsp");   // 이동할 곳 여기서 결정 
		modelAndView.setRedirect(false);  // forward하겠다.
		
		// ModelAndView 객체를 컨트롤러에 반환 
		return modelAndView;   //  직접 반환하는 경우 객체는 null임 
	}

}
