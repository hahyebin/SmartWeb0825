package com.koreait.ex04.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("gallery")
public class GalleryController {
	
	// v1.do -> v2.do 로 redirect
	@GetMapping("v1.do")
	public String v1(HttpServletRequest request) {
		
		int page = Integer.parseInt(request.getParameter("page"));
		request.setAttribute("page", page);   // redirect하면 전달되지 않는다.
		
		// redirect 하는 방법 (다른 매핑으로 이동)
		// redirect:mapping
		
		// redirect가 필요한 경우
		// 1. 삽입 후 : list.do
		// 2. 삭제 후 : list.do
		// 3. 수정 후 : list.do  
		           //    view.do?no=1
		
		// return "redirect"gallery/v2.do" 이동하면 
		// localhot:9090/ex04/gallery/gallery/v2.do로 이동되면서 404 발생
		return "redirect:v2.do";   // 페이지 이동이므로 do매핑 하나 더 만들기
	}
	
	
	
	@GetMapping("v2.do")
	public String v2() {
		
		 return "gallery/galleryDetail";
	}
	
	// v3.do -> v4.do
	@GetMapping("v3.do")
	public String v3(@RequestParam(value="page") int page, Model model) {
		model.addAttribute("page", page);
		
		//redirect
		
		// return "redirect:v4.do";  ==> v4()함수의 return 값이 "gallery/galleryDetail"이므로 
		// v4()를 호출하는거나 동일하다.
		return  "redirect:v4.do";
	}
	
	@GetMapping("v4.do")
	public String v4() {
		 return "gallery/galleryDetail";
	}
	
	// v5.do -> v6.do로 redirect
	// redirect할 때 데이터 전달하기
 
	// RedirectAttributes 인터페이스 
	// 1. Model 인터페이스 상속 받은 인터페이스
	// 2. addFlashAttribute() 사용 (addAttribute()는 안됨) 
	@GetMapping("v5.do")
	public String v5(@RequestParam("page") int page, 
						RedirectAttributes redirectAttributes ) {  // Model 대신 RedirectAttributes
		// redirect에서도 page가 전달됨(속성으로 전달됨)
		redirectAttributes.addFlashAttribute("page", page);        // 파라미터가 아닌 속성값으로 넘겨줌
		
		return "redirect:v6.do";
	}
	
	@GetMapping("v6.do")
	public String v6() {
		 return "gallery/galleryDetail";
	}
	
	
	
	
	
	
	
	
	
	
}
