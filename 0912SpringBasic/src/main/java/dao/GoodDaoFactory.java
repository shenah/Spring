package dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//BeanFactory 클래스 

@Configuration
public class GoodDaoFactory {
	@Bean
	//Factory Method 패턴이 적용된 메소드 
	public static GoodDao create() {
		return new GoodDao();
	}
}
