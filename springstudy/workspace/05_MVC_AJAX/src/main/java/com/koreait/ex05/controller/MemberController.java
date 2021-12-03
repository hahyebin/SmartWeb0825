package com.koreait.ex05.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.ex05.domain.Member;
import com.koreait.ex05.domain.PaPago;

@Controller
public class MemberController {
	
	// welcome page
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	// ajax 처리할 때는 view를 반환하지 않는다.
	
	// ajax는 데이터를 반환한다.
	// text/plain, text/xml, application/json 등
	// 
	
	@ResponseBody
	@GetMapping(value="member/v1.do",
			produces="text/plain; charset=UTF-8")  // ajax를 이용해 보낼 데이터는 일반 텍스트 
	public String v1(@RequestParam("id") String id) {
			String result = "입력된 아이디는 "+id+"입니다.";
	//	return result;    이런 경우엔 ViewResolver가 작동해서 WEB-INF/views + result + .jsp 가 된다.
			return result;    // 때문에 @ResponseBody 를 통해 반환이 view가 아니란걸 알려줘야한다.(오직 data만 전달)
	}
	
//	@GetMapping(value="member/v1.do", produces="text/plain; charset=UTF-8")
//	@ResponseBody
//	public String v33(@RequestParam String id) {
//		String d = "입력한 아이디는 " + id +" 이다."; 
//		return d;
//	}
//	
	@ResponseBody
	@GetMapping(value="member/v2.do", produces="application/json; charset=UTF-8")
	public Member v2(Member member) {
		return member;     // jackson library가 타입이 Member인걸 보내지만 json으로 반환되어 보내는일을 한다.
							// 아무것도 명시하지 않아도 내부에서 알아서 처리한다.
		// 반환되는 bean은 jackson data-bind에 의해서 json으로 변환됨(bean말고 hashmap도 변환가능)
		
	}
	
	
	@ResponseBody
	@GetMapping(value="member/v3.do", 
			produces="application/json; charset=UTF-8")
	public  Map<String, String> v3(HttpServletRequest request) {
	
		Map<String,String> resultMap = new HashMap<>();
		resultMap.put("id", request.getParameter("id"));
		resultMap.put("pw", request.getParameter("pw"));
		
		return resultMap;  // 반환되는 map은 jackson data-bind에 의해서 json으로 변환됨
	}
	
	
	@ResponseBody
	@PostMapping(value="member/v4.do",
			produces="application/json; charset=UTF-8")
	public Map<String, Object> v4(@RequestBody Member member) {    // 전달된 json데이터는 jackson data-bind에 의해서 bean으로 변환된다.
		Map<String, Object> map = new HashMap<>();
		map.put("id", member.getId());
		map.put("pw", member.getPw());
		map.put("addOn", 1000);
		// 추가하고 싶은 데이터가 있을 땐 map이 좋다.
		// bean은 정해진 타입의 필드나 메서드가 있기 때문에 
		// 비교적 자유로운 설정이 가능한 map이 좋다
		
		return map;
	}
	
	@GetMapping("openPapago.do")
	public String openPapago() {
		return "papago";
	}
	
   
	@GetMapping("map.do")
	public String map() {
		return "map";
	}
		

		@GetMapping("address.do")
		public String address() {
			return "address";
		}
	
}
