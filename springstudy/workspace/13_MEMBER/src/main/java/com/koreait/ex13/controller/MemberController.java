package com.koreait.ex13.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.ex13.domain.Member;
import com.koreait.ex13.service.MemberService;
import com.koreait.ex13.util.SecurityUtils;

@Controller
@RequestMapping("member/*")
public class MemberController {
  
	
	
	private MemberService service;
	
	public  MemberController(MemberService service) {
		super();
		this.service = service;
	}
	
	// 로그인 화면으로 이동
	@GetMapping("loginPage")
	public String loginPage() {
		return "member/login";
	}
	
	// 회원가입 화면으로 이동
	@GetMapping("joinPage")
	public String joinPage() {
		return "member/join";
	}
	
	// 아이디 중복체크                    // Map을 작성하면 jackson이 map->json data로 변환한다.
	@PostMapping(value="idCheck", produces ="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> idCheck(@RequestParam String id) {
		return service.idCheck(id);
	}
	
	// 이메일 중복체크 + 아이디 찾기
	@PostMapping(value={"emaliCheck", "findId"}, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> findMemberByEmail(@RequestParam String email){
		return service.findMemberByEmail(email);
	}
	
	// 이메일 인증코드
	@PostMapping(value="sendAuthCode", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> sendAuthCode(@RequestParam String email){
		return service.sendAuthCode(email);
	}
	
	// 회원가입
	@PostMapping("join")
	public String join(Member member) {
		service.join(member);
		return "redirect:/";  // index.jsp로 리다이렉트
	}
	
	// 로그인 
	@PostMapping("login")
	public String login(HttpServletRequest request) {
      // public String login(Member member,HttpSession session){
		service.login(request);
		return "redirect:/";
	}
	
	// 로그아웃
	@GetMapping("logout")
	public String logout(HttpSession session) {
	    if( session.getAttribute("loginUser") != null )
		  session.invalidate();
	    
		return "redirect:/";
	}
	
	// 아이디 찾으러 가기
	@GetMapping("findIdPage")
	public String findIdPage() {
		return "member/findId";
	}
	
	// 비밀번호 찾으러 가기
	@GetMapping("findPwPage")
	public String findPwPage() {
		return "member/findPw";
	}

    // 비밀번호 수정하러 가기
	@GetMapping(value="updatePwPage")
	public String updatePwPage(@ModelAttribute("email") String email) {
		return "member/updatePw";
	}
	
	// 업데이트 수정하기
	@PostMapping("updatePw")
	public String updatePw(Member member) {
		service.updatePw(member);
		return "redirect:/";     // 로그인 페이지로 보내면 세션문제와 다시 로그인하는 일이 발생함
	}
	
	// 마이페이지로 이동
	@GetMapping("myPage")
	public String myPage() {
		return "member/myPage";
	}
	
	// 마이페이지 수정
	@PostMapping("updateMember")
	public String updateMember(Member member, HttpSession session) {
		service.updateMember(member, session);
		return "redirect:/";
	}
	
	//탈퇴하기
	@PostMapping("leave")
	public String leaveMember(@RequestParam Long no, HttpSession session) {
		service.leave(no, session);
		return  "redirect:/";
	}

	
	// 비번 수정시 현재 비번과 일치여부확인하기
	@PostMapping(value="presentPwCheck", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> presentPwCheck(HttpServletRequest request){
		return service.presentPwCheck(request);
	}
}
