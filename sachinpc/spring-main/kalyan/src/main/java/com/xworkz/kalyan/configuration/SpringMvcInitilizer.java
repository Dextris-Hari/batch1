package com.xworkz.kalyan.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMvcInitilizer extends AbstractAnnotationConfigDispatcherServletInitializer {
public SpringMvcInitilizer() {
	System.out.println("mvc initi");
}
	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("running getRootConfigClasses ");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("running getServletConfigClasses ");
		return new Class[]  {SpringConfiguration.class,DbProperties.class};
	}

	@Override
	protected String[] getServletMappings() {
		
		
		return new String[] {"/"};
	}

}
