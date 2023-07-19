package com.xworkz.people.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.people.dto.PeopleDTO;

@Repository
public class PeopleDAOImpl implements PeopleDAO{
	@Autowired
	private EntityManagerFactory factory;
	public PeopleDAOImpl() {
		System.out.println("calling"+this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean save( PeopleDTO dto) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(dto);
			transaction.commit();
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			manager.close();
		}
		return false;
		
	}
	

}
