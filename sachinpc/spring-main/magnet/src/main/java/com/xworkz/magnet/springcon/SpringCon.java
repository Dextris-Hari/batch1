package com.xworkz.magnet.springcon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import io.quarkus.runtime.annotations.ConfigGroup;

@ConfigGroup
@ComponentScan(basePackages = "com")

public class SpringCon {

	public SpringCon() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Bean
	ViewResolver resolver() {

		return new InternalResourceViewResolver("/", ".jsp");
	}

}
