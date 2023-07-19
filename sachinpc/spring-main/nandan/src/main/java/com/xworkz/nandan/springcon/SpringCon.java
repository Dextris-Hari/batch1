package com.xworkz.nandan.springcon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = ("com"))
public class SpringCon {

	public SpringCon() {
		super();
		System.out.println(" created by default con spring con");
		// TODO Auto-generated constructor stub
	}

	@Bean
	ViewResolver resolver() {
		System.out.println("running on the resolver");

		return new InternalResourceViewResolver("/", ".jsp");
	}
	 @Bean
	 MultipartResolver multipartResolver() {
		 
		 System.out.println(" running on the multi");
		 return new StandardServletMultipartResolver();
	 }

}
