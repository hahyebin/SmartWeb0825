package com.koreait.ex04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.ex04.domain.Board;

@Controller
@RequestMapping("board")   // board로 시작하는 mapping을 처리하는 컨트롤러이다. (prefix 작업)
public class BoardController {

	
	
	@GetMapping("v1.do")  // 실제로는 board/v1.do 를 의미함
	public String v1() {
		return "board/boardDetail";
	}
	
	
	/*
	    ModelAndView 클래스 
	    
	    1. 스프링 초기에 많이 사용한 클래스(스프링 2 이전)
	    2. 앞으로는 사용을 자제( Model을 대신 사용)
	    3. Model(jsp에 값을 넘기는 역할)과 View를 동시에 처리
	       어디로 어떤 값을 보냄 
	 */
	
	
	@GetMapping("v2.do")
	public ModelAndView v2() {
		
		ModelAndView mav = new ModelAndView();
		
		// View 설정
		mav.setViewName("board/boardDetail");
		
		// Model 설정 (넘겨줄 값)
		mav.addObject("board", new Board.BoardBuilder(1L, "긴급공지","내일 청소")
						.setHit(0L)
						.build() );
		return mav;
	}
	
	//  <a href="board/v3.do?no=10&title=공지&context=내용">게시판3</a><br>
	@GetMapping("v3.do")
	public ModelAndView v3(@RequestParam(value="no") Long no,
						@RequestParam(value="title") String title,
						@RequestParam(value="context") String context) {
		// 1. HttpServletRequest 
		// 2. @RequestParam
		// 3. Board bard 
		// 정답 : 3. Board 클래스에 setter와 생성자가 없기 때문에 Board board는 사용할 수 없다.
		
	
		ModelAndView mav = new ModelAndView();
		
		// View 설정
		mav.setViewName("board/boardDetail");
		
		mav.addObject("board", new Board.BoardBuilder(no, title, context)
							.build());
		
		return mav;
	
	}
	
	
	
	
	
	
	
}
