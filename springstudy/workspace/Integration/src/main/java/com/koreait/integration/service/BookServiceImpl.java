package com.koreait.integration.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.koreait.integration.domain.Book;
import com.koreait.integration.repository.BookRepository;

public class BookServiceImpl implements BookService {

	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
   // 책 등록하기	
	@Override
	public int addBook(Book book) {
		BookRepository repository = sqlSession.getMapper(BookRepository.class);
		return repository.insertBook(book);
	}
	
	// 책 리스트 가져오기
	@Override
	public List<Book> findAllBook() {
		BookRepository repository = sqlSession.getMapper(BookRepository.class);
		return repository.findAllBook();
	}
	
	// 책검색하기
	@Override
	public List<Book> findBook(Map<String, Object> map) {
		BookRepository repository = sqlSession.getMapper(BookRepository.class);
		//System.out.println(map.toString());
		return repository.findBook(map);
	}

}
