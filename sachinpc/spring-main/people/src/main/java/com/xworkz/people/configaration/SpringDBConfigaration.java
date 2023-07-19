package com.xworkz.people.configaration;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class SpringDBConfigaration {

	public SpringDBConfigaration() {
		System.out.println("created" + " " + this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}

	@Bean
	DataSource source() {

		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName("com.mysql.cj.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/shirt");
		source.setUsername("root");
		source.setPassword("manoj@123");
		return source;
	}
@Bean
	LocalContainerEntityManagerFactoryBean bean(DataSource source) {

		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setPackagesToScan("com");
		bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		bean.setDataSource(source());
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("hibernate.show_sql", true);
		hash.put("hibernate.formate_sql", true);
		bean.setJpaPropertyMap(hash);
		return bean;
	}

}
