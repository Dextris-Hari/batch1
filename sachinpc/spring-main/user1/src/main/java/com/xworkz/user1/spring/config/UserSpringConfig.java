package com.xworkz.user1.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.xworkz.user1.spring.config.functional.ViewResolver;

@Configuration
@ComponentScan(basePackages = "com")
public class UserSpringConfig {

	public UserSpringConfig() {
		super();
		System.out.println(" this is user1 object created" + this.getClass().getSimpleName());
	}

	ViewResolver resolver = () -> {
		System.out.println("viewresolver");

		return new InternalResourceViewResolver("/", ".jsp");
	};

	public org.springframework.web.servlet.ViewResolver resolver2() {

		return this.resolver.resolver();
	}

}
