package com.koreait.ex15.controller;

import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.ex15.domain.Member;
import com.koreait.ex15.service.MemberService;

import lombok.AllArgsConstructor;

// REST  방식 (기본적인 틀 존재)            restful : 자원을 이름(자원의 표현)으로 구분하여 해당 자원의 상태(정보)를 주고 받는 모든 것

// 1.URL + Method에 의해서 동작이 결정
//  : list?page=1  ==> list/page/1
// 2. URL에 파라미터가 경로의 일부로 포함 ( 변수가 파라미터에 붙는게 아니라 경로에 포함=> 이러한 경우엔 데이터를 보내지 않아도 된다)
// 3. URL + Method     // 매핑같아도 메소드방식다르면 가능함
//  	1) 목록 : members 			        + GET
//      2) 개별(조회) : members/1 			+ GET
//      3) 삽입 : members                   + POST
//		4) 수정 : members					+ PUT     (수정할 정보는 body에 포함시켜서 처리됨)
//      5) 삭제 : members/1                 + DELETE 

@RestController
@AllArgsConstructor      //  롬복활용해서 생성자를 만들면  field @Autowired 가 만들어진다.
public class MemberController {

	private MemberService service;
	
	// 전체 멤버 리스트 매핑
	@GetMapping(value="api/members/page/{page}", produces = "application/json; charset=UTF-8")
	public Map<String, Object> findAllMember(@PathVariable(value="page", required=false) Optional<Integer> opt) {
		Integer page = opt.orElse(1); // 널이면 page=1        // ㄴ pathvariable은 필수가 아니라 널이 떨어질 수 있음 
		return  service.findAllMember(page);
	}
	
	
	
	// 회원 등록 매핑(아이디 중복을 예외처리)     
	@PostMapping(value="api/members", produces = "application/json; charset=UTF-8"  )
	public Map<String, Object> addMember(@RequestBody Member member, HttpServletResponse response){    // 아이디가 유니크이기 때문에 만약 중복 있으면 예외가 발생한다.
		try {
	    	return service.addMember(member);
	    } catch(DuplicateKeyException e) {
	   //	System.out.println(e.getClass().getName());   // 예외 이름 알아내는 방법
		    try {
		    	response.setContentType("text/html; charset=UTF-8");
		    	response.setStatus(500);
		    	response.getWriter().println("이미 사용중인 아이디 입니다.");
		    } catch(Exception e2) {
		    	e2.printStackTrace();
		    } 
	    } catch(DataIntegrityViolationException e) {
	    	 try {
			    	response.setContentType("text/html; charset=UTF-8");
			    	response.setStatus(501);
			    	response.getWriter().println("필수 정보가 누락되었습니다.");
			    } catch(Exception e2) {
			    	e2.printStackTrace();
			    } 
	   }
     return null;   // 동작할 일 없음. 에러 회피 위함		
	}
	
	
	// 회원 조회  경로에 포함된 경로는 {}를 삽입
	@GetMapping(value="api/members/{memberNo}", produces = "application/json; charset=UTF-8")
	public Map<String, Object> findMember(@PathVariable(value="memberNo") Long memberNo ){         // 경로에 변수가 있다. 경로변수: @PathVariable
		return service.findMember(memberNo);
	}
	
	// 수정하기
	@PutMapping(value="api/members", produces = "application/json; charset=UTF-8")
	public Map<String, Object> modifyMember(@RequestBody Member member) {
		return service.modifyMember(member);
	}
	
	
	// 회원 삭제  경로에 포함된 경로는 {}를 삽입
	@DeleteMapping(value="api/members/{memberNo}", produces = "application/json; charset=UTF-8")
	public Map<String, Object> removeMember(@PathVariable(value="memberNo") Long memberNo){
		return service.removeMember(memberNo);
		
	}
	
	
	
}
