package com.koreait.ex03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.ex03.domain.Member;

@Configuration
public class MemberConfig {
	
	@Bean
	public Member member1() {  //패키지 다르기 때문에 타입은 Member는 import이다.    <bean class="Member" id="member1" />
		Member member = new Member();
		member.setId("admin");
		member.setPw("1234");
		return member;
	}
	
	
	@Bean
	public Member member2() {     //   <bean class="Member" id="member2" />
		return new Member("webmaster", "5678");
	}
	
	
}
