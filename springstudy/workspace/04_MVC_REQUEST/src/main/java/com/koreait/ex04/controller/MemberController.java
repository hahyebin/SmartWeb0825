package com.koreait.ex04.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.ex04.domain.Member;
import com.koreait.ex04.domain.MemberBuilder;

@Controller
public class MemberController {
	
	
	//Welcome page 작업
	@GetMapping( { "/", "index.do" } )
	public String a() {
		return "index";
	}
	

	
//	@GetMapping("/member/v1.do")  : 슬래시(/)로 시작해도 된다.
	@GetMapping("member/v1.do")
	public String b() {
//		return "/member/memberDetail";     : 슬래쉬(/)로 시작해도 된다.
		return "member/memberDetail";
	}
	
	
	
	
	
	
 // <a href="member/v2.do?idx=1&id=user&name=james">회원</a>
	@GetMapping("member/v2.do")
	public String c(HttpServletRequest request) {     // 파라미터 처리를 매개변수가 해야한다.
 		Long idx = Long.parseLong(request.getParameter("idx"));
 		String id = request.getParameter("id");
 		String name = request.getParameter("name");
 		
 		// Member 생성 - 1
 		Member member1 = new Member();
 		member1.setIdx(idx);
 		member1.setId(id);
 		member1.setName(name);
 		
 		// Member 생성 - 2                    =====> 매개변수가 있는 생성자를 생성하기 위해서는 매개변수 순서와 생성자에 전부 넣어야한다. 이를 대체하기 위해 BuildPattern을 만들어서 원하는 필드만 이용한 객체를 생성해서 반환한다.
 		Member member2 = new Member(idx, id, name);
 		
 		// Member 생성 - 3(Builder Pattern 이용하기 )   -- > why?....1. 필드가 많을 때 사용하고 싶은 필드만 사용하기 위해 Builder Pattern 을 사용한다. -> 최종적으로 본래 클래스 객체를 반환해야한다.
 		Member member3 = new MemberBuilder()                //       2. 객체 필드의 변화를 막기위해 (불변)
 						.setIdx(idx)
 						.setId(id)
 						.setName(name)
 						.build();
 		// request를 이용해서 Member 넘기기
 		request.setAttribute("member", member3);
 		
		return "member/memberDetail";
	}
	
	
	
	
	
	
	//  <a href="member/v3.do?idx=1&id=user&name=james">회원3</a>  --> 파라미터 전달함 
	@GetMapping("member/v3.do")
	public String d(@RequestParam(value="idx") Long idx,          //@RequestParam(value="파라미터이름") 저장할 변수
			        @RequestParam(value="id")  String id,		  //@RequestParam(value="파라미터이름") 저장할 변수
			        @RequestParam(value="name") String name, Model model) {
		// Model은 JSP에 값을 넘기는 역할 
		model.addAttribute("member", new Member(idx, id, name));
		
		return "member/memberDetail";
	}
	
	
	
	
	/*
	    RequestParam의 속성 1) value = "parameter" => 파라미터명 
	                        2) required = false => 파라미터가 필수가 아님 
	                        3) defaultValue = ""  => 기본 파라미터의 값 지정 
	 */
	
	
	
	// <a href="member/v4.do">회원4</a>    --> 파라미터 전달안함 
	@GetMapping("member/v4.do")
	public String e(@RequestParam(value="idx", required=false, defaultValue="999") Long idx,
			        @RequestParam(value="id", required=false, defaultValue="chul")  String id,
			        @RequestParam(value="name", required=false, defaultValue="철" ) String name, Model model) {
		
		model.addAttribute("member", new Member(idx, id, name));
		
		return "member/memberDetail";
	}
	
	
	
	
	
	//   <a href="member/v5.do?idx=1&id=user&name=james">회원5</a>      ==> 파라미터를 주고 객체가 받기
	@GetMapping("member/v5.do")
	public String f(Member member    // Member 클래스의 setter가 파라미터를 모두 받아 준다.
					,Model model) {
	
		model.addAttribute("member", member);
		return "member/memberDetail";
		
	}
	
	
	
	/*
	    @ ModelAttribute(value="객체명")  클래스명 객체명 => 클래스이 객체를 @ModelAttribute value를 통해 받는다.  ==> v5의 축약버전
	    값만 가지고 이동하는 단순 페이지 이동 방법이다(ex. 상세페이지->수정페이지)  
	 */
	
	//  <a href="member/v6.do?idx=1&id=user&name=james">회원6</a>    ==> 파라미터 주고 Model로 받기     
	@GetMapping("member/v6.do")
	public String g(@ModelAttribute(value="member") Member member) {
				
		return "member/memberDetail";
	}

	
	
	
}
