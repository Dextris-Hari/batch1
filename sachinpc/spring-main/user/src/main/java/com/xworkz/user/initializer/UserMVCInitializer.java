package com.xworkz.user.initializer;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.xworkz.user.spring.config.SpringConfig;
import com.xworkz.user.spring.config.SpringConfigDB;

public class UserMVCInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
		implements WebMvcConfigurer {
	private Class[] servletConfigClasses = { SpringConfig.class, SpringConfigDB.class };
	private String[] servletMappings = { "/" };

	public UserMVCInitializer() {
		System.out.println("this is MVCInitializer" + this.getClass().getSimpleName());
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return servletConfigClasses;
	}

	@Override
	protected String[] getServletMappings() {

		return servletMappings;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	protected void customizeRegistration( ServletRegistration.Dynamic registration) {
		
		System.out.println(" registratio");
		
		java.io.File file = new java.io.File("C:/Users/Dell/Desktop/user");
		MultipartConfigElement multipartConfigElement =
				new MultipartConfigElement(file.getAbsolutePath(),100000000,100000000*2,100000000/2);
		
		registration.setMultipartConfig(multipartConfigElement);
	}

	 
}
