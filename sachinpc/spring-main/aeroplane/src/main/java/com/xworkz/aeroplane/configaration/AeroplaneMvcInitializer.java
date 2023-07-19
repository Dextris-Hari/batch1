package com.xworkz.aeroplane.configaration;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;

import org.apache.tomcat.jni.File;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AeroplaneMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
		implements WebMvcConfigurer {
	private Class[] servletConfigClasses = { SpringConfigaration.class };
	private String[] servletMappings = { "/" };

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return servletConfigClasses;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return servletMappings;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	    @Override
	    protected void customizeRegistration(ServletRegistration.Dynamic registration) {

	    	
	    	java.io.File file = new java.io.File("C:/Users/Dell/Desktop/MANOJ");
	    	MultipartConfigElement element = new MultipartConfigElement(file.getAbsolutePath(), 100000000, 100000000*2, 100000000/2);
	    	registration.setMultipartConfig(element);
	    	
	    	super.customizeRegistration(registration);
	    }

}
