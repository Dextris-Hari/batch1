package com.dextris.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TransactionalManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionalManagementApplication.class, args);
	}

}
