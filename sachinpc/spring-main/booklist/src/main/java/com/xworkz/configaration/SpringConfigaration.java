package com.xworkz.configaration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com")
public class SpringConfigaration {
	public SpringConfigaration() {
		System.out.println(" nanu spring configaration " + this.getClass().getSimpleName());

		// TODO Auto-generated constructor stub
	}
	
	@Bean
	 ViewResolver resolver() {
		 
		 System.out.println("nanu view resolver method ");
		 
		 return new InternalResourceViewResolver("/", ".jsp");
	 }
	
	
	

}
