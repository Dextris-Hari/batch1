package com.xworkz.cinimacom.xworkz.cinimadaoimpl;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.cinimacom.xworkz.cinimadao.CinimaDAO;
import com.xworkz.cinimacom.xworkz.cinimaentity.CinimaEntity;
@Component

public class CinimaDAOImpl implements CinimaDAO {
	@Autowired
	EntityManagerFactory factory;
	public CinimaDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	public boolean save(CinimaEntity entity) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		transaction.commit();
		manager.close();
		return false;
	}

}
