package com.xworkz.lap.springcon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com")
public class Springcon {

	public Springcon() {
		super();
		System.out.println("Springcon created");
		// TODO Auto-generated constructor stub
	}

	@Bean
	ViewResolver resolver() {

		System.out.println("resolver running");
		return new InternalResourceViewResolver("/", ".jsp");
	}
@Bean
	MultipartResolver multipartResolver() {
		System.out.println(" running multipartResolver ");

		return new StandardServletMultipartResolver();
	}

}
