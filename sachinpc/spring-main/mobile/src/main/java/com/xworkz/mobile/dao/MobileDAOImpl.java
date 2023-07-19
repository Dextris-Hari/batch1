package com.xworkz.mobile.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.mobile.entity.MobileEntity;

@Component
public class MobileDAOImpl implements MobileDAO {
	@Autowired
	EntityManagerFactory factory;

	public MobileDAOImpl() {
		System.out.println("MobileDAOImpl created");
	}

	@Override
	public boolean save(MobileEntity entity) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		transaction.commit();
		manager.close();
	//	factory.close();
	//	factory.

		return true;
	}

}
