package com.xworkz.bus.configaration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class BusSpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
		implements WebMvcConfigurer {

	private Class[] ServletConfigClasses = {BusConfigaration.class};
	private String[] ServletMappings = {"/"};

	public BusSpringMvcInitializer() {

		System.out.println("busSpringinitialier is created " + this.getClass().getSimpleName());
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return ServletConfigClasses;
	}

	@Override
	protected String[] getServletMappings() {
		return ServletMappings;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}
