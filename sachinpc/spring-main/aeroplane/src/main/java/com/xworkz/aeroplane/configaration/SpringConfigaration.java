package com.xworkz.aeroplane.configaration;

import javax.servlet.annotation.MultipartConfig;

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
		System.out.println(" nanu configarationu" + this.getClass().getSimpleName());
	}

	@Bean
	ViewResolver resolver() {

		return new InternalResourceViewResolver("/", ".jsp");
	}
@Bean
	MultipartResolver config() {

		System.out.println(" i am working multipart resolver");
		return new StandardServletMultipartResolver();
	}
}
