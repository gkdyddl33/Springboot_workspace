package com.koreait.bootapp20210208;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 원래는 메인 클래스에서 작성해도 되지만, 관리 목적상 별도의 클래스로 분리시켜보았다!!
// 스프링은 버전이 올라갈수록 XML --> 자바코드에서의 설정
@Configuration
public class MybatisConfigManager {
	// 스프링의 빈을 관리하는 객체(메모리에 올라와 있는 클래스를 사용하기 위해 담아져 있는 컨테이너를 이용)
	@Autowired
	private ApplicationContext applicationContext;
	
	// 레거시 시절 등록했던 mybatis spring  에 대한 설정을 여기서 처리해보자!
	// SqlSessionFactory, SqlSessionTemplate
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		// mybatis 설정 파일의 위치
		sqlSessionFactory.setConfigLocation(applicationContext.getResource("classpath:com/koreait/bootapp20210208/mybatis/config/config.xml"));				
		return sqlSessionFactory.getObject();		
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {// 둘이 의존관계..
		return new SqlSessionTemplate(sqlSessionFactory);		
	}
	
	@Bean
	public org.apache.ibatis.session.Configuration mybatisConfig() {
		return new org.apache.ibatis.session.Configuration();
	}
	
}
