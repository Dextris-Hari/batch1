package com.xworkz.SpringCon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com")
public class SpringCon {

	public SpringCon() {
		super();
		System.out.println(" springcon is created ");
		// TODO Auto-generated constructor stub
	}

	@Bean
	ViewResolver resolver() {

		System.out.println(" running on resolver");

		return new InternalResourceViewResolver("/", ".jsp");
	}

//	@Bean
//	 MultipartResolver multipartResolver() {
//		 
//		 System.out.println(" running on multipartResolver ");
//		 
//		 return new StandardServletMultipartResolver();
//	 }
//	
	@Bean
	public MultipartResolver multipartResolver() {

		System.out.println("multi");
		return new StandardServletMultipartResolver();
	}

}
