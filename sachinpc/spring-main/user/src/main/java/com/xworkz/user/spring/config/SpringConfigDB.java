package com.xworkz.user.spring.config;

import java.util.HashMap;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class SpringConfigDB {

	public SpringConfigDB() {
		System.out.println(" this is DB config" + this.getClass().getSimpleName());
	}

	@Bean
	DataSource dataSource() {

		DriverManagerDataSource source = new DriverManagerDataSource();

		source.setDriverClassName("com.mysql.cj.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/manoj");
		source.setPassword("root");
		source.setUsername("root");
		Properties prop = new Properties();
		prop.setProperty("hibernate.hbm2ddl.auto", "create");
		source.setConnectionProperties(prop);

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
