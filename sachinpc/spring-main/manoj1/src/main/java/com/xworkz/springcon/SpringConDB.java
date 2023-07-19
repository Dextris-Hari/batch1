package com.xworkz.springcon;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class SpringConDB {
	@Bean
	DataSource source() {

		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName("com.mysql.cj.jdbc.Driver");
		source.setUrl("jdbc:mysql//localhost:3306/shirt");
		source.setUrl("root");
		source.setPassword("manoj@123");
		return source;
	}

	@Bean
	LocalContainerEntityManagerFactoryBean bean(DataSource source) {
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setPackagesToScan("com");
		bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		bean.setDataSource(source);
		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("hibernate.show_sql", true);
		bean.setJpaPropertyMap(hashMap);
		return bean;

	}
}
