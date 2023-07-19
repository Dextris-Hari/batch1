package com.xwork.student.runner;

import com.xwork.student.StudentEntity;
import com.xwork.student.dao.StudentDAOImpl;

public class Runner {
	public static void main(String[] args) {

		StudentEntity entity = new StudentEntity( "manoj", "jayaram", "jyothi");
		StudentDAOImpl impl = new StudentDAOImpl();
		boolean save = impl.save(entity);
		System.out.println(save);
	System.out.println(impl.findById(1));	
	}

}
