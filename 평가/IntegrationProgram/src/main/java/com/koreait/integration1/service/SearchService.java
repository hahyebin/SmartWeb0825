package com.koreait.integration1.service;

import java.util.List;
import java.util.Map;

import com.koreait.integration1.domain.SearchBoard;

public interface SearchService {

	
		//  목록
		public List<SearchBoard> findAllMovie();
		
		
		//  검색
		public List<SearchBoard> findMovie(Map<String, Object> map);
	
}
