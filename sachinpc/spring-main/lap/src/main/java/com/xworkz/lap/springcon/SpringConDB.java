package com.xworkz.lap.springcon;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class SpringConDB {

	public SpringConDB() {
		super();
		System.out.println("SpringConDB created ");
		// TODO Auto-generated constructor stub
	}

	@Bean
	DataSource SpringConDB() {

		System.out.println(" running SpringConDB");
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName("com.mysql.cj.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/shirt");//"jdbc:mysql://localhost:3306/shirt"
		source.setPassword("manoj@123");
		source.setUsername("root");

		return source;
	}

	@Bean
	LocalContainerEntityManagerFactoryBean bean(DataSource dataSource) {

		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setPackagesToScan("com");

		bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		bean.setDataSource(dataSource);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("hibernate.show_sql", true);
		hashMap.put("hibernate.formate", true);
		bean.setJpaPropertyMap(hashMap);

		return bean;
	}

}
