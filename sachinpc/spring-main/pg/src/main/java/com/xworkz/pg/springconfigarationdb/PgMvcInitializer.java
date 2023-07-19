package com.xworkz.pg.springconfigarationdb;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;

import org.apache.tomcat.jni.File;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class PgMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {
	private Class[] ServletConfigClasses = { SpringConfigaration.class };
	private String[] ServletMappings = { "/" };

	public PgMvcInitializer() {
		System.out.println(" nanu mvc" + this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println(" servlet methods");
		// TODO Auto-generated method stub
		return ServletConfigClasses;
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println(" nanu method adre mapping madthini");
		// TODO Auto-generated method stub
		return ServletMappings;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	@Override
	protected void customizeRegistration( ServletRegistration.Dynamic registration) {
		
		System.out.println(" registratio");
		
		java.io.File file = new java.io.File("C:/Users/Dell/Desktop/MANOJ");//   C:\Users\Dell\Desktop\MANOJ
		MultipartConfigElement multipartConfigElement =
				new MultipartConfigElement(file.getAbsolutePath(),100000000,100000000*2,100000000/2);
		
		registration.setMultipartConfig(multipartConfigElement);
	}

}
