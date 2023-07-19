package com.xworkz.nandan.springcon;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class SpringConDb {

	public SpringConDb() {
		super();
		System.out.println(" created SpringConDb");
		// TODO Auto-generated constructor stub
	}
	@Bean
	DataSource dataSource() {
		System.out.println(" running on the datasource");
		 DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		 
		 driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		 driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/shirt");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("manoj@123");
		return driverManagerDataSource;
	
	}
	@Bean 
	LocalContainerEntityManagerFactoryBean bean(DataSource dataSource) {
		System.out.println(" running in local emf");
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
	bean.setPackagesToScan("com");
	bean.setDataSource(dataSource);
	bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	HashMap<String,Object> hashMap = new HashMap<>();
	hashMap.put("hibernatw.show_sql", true);
	hashMap.put("hibernate.format_sql", true);
	bean.setJpaPropertyMap(hashMap);
		return bean;
	}
	

}
