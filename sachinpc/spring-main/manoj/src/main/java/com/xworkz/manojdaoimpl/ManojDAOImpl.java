package com.xworkz.manojdaoimpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.manojdao.ManojDAO;
import com.xworkz.manojentity.ManojEntity;

@Component
public class ManojDAOImpl implements ManojDAO {
	@Autowired
	EntityManagerFactory factory;

	public boolean save(ManojEntity entity) {
		EntityManager manager = factory.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(entity);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			manager.close();

		}

		return false;
	}

}
