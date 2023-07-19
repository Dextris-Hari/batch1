package com.xworkz.pg.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.pg.dao.PgDAO;
import com.xworkz.pg.dto.PgDTO;

@Repository
public class PgDAOImpl implements PgDAO {
	@Autowired
	private EntityManagerFactory factory;

	public PgDAOImpl() {
		System.out.println(" nanu dao impl" + this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean save(PgDTO dto) {
		EntityManager manager = factory.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(dto);
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			manager.close();
		}

		return true;
	}

	@Override
	public List<PgDTO> readAll() {
		// TODO Auto-generated method stub

		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("find");
		List<PgDTO> list = query.getResultList();

		return list;
	}

	@Override
	public List<PgDTO> readByName(String name) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("findByName");
		query.setParameter("nm", name);
		List list = query.getResultList();
		
		return list;
		
	}

}
