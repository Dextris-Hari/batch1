package com.xworkz.stream.runner;

import java.util.Optional;

import com.xworkz.stream.dao.StreamDAO;
import com.xworkz.stream.dao.StreamDAOImpl;
import com.xworkz.stream.entity.StreamEntity;

public class Runner {
	public static void main(String[] args) {
		StreamEntity entity = new StreamEntity("manoj", null, "jayaram", 7204250720l, 1233654, "mahs1524m");

		
		StreamDAO impl = new StreamDAOImpl();
		Optional<Boolean> save = impl.save(entity);
		if(save.isEmpty()) {
			System.out.println("  not created");
		}
		
		/*
		 * Optional<StreamEntity> findByKey = impl.findByKey(1);
		 * System.out.println(findByKey);
		 */
		
	}

}
