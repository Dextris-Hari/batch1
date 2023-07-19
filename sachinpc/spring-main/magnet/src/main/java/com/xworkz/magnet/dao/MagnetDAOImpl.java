package com.xworkz.magnet.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.magnetdto.MagnetDTO;

@Repository
public class MagnetDAOImpl implements MagnetDAO {
	@Autowired
	private EntityManagerFactory factory;

	public MagnetDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean save(MagnetDTO dto) {
		System.out.println("manoj");
		try {
			System.out.println("1");
			EntityManager createEntityManager = factory.createEntityManager();
			System.out.println("1");
			EntityTransaction transaction = createEntityManager.getTransaction();
			System.out.println("1");
			transaction.begin();
			System.out.println("1");
			createEntityManager.persist(dto);
			System.out.println("1");
			transaction.commit();
			System.out.println("1");

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getStackTrace();
		}
		return false;
	}

}
