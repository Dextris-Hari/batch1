package com.xworkz.mobile.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@ComponentScan(basePackages = "com.xworkz")
public class MobileConfiguration {

	public MobileConfiguration() {
		System.out.println("Mobile configuration bean is created");
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean containerEntityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		

		return emf;

	}

}
