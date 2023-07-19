package com.xworkz.train.configaration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.xworkz")
public class SpringConfigaration {

	public SpringConfigaration() {
		System.out.println("springconfigaration is created " + this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}

	@Bean
	public ViewResolver resolver() {
		System.out.println("nanu viewresolver bande " + this.getClass().getSimpleName());
		return new InternalResourceViewResolver("/", ".jsp");

	}

	@Bean
	MultipartResolver resolver2() {
		System.out.println(" resolver2");

		return new StandardServletMultipartResolver();
	}

}
