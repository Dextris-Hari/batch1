package com.xworkz.bar.configarationdb;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class SpringConfigarationDB {
	public SpringConfigarationDB() {
		// TODO Auto-generated constructor stub
		System.out.println(" nanu SpringConfigarationDB" + this.getClass().getSimpleName());
	}

	@Bean
	LocalContainerEntityManagerFactoryBean bean(DataSource source) {

		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(source);
		bean.setPackagesToScan("com");
		bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return bean;
	}

	@Bean
	DataSource source() {

		DriverManagerDataSource source = new DriverManagerDataSource();

		source.setDriverClassName("com.mysql.cj.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/bar");
		source.setPassword("manoj@123");
		source.setUsername("root");

		return source;

	}
}
