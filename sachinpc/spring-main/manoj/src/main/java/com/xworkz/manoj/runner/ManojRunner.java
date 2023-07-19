package com.xworkz.manoj.runner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xworkz.manojentity.ManojEntity;
import com.xworkz.manojserviceimpl.ManojServiceImpl;

public class ManojRunner {
	public static void main(String[] args) {
		ManojEntity entity = new ManojEntity(1, "manoj", "jayaram", "jyothi");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.xworkz");
		ManojServiceImpl bean = context.getBean(ManojServiceImpl.class);

		boolean validAndSave = bean.validAndSave(entity);
		System.out.println(validAndSave);

	}

}
