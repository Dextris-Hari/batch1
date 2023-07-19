package com.xworkz.nanadanRunner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xworkz.nanadanconfigure.NandanCon;
import com.xworkz.nanadanentity.NandanEntity;
import com.xworkz.nanadanserviceimpl.NandanServiceImpl;

public class NnandanRunner {
	public static void main(String[] args) {
		NandanEntity entity = new NandanEntity(1, "ninde", "xyz");

		AnnotationConfigApplicationContext context = new 
				AnnotationConfigApplicationContext(NandanCon.class);
		NandanServiceImpl bean = context.getBean(NandanServiceImpl.class);
		String validAndSave = bean.validAndSave(entity);
		System.out.println(validAndSave);

	}

}
