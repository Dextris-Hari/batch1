package com.xworkz.user1.mvc.initializer;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.xworkz.user1.spring.config.UserSpringConfig;

public class User1MVCInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
		implements WebMvcConfigurer {

	private Class[] getServletConfigClasses = { UserSpringConfig.class };
	private String[] getServletMappings = { "/" };

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println(" running getRootConfigClasses");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println(" running  getServletConfigClasses");

		return getServletConfigClasses;
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println(" running getServletMappings");
		// TODO Auto-generated method stub
		return getServletMappings;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}
