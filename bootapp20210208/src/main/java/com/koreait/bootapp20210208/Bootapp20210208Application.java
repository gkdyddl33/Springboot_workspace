package com.koreait.bootapp20210208;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.koreait.bootapp20210208.test.Dog;

@SpringBootApplication
public class Bootapp20210208Application {

	public static void main(String[] args) {
		SpringApplication.run(Bootapp20210208Application.class, args);
	}

	// Spring 2.5 버전부터는 xml을 사용하지 않고, 자바 코드에서도 빈들을 생성 및 설정할 수 있는 방법을 제공한다.
	// 이때 사용되는 어노테이션 @Bean <bean id ="" class="대상클래스">
	@Bean
	public Dog dog() {// BoardService <bean id ="BoardService" class="대상클래스">
		return new Dog();
	}
}
