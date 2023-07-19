package com.xworkz.user1.spring.config.functional;

import javax.sql.DataSource;

import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@FunctionalInterface
public interface EntityManagerFactory {

	LocalContainerEntityManagerFactoryBean bean(DataSource source);

}
