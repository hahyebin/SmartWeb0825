package com.koreait.ex10.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.koreait.ex10.domain.Notice;

public class NoticeRepository {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 목록보기
	public List<Notice> selectNoticeList(){
	    return sqlSession.selectList("mapper.notice.selectNoticeList");
	}
	
	
	// 상세보기
	public Notice selectNoticeByNo(Long no) {
		return sqlSession.selectOne("mapper.notice.selectNoticeByNo", no);
	}
	
	// 등록하기
	public int insertNotice(Notice notice) {
		return sqlSession.insert("mapper.notice.insertNotice", notice);
	}
	
	// 수정하기
	public int updateNotice(Notice notice) {
		return sqlSession.update("mapper.notice.updateNotice", notice);
	}
	
	
	// 삭제하기
	public int deleteNotice(Long no) {
		return sqlSession.delete("mapper.notice.deleteNotice", no);
	}
	
}
