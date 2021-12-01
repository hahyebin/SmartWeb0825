package com.koreait.ex02.controller;

import org.springframework.stereotype.Controller;
/*
 @Controller 
  안녕 난 Controller야 서블릿이 아니라 자바클래스
*/
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
		
	// 메소드 1개 = 요청 1개, 응답 1개 
	@RequestMapping(value="/", method=RequestMethod.GET)
	// value = "/"   : mapping이 컨텍스트 path이다. ( http://localhost:9090/ex02)  -- 한마디로 welcome 파일 작업이다.
	// method=RequestMethod.GET  :  GET방식의 요청이다
	
	// 반환타입 : String (View 이름 즉 JSP이름을 반환)
	// method명 : index(아무일도 하지 않는다 대신 이름은 중복없이) 
	// 매개변수 : 사용자 요청 및 응답을 처리한다.
	public String index() {
		return "index";
		
		// return "index"; 는 servlet-context.xml(DispatherServlet)에 의해서 다음과 같이 처리된다
		// return "/WEB-INF/views/index.jsp"
		      //  prefix /  내가 지정한 파일명(여기선index) / suffix ==> servlet-context에서 명시됨 
	}
	
	@RequestMapping(value="imageView.do",  method=RequestMethod.GET)
    public String imageView() {
		return "gallery/detail";
		//  기본 동작은 forward 이다.
		//  /WEB-INF/views/gallery/detail.jsp forward로 간다(기본동작)
	}
}
