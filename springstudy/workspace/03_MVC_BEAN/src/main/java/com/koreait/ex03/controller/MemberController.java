package com.koreait.ex03.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.koreait.ex03.config.MemberConfig;
import com.koreait.ex03.domain.Member;

@Controller
public class MemberController {
	
	AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(MemberConfig.class);
	Logger logger = Logger.getLogger(Member.class.getName());
	
	// Spring4.3부터 GetMapping, PostMapping
	
	//@RequestMapping(value="/",  method=RequestMethod.GET)
	@GetMapping("/")          // value속성만 필요한 경우엔 값만 적을 수 있다.
	public String a(HttpServletRequest request) {       // 매개변수는 요청이나 응답 처리
		
		// member1을 만들어서 index.jsp로 보내기
		Member member1 = ctx.getBean("member1", Member.class);
		request.setAttribute("member1", member1);

	    request.getSession().setAttribute("member1", member1);  // 세션으로 값주면 이동이동해서 memberDetail에서도 member1을 받을 수 있다.
	    
		return "index";   // 기본이동 forward 이므로 request가 전달
	}
	
	//@RequestMapping(value="memberView.do", method=RequestMethod.GET)
	@GetMapping("memberView.do")  // value속성만 필요한 경우엔 값만 적을 수 있다.
	public String b(Model model) {
		
		// Model
		// 안녕 난 request를 사용하는 클래스, 보안이 더 좋지 
		// addAttribute()를 사용하면 실제로는 request.setAttribute() 처럼 동작하지
		Member member2 = ctx.getBean("member2", Member.class);
		model.addAttribute("member2", member2);

		// member2을 만들어서 memberDetail.jsp로 보내기
		return "member/memberDetail";
	}
	
	
	
	
}
