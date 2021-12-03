package com.koreait.ex05.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.ex05.domain.Board;

// ajax만 처리하는 controller 이다. @ResponseBody를 생략함 -----> controller는 view로 반환되어 ajax로 받는 컨트롤러 구간엔 @ResponseBody가 필요하지만,
// controller 클래스에 @RestController를 선언하면 @ResponseBody을 매서드에 선언하지 않아도 데이터전송이 가능하다.
@RestController  
@RequestMapping("board")
public class BoardController {
	
	@GetMapping(value="v1.do", produces="application/json; charset=UTF-8")
	public Board v1(Board board) {
		return board;
	}
	
	
	
	@PostMapping(value="v2.do", produces="application/json; charset=UTF-8")
		public Board v2(@RequestBody Board board) {    // 전달된 json데이터는 jackson data-bind에 의해서 bean으로 변환된다.
		return board;
	}
	
	
	@PostMapping(value="v3.do", produces="application/json; charset=UTF-8")
	public Map<String, Object> v3(@RequestBody Map<String, Object> map ) {    // 전달된 json데이터는 jackson data-bind에 의해서 bean으로 변환된다.
	    return map;
}
	
	
}
