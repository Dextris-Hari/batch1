package com.xworkz.nanadanconfigure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
@Configuration
@ComponentScan(basePackages = "com.xworkz")
public class NandanCon {
	public NandanCon() {
		System.out.println("nandan con is created");
	}

	@Bean
	LocalContainerEntityManagerFactoryBean bean() {
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		return bean;
	}
}
