package com.koreait.integration1.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.koreait.integration1.domain.SearchBoard;
import com.koreait.integration1.repository.SearchBoardRepository;

public class SearchServiceImpl implements SearchService {
	
	  private final static Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<SearchBoard> findAllMovie() {
		SearchBoardRepository repository = sqlSession.getMapper(SearchBoardRepository.class);
		logger.info(repository.findAllMovie()+"");
		return repository.findAllMovie();
	}

	@Override
	public List<SearchBoard> findMovie(Map<String, Object> map) {
		SearchBoardRepository repository = sqlSession.getMapper(SearchBoardRepository.class);
		return repository.findMovie(map);
	}

}
