package com.xworkz.bus.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.bus.dto.BusDTO;

@Repository
public class BusDAOImpl implements BusDAO {
	@Autowired
	private EntityManagerFactory factory; // to get ref of entitymanagerfactory

	public BusDAOImpl() {
		System.out.println("Busdao is created" + this.getClass().getSimpleName());

	}

	@Override
	public boolean collect(BusDTO dto) {
		EntityManager manager = factory.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(dto);
			transaction.commit();
		} catch (PersistenceException e) {

			e.printStackTrace();
		} finally {
			manager.close();
		}

		return false;
	}

	@Override
	public List<BusDTO> readAll() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("findAll");
		List list = query.getResultList();
		
		return list;
	}

	@Override
	public List<BusDTO> readAll(String name) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("findByName");
		query.setParameter("nm", name)	;
		List resultList = query.getResultList();
		return resultList;
	}

}
