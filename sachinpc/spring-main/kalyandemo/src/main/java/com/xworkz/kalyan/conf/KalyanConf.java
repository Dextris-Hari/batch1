package com.xworkz.kalyan.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com")
public class KalyanConf {

	public KalyanConf() {
		super();
		System.out.println("created conf");
	}

	@Bean
	ViewResolver resolver() {

		return new InternalResourceViewResolver("/", ".jsp");
	}

}
