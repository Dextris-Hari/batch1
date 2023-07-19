package com.xworkz.karthikdao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.xworkz.karthikentity.KarthikEntity;

@Repository
public class KarthikDAOImpl implements KarthikDAO {
	@Autowired
	private EntityManagerFactory factory;

	@Override
	public Boolean save(KarthikEntity entity) {
		EntityManager createEntityManager = factory.createEntityManager();
		try {
			EntityTransaction transaction = createEntityManager.getTransaction();
			transaction.begin();
			createEntityManager.persist(entity);
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getStackTrace();
		}

		return true;
	}

}
