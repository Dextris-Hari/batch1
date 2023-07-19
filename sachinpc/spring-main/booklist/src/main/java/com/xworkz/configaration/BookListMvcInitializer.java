package com.xworkz.configaration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class BookListMvcInitializer extends
AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {
	private Class[] ServletConfigClasses= {SpringConfigaration.class};
	private String[] ServletMappings= {"/"};
	public BookListMvcInitializer() {
		System.out.println(" Booklistmvcinitializer"+this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println(" nan holage henu ella nanu henu madtha ella ");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println(" nanu serveletconfigClass method ");
		// TODO Auto-generated method stub
		return ServletConfigClasses;
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println(" nan ServletMappings method ");
		// TODO Auto-generated method stub
		return ServletMappings;
	}
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}
