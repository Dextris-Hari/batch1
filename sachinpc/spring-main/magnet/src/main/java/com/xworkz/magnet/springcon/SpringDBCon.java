package com.xworkz.magnet.springcon;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class SpringDBCon {

	public SpringDBCon() {
		super();
		// TODO Auto-generated constructor stub
	}
@Bean
	DataSource source() {

		DriverManagerDataSource source = new DriverManagerDataSource();

		source.setUsername("root");
		source.setDriverClassName("com.mysql.cj.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/shirt");
		source.setPassword("manoj@123");
		return source;

	}
	@Bean
	LocalContainerEntityManagerFactoryBean bean(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean bean = 
				new LocalContainerEntityManagerFactoryBean();
		
		bean.setPackagesToScan("com");
		bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		bean.setDataSource(dataSource);
		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("hibernate.show_sql", true);
		hashMap.put("hibernate.format_sql", true);
		bean.setJpaPropertyMap(hashMap);
		return bean;
		
	}

}
