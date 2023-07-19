package com.xworkz.criminals.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.criminals.dao.CriminalsRepository;
import com.xworkz.criminals.dto.CriminalsDTO;

@Repository
public class CriminalsRepositoryImpl implements CriminalsRepository {
	@Autowired
	private EntityManagerFactory factory;

	public CriminalsRepositoryImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("nanu criminal repository " + this.getClass().getSimpleName());
	}

	@Override
	public boolean save(CriminalsDTO dto) {

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

		System.out.println(" nanu save method");
		return true;
	}

	@Override
	public List<CriminalsDTO> readAll() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("findAll");
		List<CriminalsDTO> list = query.getResultList();
		return list;
	}

	@Override
	public List<CriminalsDTO> findByName(String name) {
		
		EntityManager manager = factory.createEntityManager();
		try {
			Query createNamedQuery = manager.createNamedQuery("findByName");
			createNamedQuery.setParameter("nm", name);
		List<CriminalsDTO> resultList = createNamedQuery.getResultList();
			return resultList;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// TODO Auto-generated method stub
		return null;
}

}
