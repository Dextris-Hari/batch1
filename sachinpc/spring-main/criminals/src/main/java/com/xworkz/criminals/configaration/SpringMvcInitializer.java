package com.xworkz.criminals.configaration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
		implements WebMvcConfigurer {
	private Class[] ServletConfigClasses = { SpringConfigaration.class };
	private String[] ServletMappings = { "/" };

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println(" nanu holage henu ella");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println(" nanu getservletconfigvlasses method");
		// TODO Auto-generated method stub
		return ServletConfigClasses;
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println(" nanu getservletmappings");
		// TODO Auto-generated method stub
		return ServletMappings;
	}
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}
