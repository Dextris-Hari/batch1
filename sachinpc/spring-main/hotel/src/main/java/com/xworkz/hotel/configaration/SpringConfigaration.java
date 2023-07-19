package com.xworkz.hotel.configaration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com")
public class SpringConfigaration {
	public SpringConfigaration() {
		System.out.println(" spring comfigaration class is created " + this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}
@Bean
	ViewResolver resolver() {

		System.out.println(" view resolver method is running");

		return new InternalResourceViewResolver("/", ".jsp");
	}

}
