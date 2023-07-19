package com.xworkz.bar.configaration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class BarMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
		implements WebMvcConfigurer {
	private Class[] ServletConfigClasses = { StringConfigaration.class };
	private String[] ServletMappings = { "/" };
      public BarMvcInitializer() {
		System.out.println("mvc ini");
	}
	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println(" nan holage henu ella ");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		System.out.println(" nanu getservletconficlasses");
		return ServletConfigClasses;
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println(" nanu getservletmapping");
		// TODO Auto-generated method stub
		return ServletMappings;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();

	}

}
