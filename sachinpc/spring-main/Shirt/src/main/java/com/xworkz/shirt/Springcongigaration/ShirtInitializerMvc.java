package com.xworkz.shirt.Springcongigaration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ShirtInitializerMvc extends AbstractAnnotationConfigDispatcherServletInitializer
		implements WebMvcConfigurer {

	private Class[] ServletConfigClasses = { SpringConfigaration.class };
	private String[] ServletMappings = { "/" };

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println(" nanu enu madthila");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return ServletConfigClasses;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return ServletMappings;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}
