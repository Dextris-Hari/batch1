package com.xworkz.springcon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com")
public class SpringCon {

	public SpringCon() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Bean
	ViewResolver resolver() {

		return new InternalResourceViewResolver("/", ".jsp");
	}

}
