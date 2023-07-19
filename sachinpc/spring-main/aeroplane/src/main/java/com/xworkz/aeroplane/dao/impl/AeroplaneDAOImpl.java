package com.xworkz.aeroplane.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.aeroplane.dao.AeroplainDAO;
import com.xworkz.aeroplane.dto.AeroplaneDTO;

@Repository
public class AeroplaneDAOImpl implements AeroplainDAO {
	@Autowired
	private EntityManagerFactory factory;

	@Override
	public String save(AeroplaneDTO dto) {
		EntityManager manager = factory.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(dto);
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			manager.close();
		}
		// TODO Auto-generated method stub
		return " nanu kalyan";
	}

	@Override
	public List<AeroplaneDTO> readAll() {
		EntityManager createEntityManager = factory.createEntityManager();
		List<AeroplaneDTO> resultList = null;
		  try {
			  Query query = createEntityManager.createNamedQuery("find");
			   resultList = query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  finally {
			  createEntityManager.close();
		  }
		// TODO Auto-generated method stub
		return resultList ;
	}

	@Override
	public List<AeroplaneDTO> readByName(String name) {
		
		System.out.println(" read by name ");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("findByName");
		query.setParameter("nm", name);
		List<AeroplaneDTO> list = query.getResultList();
		
		
		
		return list;
	}

}
