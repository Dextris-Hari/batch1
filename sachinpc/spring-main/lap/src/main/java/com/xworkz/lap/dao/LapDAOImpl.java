package com.xworkz.lap.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.lap.entity.LapEntity;

@Repository
public class LapDAOImpl implements LapDAO {
	@Autowired
	private EntityManagerFactory factory;

	public LapDAOImpl() {
		super();
		System.out.println(" created LapDAOImpl");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean save(LapEntity entity) {
		EntityManager manager = factory.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(entity);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
