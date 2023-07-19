package com.xworkz.milkshop.configurationdb;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration

public class DBConfigaration {
	public DBConfigaration() {
		// TODO Auto-generated constructor stub
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean bean(DataSource source) {

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setPackagesToScan("com.xworkz");
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factoryBean.setDataSource(source);

		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("hibernate.show_sql", true);
		factoryBean.setJpaPropertyMap(hashMap);
		return factoryBean;
	}

	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource source = new DriverManagerDataSource();
		

		return source;
	}
}
