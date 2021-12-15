package com.koreait.integration.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.koreait.integration.domain.Book;

@Service
public interface BookService {
	
	// 책 등록
	public int addBook(Book book);

	
	// 책 목록
	public List<Book> findAllBook();
	
	
	// 책 검색
	public List<Book> findBook(Map<String, Object> map);
	
	
}
