package com.koreait.ex15.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.koreait.ex15.domain.Member;

@Service
public interface MemberService {

	// 전체 멤버 보기 + page
	public Map<String, Object> findAllMember(Integer Page);
	
	// 멤버 상세보기
	public Map<String, Object>  findMember(Long memberNo);
	
	// 멤버 등록하기
	public Map<String, Object> addMember(Member member);   // saveMember
	
	// 멤버 수정하기 
	public Map<String, Object> modifyMember(Member member);
	
	// 멤버 삭제하기
	public Map<String, Object> removeMember(Long memberNo);
	
	
}
