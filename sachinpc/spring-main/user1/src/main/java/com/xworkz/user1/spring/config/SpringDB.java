package com.xworkz.user1.spring.config;

import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.xworkz.user1.spring.config.functional.DataSource;
import com.xworkz.user1.spring.config.functional.EntityManagerFactory;

import freemarker.core.ReturnInstruction.Return;
import lombok.Data;

@Configuration
public class SpringDB {

	public SpringDB() {
		super();
		System.out.println("this is db configaration " + this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}

	@Bean
	public javax.sql.DataSource dataSource() {
		return this.source.source();

	}

	DataSource source = () -> {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbs:mysql://localhost:3306/user");
		dataSource.setUsername("root");
		dataSource.setPassword("manoj@1233");
		return dataSource;
	};

	EntityManagerFactory factory = (source) -> {

		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setPackagesToScan("com");
		bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		HashMap<String, Object> map = new HashMap<>();
		map.put("hibernate.show_sql", true);
		map.put("hibernate.formate_sql", true);
		bean.setJpaPropertyMap(map);
		return bean;
	};

	@Bean
	public LocalContainerEntityManagerFactoryBean bean(javax.sql.DataSource dataSource) {

		return factory.bean(dataSource);

	}

}
