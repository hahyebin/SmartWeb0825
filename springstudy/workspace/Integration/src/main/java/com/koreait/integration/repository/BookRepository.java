package com.koreait.integration.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.koreait.integration.domain.Book;

@Repository
public interface BookRepository {
	// 책 등록하기
	public int insertBook(Book book);
	
	// 책 목록보기
	public List<Book> findAllBook();
	
	// 책검색
	public List<Book> findBook(Map<String, Object> map);
	
}
