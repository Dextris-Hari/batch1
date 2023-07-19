package com.xworkz.springcon;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Manoj1MVCInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {
	private Class[] m = { SpringCon.class };
	private String[] n = { "/" };

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return m;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return n;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

		configurer.enable();
	}

}
