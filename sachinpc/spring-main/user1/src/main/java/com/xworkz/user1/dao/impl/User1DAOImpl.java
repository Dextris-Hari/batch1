package com.xworkz.user1.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.user1.dao.User1DAO;
import com.xworkz.user1.entity.User1;

@Repository
public class User1DAOImpl implements User1DAO {
	@Autowired
	private EntityManagerFactory factory;

	@Override
	public Boolean save(User1 user1) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(user1);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

}
