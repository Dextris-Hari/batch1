package com.xworkz.kalyan.conf;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataCon {

	public DataCon() {
		super();
		System.out.println("created data con");
		// TODO Auto-generated constructor stub
	}

	@Bean
	DataSource dataSource() {

		DriverManagerDataSource source = new DriverManagerDataSource();

		source.setDriverClassName("com.mysql.cj.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/user");
		source.setPassword("manoj@123");
		source.setUsername("root");
		return source;
	}

	@Bean
	LocalContainerEntityManagerFactoryBean bean(DataSource source) {

		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setPackagesToScan("com");
		bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		bean.setDataSource(source);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("hibernate.show_sql", true);
		map.put("hibernate.formate_sql", true);
		bean.setJpaPropertyMap(map);
		return bean;
	}

}
