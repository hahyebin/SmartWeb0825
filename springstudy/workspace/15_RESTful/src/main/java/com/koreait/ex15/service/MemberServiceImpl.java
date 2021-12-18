package com.koreait.ex15.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.koreait.ex15.domain.Member;
import com.koreait.ex15.repository.MemberRepository;
import com.koreait.ex15.util.PageUtils;

@Service
public class MemberServiceImpl implements MemberService {

	private final static Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	private MemberRepository repository;
	
	public MemberServiceImpl(SqlSessionTemplate sqlSession) {
		repository = sqlSession.getMapper(MemberRepository.class);
	}
	
	// 전체 멤버 리스트 + page
	@Override
	public Map<String, Object> findAllMember(Integer page) {
		int totalRecord = repository.selectMemberCount();
	
		// paging 처리
		PageUtils pageUtils = new PageUtils();
		pageUtils.setPageEntity(totalRecord, page);
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("beginRecord", pageUtils.getBeginRecord());
		m.put("endRecord", pageUtils.getEndRecord());
		
		List<Member> list = repository.selectMameberList(m);                  
// paging처리시 selectMemberList(pageUtils)로 DB에서 pageUtil에 있는 필드를 모두 사용할 수 있게 할 수 있지만, 그동안 해왔던 프로젝트에서 검색된 목록도 페이지 처리를 했고, 
// 검색어는 pageUtil에 없는 필드이기 때문에 Map객체(pageUtil 필드 + 확장가능)를 이용해서 db에 전달했다. 
// => pageUtil에 있는 필드만 활용하는 페이징처리라면 Map이 아닌 pageUtils로 넘겨도 된다.
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageUtils", pageUtils);
		map.put("list", list); 

		logger.info(map.toString());
		return map;
	}
	
	

	// 멤버 상세보기
	@Override
	public Map<String, Object>  findMember(Long memberNo) {
		Member member = repository.selectMemberByNo(memberNo);
		Map<String, Object> map = new HashMap<>();
		map.put("member", member);
		return map;
	}
	
	
	
	// 멤버 등록하기
	@Override
	public Map<String, Object> addMember(Member member) {  // 받아온 member에는 memberNo가 없다
		// db로 member를 보내면 selectKey 태그로 member에 memberNo가 저장됨.
		int result = repository.insertMember(member);   // 삽입을 하면 삽입된 번호가 나온다. mapper의 selectKey 태그를 사용하는 쿼리를 등록했다. selectKey 때문에 요청자가 no를 보내지 않았지만 no가 생겨버린다. 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);                    // 성공 유무 판단용 0 또는 1
		map.put("memberNo", member.getMemberNo());    // DB를 다녀온 뒤에는 member에 memberNo가 있다.
		return map; 
	}

	
	
	
	// 멤버 수정하기
	@Override
	public Map<String, Object> modifyMember(Member member) {
		int result = repository.updateMember(member);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result); 
		return map;
	}
	
	
	
	// 멤버 삭제하기
	@Override
	public Map<String, Object> removeMember(Long memberNo) {
		int result = repository.deleteMember(memberNo);
		Map<String, Object> map = new HashMap<>();
		map.put("result", result);
		return  map; 
	}
}
