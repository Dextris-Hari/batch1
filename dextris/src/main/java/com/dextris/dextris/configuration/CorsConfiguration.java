package com.dextris.dextris.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {
    private static final String GET = "GET";
    private static final String PUT = "PUT";
    private static final String POST = "POST";
    private static final String DELETE = "DELETE";

    public CorsConfiguration() {
        System.out.println(" configaration class corsConfigaration+"+this.getClass().getSimpleName());
    }

    @Bean
    public WebMvcConfigurer corsConfigurations() {
        System.out.println(" inside corsConfigurations method cus ");

        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                System.out.println(" inside addCorsMappings method");

                registry.addMapping("/**").allowedMethods(GET, PUT, DELETE, POST).allowedHeaders("*").
                        allowedOriginPatterns("*").allowCredentials(true);
            }
        };
    }


}
