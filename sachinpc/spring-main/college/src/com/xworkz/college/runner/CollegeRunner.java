package com.xworkz.college.runner;

import com.xworkz.college.collegedao.CollegeDAO;
import com.xworkz.college.collegedao.CollegeDAOImpl;
import com.xworkz.college.entity.CollegeEntity;

public class CollegeRunner {
	public static void main(String[] args) {

		CollegeEntity entity = new CollegeEntity("bharathi ".trim(), 100000);

		CollegeDAO impl = new CollegeDAOImpl();
		 impl.save(entity);

	}

}
