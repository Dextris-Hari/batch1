package com.xworkz.spring.configaration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.xworkz")
public class SpringConfigaration {
	public SpringConfigaration() {
		System.out.println(" nanu springconfigaration " + this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}

	@Bean
	ViewResolver resolver() {
		System.out.println(" nanu resolver method");

		return new InternalResourceViewResolver("/", ".jsp");

	}

}
