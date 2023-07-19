package com.xworkz.configaration;

import java.util.HashMap;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class SpringConfigarationDB {
	public SpringConfigarationDB() {
		System.out.println(" nanu SpringConfigarationDB" + this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}

	@Bean
	LocalContainerEntityManagerFactoryBean bean(DataSource source) {

		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setPackagesToScan("com");
		bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		bean.setDataSource(source);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("hibernate.show_sql", true);
		bean.setJpaPropertyMap(map);
		return bean;
	}

	@Bean
	DataSource dataSource() {
		DriverManagerDataSource source = new DriverManagerDataSource();

		source.setDriverClassName("com.mysql.cj.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/shirt");
		source.setPassword("manoj@123");
		source.setUsername("root");

		return source;

	}

}
