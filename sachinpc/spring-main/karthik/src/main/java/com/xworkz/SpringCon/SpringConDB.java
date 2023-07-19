package com.xworkz.SpringCon;

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
		System.out.println(" i am springConDB");
		// TODO Auto-generated constructor stub
	}

	@Bean
	DataSource source() {
		System.out.println(" running on the source");

		DriverManagerDataSource source = new DriverManagerDataSource();

		source.setDriverClassName("com.mysql.cj.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/shirt");
		source.setPassword("manoj@123");
		source.setUsername("root");
		return source;
	}
@Bean
	LocalContainerEntityManagerFactoryBean bean(DataSource source) {
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setPackagesToScan("com.xworkz");
		bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		bean.setDataSource(source);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();

		Object put = hashMap.put("hibernate.show_sql", true);
		hashMap.put("hibernate.formate_sql", true);
		bean.setJpaPropertyMap(hashMap);

		return bean;
	}

}
