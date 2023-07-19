package com.xworkz.train.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.train.dao.TrainDAO;
import com.xworkz.train.dto.TrainDTO;

@Repository
public class TrainDAOImpl implements TrainDAO {
	@Autowired
	 EntityManagerFactory  factory;
	public TrainDAOImpl() {

		System.out.println(" TrainDAO is created " + this.getClass().getSimpleName());

		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean save(TrainDTO dto) {
		EntityManager manager = factory.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(dto);
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getStackTrace();
		}
		finally {
			manager.close();
		}

		return false;
	}

	@Override
	public List<TrainDTO> readAll() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("find");
		List list = query.getResultList();
		
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<TrainDTO> readByName(String trainName) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("findByName");
		query.setParameter("tn", trainName);
		List list = query.getResultList();
		return list;
	}

}
