package com.xworkz.people.configaration;

import javax.servlet.MultipartConfigElement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com")
public class PeopleConfigaration {
	public PeopleConfigaration() {
		System.out.println("created" + " " + this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}
@Bean
	ViewResolver resolver() {
		System.out.println("calling ViewResolver");

		return new InternalResourceViewResolver("/", ".jsp");
	}
@Bean
	MultipartResolver element() {
		System.out.println(" calling MultipartResolver");

		return new StandardServletMultipartResolver();
	}

}
