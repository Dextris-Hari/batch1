package com.xworkz.shirt.Springcongigaration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com")
public class SpringConfigaration {

	public SpringConfigaration() {
		// TODO Auto-generated constructor stub
		System.out.println("nanu Springconfigaration " + this.getClass().getSimpleName());
	}

	@Bean
	ViewResolver resolver() {

		System.out.println("nanu resolver method ");

		return new InternalResourceViewResolver("/", ".jsp");
	}

}
