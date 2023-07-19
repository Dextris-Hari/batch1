package com.xworkz.car.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.car.dao.CarDAO;
import com.xworkz.dto.CarDTO;

@Repository
public class CatDAOImpl implements CarDAO {
	@Autowired
	private EntityManagerFactory factory;

	public CatDAOImpl() {
		System.out.println(" nanu dao impl" + this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean save(CarDTO dto) {
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

		return false;
	}

	@Override
	public List<CarDTO> readAll() {
		EntityManager manager = factory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("find");
			List<CarDTO> list = query.getResultList();
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			manager.close();
		}

		return null;
	}

	@Override
	public List<CarDTO> readByName(String name) {
		
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("findByName");
		query.setParameter("nm", name);
		List list = query.getResultList();
		
		
		
		
		
		return list;
	}

}
