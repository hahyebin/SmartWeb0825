package com.koreait.ex10.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.ex10.repository.NoticeRepository;
import com.koreait.ex10.service.NoticeService;
import com.koreait.ex10.service.NoticeServiceImpl;

@Configuration
public class NoticeConfig {

	
	@Bean
	public NoticeRepository repository() {
		return new NoticeRepository();
	}
	
	@Bean   // 등록해야 다른곳에서 이 메서드 Bean을 사용하고자하는 Autowired 가능하다.
	public NoticeService service() {
		return new NoticeServiceImpl();
	}
	
	
	
}
