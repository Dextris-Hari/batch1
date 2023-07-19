package com.xworkz.user1.spring.config.functional;

@FunctionalInterface
public interface DataSource {

	javax.sql.DataSource source();

}
