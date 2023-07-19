package com.xworkz.SpringCon;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class KarthikMVCInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
		implements WebMvcConfigurer {
	private Class[] getServletConfigClasses = { SpringCon.class };
	private String[] getServletMappings = { "/" };

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

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

//	@Override
//	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
//		System.out.println(" running on the customizeRegistration ");
//		File file = new File("C:/Users/Dell/Desktop/user");
//		MultipartConfigElement multipartConfigElement =
//				new MultipartConfigElement(file.getAbsolutePath(),100000000,100000000*2,100000000/2);
//		
//		registration.setMultipartConfig(multipartConfigElement);
//	}

	@Override
	protected void customizeRegistration( ServletRegistration.Dynamic registration) {
		
		System.out.println(" registratio");
		
		java.io.File file = new java.io.File("C:/Users/Dell/Desktop/Karthik");
		MultipartConfigElement multipartConfigElement =
				new MultipartConfigElement(file.getAbsolutePath(),100000000,100000000*2,100000000/2);
		
		registration.setMultipartConfig(multipartConfigElement);
	}


}
