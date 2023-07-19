package com.xworkz.cinimacom.xworkz.cinimarunner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xworkz.cinimacom.xworkz.cinimaconfigure.CinimaConfigure;
import com.xworkz.cinimacom.xworkz.cinimaentity.CinimaEntity;
import com.xworkz.cinimacom.xworkz.cinimaserviceimpl.CinimaServiceImpl;

public class CinimaRunner {
	public static void main(String[] args) {
		CinimaEntity entity = new CinimaEntity("manoj", "manoj");
		AnnotationConfigApplicationContext context = new
				AnnotationConfigApplicationContext(CinimaConfigure.class);
		 CinimaServiceImpl bean = context.getBean(CinimaServiceImpl.class);
		 boolean save = bean.validateAndSave(entity);
		 System.out.println(save);
	}

}
