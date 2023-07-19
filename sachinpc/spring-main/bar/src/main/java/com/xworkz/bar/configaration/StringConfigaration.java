package com.xworkz.bar.configaration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com")
public class StringConfigaration {
	public StringConfigaration() {
		// TODO Auto-generated constructor stub
		System.out.println(" i am spring configaration " + this.getClass().getSimpleName());
	}
  @Bean
	ViewResolver resolver() {

		return new InternalResourceViewResolver("/", ".jsp");

	}

}
