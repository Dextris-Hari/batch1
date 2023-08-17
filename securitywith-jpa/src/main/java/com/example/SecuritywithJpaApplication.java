package com.example;

import com.example.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SecuritywithJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuritywithJpaApplication.class, args);
	}

}
