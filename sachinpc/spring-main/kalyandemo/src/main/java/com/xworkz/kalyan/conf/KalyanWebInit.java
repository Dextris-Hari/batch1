package com.xworkz.kalyan.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class KalyanWebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
	Class[] getServletConfigClasses = { KalyanConf.class };
	String[] getServletMappings= {"/"};

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return getServletConfigClasses;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return getServletMappings;
	}

}
