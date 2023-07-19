package com.xworkz.bus.configaration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.xworkz")
public class BusConfigaration {

	public BusConfigaration() {
		System.out.println("busconfigaration is created :" + this.getClass().getSimpleName());

	}

	@Bean
	public ViewResolver resolver() {

		System.out.println("this is view resolver");
		return new InternalResourceViewResolver("/", ".jsp");
	}

}
