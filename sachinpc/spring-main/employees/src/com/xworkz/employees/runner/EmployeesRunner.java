package com.xworkz.employees.runner;

import com.xworkz.employees.dao.EmployeesDAOImpl;
import com.xworkz.employeesentity.EmployeesEntity;

public class EmployeesRunner {
	public static void main(String[] args) {
		 EmployeesEntity entity = new EmployeesEntity( "sarath");
		  EmployeesDAOImpl impl = new    EmployeesDAOImpl();
		 // impl.save(entity);
		  //Boolean save = impl.save(entity);
		  //System.out.println(save);
	//  EmployeesEntity entity2 = new EmployeesEntity( "manoj");
//		  Boolean save = impl.save(entity2);
		
		   for (int i=0;i<20;i++) {
			   
			   impl.save(entity);
			   
		   }
		//  System.out.println(save);
	}

}
