package com.xworkz.cinimacom.xworkz.cinimaconfigure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = "com.xworkz")
public class CinimaConfigure {
	public CinimaConfigure() {
		System.out.println(" cinima comfigure is created ");
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean bean() {
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return bean;
	}

}
