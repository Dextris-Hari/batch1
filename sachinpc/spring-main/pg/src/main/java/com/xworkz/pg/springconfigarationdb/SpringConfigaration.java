package com.xworkz.pg.springconfigarationdb;

import javax.swing.text.View;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com")
public class SpringConfigaration {

	public SpringConfigaration() {
		System.out.println(" nanu Spring configaration " + this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}

	@Bean
	ViewResolver resolver() {
		System.out.println(" nanu method resolver");
		return new InternalResourceViewResolver("/", ".jsp");

	}
@Bean
	public MultipartResolver multipartResolver() {

		System.out.println("multi");
		return new StandardServletMultipartResolver();
	}

}
