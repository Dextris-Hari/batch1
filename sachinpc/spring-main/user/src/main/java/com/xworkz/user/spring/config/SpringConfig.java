package com.xworkz.user.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages ="com.xworkz")
public class SpringConfig {

	public SpringConfig() {
		System.out.println("this is spring config:" + this.getClass().getSimpleName());
	}

	@Bean
	ViewResolver resolver() {
		System.out.println("viewResolver");

		return new InternalResourceViewResolver("/", ".jsp");
	}

	@Bean
	public MultipartResolver multipartResolver() {

		System.out.println("multi");
		return new StandardServletMultipartResolver();
	}
}
