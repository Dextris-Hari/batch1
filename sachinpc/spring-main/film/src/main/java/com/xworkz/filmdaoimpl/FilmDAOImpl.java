package com.xworkz.filmdaoimpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.filmdao.FilmDAO;
import com.xworkz.filmentity.FilmEntity;
@Component
public class FilmDAOImpl implements FilmDAO {
	@Autowired
	 private EntityManagerFactory factory;

	public boolean save(FilmEntity entity) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		transaction.commit();
		manager.close();
		return true;
	}

}
