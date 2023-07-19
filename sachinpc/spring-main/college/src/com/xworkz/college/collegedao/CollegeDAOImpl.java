package com.xworkz.college.collegedao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.college.entity.CollegeEntity;

public class CollegeDAOImpl implements CollegeDAO {

	public CollegeDAOImpl() {
		super();
		System.out.println(" daoimpl is created ");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean save(CollegeEntity entity) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(" com.xworkz".trim());
		try {
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(entity);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

}
