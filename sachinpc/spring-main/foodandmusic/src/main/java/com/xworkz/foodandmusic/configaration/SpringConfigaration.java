package com.xworkz.foodandmusic.configaration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz")
public class SpringConfigaration {
	
	
	public SpringConfigaration() {
		System.out.println("Springconfigaration created"+this.getClass().getSimpleName());
	}

}
