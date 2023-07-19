package com.xworkz.util.employees;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import lombok.Getter;
@Getter
public class FoctoryUtil {
	private  static EntityManagerFactory factory;
	
	
	public static EntityManagerFactory getFactory() {
		return factory;
	}
	
	
	
	static {
		
		factory= Persistence.createEntityManagerFactory("com.xworkz");
		
		
	}

}
