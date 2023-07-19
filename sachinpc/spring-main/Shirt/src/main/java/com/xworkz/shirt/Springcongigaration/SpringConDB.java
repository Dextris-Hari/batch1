package com.xworkz.shirt.Springcongigaration;

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
		// TODO Auto-generated constructor stub
		System.out.println("nanu SpringConDB "+this.getClass().getSimpleName());
	}
    @Bean
	LocalContainerEntityManagerFactoryBean bean(DataSource dataSource) {

		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setPackagesToScan("com.xworkz");
		bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		bean.setDataSource(dataSource);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("Hibernate.show_sql", true);
		bean.setJpaPropertyMap(map);
		return bean ;

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
