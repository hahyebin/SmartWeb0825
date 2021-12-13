package com.koreait.ex13.repository;

import org.springframework.stereotype.Repository;

import com.koreait.ex13.domain.Member;

@Repository
public interface MemberRepository {
	
	
    // 아이디 중복체크
	public Member selectMemberById(String id);
	
	// 회원가입
	public int joinMember(Member member);
	
	// 로그인
	public Member login(Member member);
	
	// 이메일로 아이디 찾기 + 정보 변경 전 사용가능이메일 체크하기
	public Member selectMemberByEmail(String email);
	
	// 비밀번호 변경
	public int updatePw(Member member);
	
	// 정보변경
	public int updateMember(Member member);
	
	// 탈퇴하기 (DB는 남음)
	public int leaveMember(Long no);
	
	
	
	

}
