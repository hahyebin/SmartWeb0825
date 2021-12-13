package com.koreait.ex13.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;

import com.koreait.ex13.domain.Member;

public interface MemberService {
	
	// 아이디 중복체크 
	public Map<String, Object> idCheck(String id);
	
	// 이메일 중복체크 + 아이디 찾기
	public Map<String, Object> findMemberByEmail(String email);
	
	// 이메일 인증코드 보내기
	public Map<String, Object> sendAuthCode(String email);
	
	//회원가입
	public void join(Member member);
	
	// 로그인
	public void login(HttpServletRequest request);
	
	
	// 비밀번호 수정(이메일 받아야함)
	public void updatePw(Member member);
	
	// 내 정보 변경
	public void updateMember(Member member, HttpSession session);
	
	// 탈퇴하기
	public void leaveMember(HttpServletRequest request);
	
	
	
}
