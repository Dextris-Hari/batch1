package com.xworkz.toothpaste.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.xworkz.toothpaste.entity.ToothPasteEntity;
import com.xworkz.util.toothpaste.Factory;

public class ToothPasteDAOImpl implements ToothPasteDAO {
	EntityManagerFactory factory = Factory.getFactory();

	@Override
	public Boolean save(ToothPasteEntity paste) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(paste);
		transaction.commit();

		return true;
	}

	@Override
	public Optional<ToothPasteEntity> findById(Integer id) {

		try {
			EntityManager manager = factory.createEntityManager();
			System.out.println("manoj6");
			ToothPasteEntity find = manager.find(ToothPasteEntity.class, id);
			System.out.println("manoj5");
			if (find == null) {
				System.out.println("manoj");
				return ToothPasteDAO.super.findById(id);
			}
			System.out.println("manoj2");
			return Optional.of(find);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getStackTrace();
		}
		finally {
			
			
		}
		return null;
	}

}
