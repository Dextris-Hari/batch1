package com.xworkz.nandan.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.nandan.entity.NandanDTO;
@Repository
public class NandanRepoImpl implements NandanRepo {
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public Boolean save(NandanDTO dto) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(dto);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
