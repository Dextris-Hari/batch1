package com.xworkz.manojconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@ComponentScan(basePackages = "com.xworkz")
public class ManojConfig {
	public ManojConfig() {
		System.out.println("manojconfig is created ");
		// TODO Auto-generated constructor stub
	}
@Bean
	LocalContainerEntityManagerFactoryBean bean() {
		LocalContainerEntityManagerFactoryBean bean = 
				new LocalContainerEntityManagerFactoryBean();
		bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return bean;
	}

}
