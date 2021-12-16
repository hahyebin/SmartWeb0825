package com.koreait.integration1.repository;

import java.util.List;
import java.util.Map;

import com.koreait.integration1.domain.SearchBoard;

public interface SearchBoardRepository {
	//  목록보기
	public List<SearchBoard> findAllMovie();
	
	// 검색
	public List<SearchBoard> findMovie(Map<String, Object> map);
}
