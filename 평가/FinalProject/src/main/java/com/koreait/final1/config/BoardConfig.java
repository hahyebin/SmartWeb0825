package com.koreait.final1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.final1.service.BoardService;
import com.koreait.final1.service.BoardServiceImpl;

@Configuration
public class BoardConfig {
	  
		@Bean
		public BoardService service() {
			return new BoardServiceImpl();
		}
		
		
}
