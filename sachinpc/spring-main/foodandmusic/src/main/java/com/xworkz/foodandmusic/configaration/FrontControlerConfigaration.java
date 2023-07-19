package com.xworkz.foodandmusic.configaration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class FrontControlerConfigaration extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("running in get servletconfigclasses");
		return new Class[]{SpringConfigaration.class};
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("running in getservletmapping");
		
		return new String[] {"*.manoj"};
	}

}
