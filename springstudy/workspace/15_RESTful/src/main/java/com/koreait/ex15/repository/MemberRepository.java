package com.koreait.ex15.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.koreait.ex15.domain.Member;

@Repository
public interface MemberRepository {
	
	// 멤버 수 구하기 
	public int selectMemberCount();
	
	// 멤버 전체 보기 
	public List<Member> selectMameberList(Map<String, Object> m);
	
	// 멤버 상세보기
	public Member selectMemberByNo(Long memberNo);
		
	// 멤버 등록하기
	public int insertMember(Member member);
	
	// 멤버 수정하기
	public int updateMember(Member member);
	
	// 멤버 삭제하기
	public int deleteMember(Long memberNo);
	

}
