package com.koreait.ex14.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class MybatisConfig {
    // hikari는 아주 아주 확장된 Connection Pool로 더 빠르게 만들어준다.
	// 히카리 설정을 위해서는 환경부터 맞춰줘야한다. (hikariConfig -> hikariDataSource)
	
	@Bean
	public HikariConfig hikariConfig() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		hikariConfig.setUsername("hr");
		hikariConfig.setPassword("1111");
		return hikariConfig;
	}
	
	@Bean(destroyMethod = "close")  					 // dataSource 다 쓰면 pool 닫기
	public HikariDataSource hikariDataSource() {
		return new HikariDataSource(hikariConfig());
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(hikariDataSource());
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/*.xml"));   // setMapperLocations의 매개변수는 String이 아님 때문에 파일경로를 적기 위해서 새로운 클래스를 생성해서 만든다.
		sqlSessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/mybatis-config.xml"));
		/*
			Properties properties = new Properties();
			properties.put("mapUnderscoreToCamelCase", true);
			sqlSessionFactoryBean.setConfigurationProperties(properties);
		*/
		return sqlSessionFactoryBean.getObject();
				// factory를 만드는 Bean(sqlSessionFactoryBean) -> factory를 만듦(getObject())
	}
	
	@Bean
	public SqlSessionTemplate sqlSession() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}
}
