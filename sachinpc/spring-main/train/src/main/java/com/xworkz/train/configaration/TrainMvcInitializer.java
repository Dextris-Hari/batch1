package com.xworkz.train.configaration;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class TrainMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
		implements WebMvcConfigurer {
	private Class[] ServletConfigClasses = { SpringConfigaration.class };
	private String[] ServletMappings = { "/" };

	public TrainMvcInitializer() {
		System.out.println("trainmvcinitializer is created hen evaga" + this.getClass().getSimpleName());
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("nanu barala hen evaga");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("nanu getservaletconfigclass");
		// TODO Auto-generated method stub
		return ServletConfigClasses;
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("nanu getservaletmappings hen evaga");
		// TODO Auto-generated method stub
		return ServletMappings;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		System.out.println("nanu enable madde");
		configurer.enable();
	}

	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		System.out.println(" size of the file ");
		// TODO Auto-generated method stub
		File file = new File("C:/Users/Dell/Desktop/MANOJ");
		MultipartConfigElement element = new MultipartConfigElement(file.getAbsolutePath(), 10000000, 10000000 * 2,
				10000000 / 2);
		registration.setMultipartConfig(element);
	}

}
