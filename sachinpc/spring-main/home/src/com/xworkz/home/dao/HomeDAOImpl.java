package com.xworkz.home.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.xworkz.home.entity.HomeEntity;
import com.xworkz.util.factory.Factory;

public class HomeDAOImpl implements HomeDAO {

	EntityManagerFactory factory = Factory.getFactory();

	@Override
	public Boolean save(HomeEntity entity) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		transaction.commit();

		return true;
	}

	@Override
	public Optional<HomeEntity> findById(int id) {

		EntityManager createEntityManager = factory.createEntityManager();
		HomeEntity find = createEntityManager.find(HomeEntity.class, id);
		if (find != null) {
			System.out.println("found");

			return Optional.of(find);
		}

		// TODO Auto-generated method stub
		return HomeDAO.super.findById(id);
	}

	@Override
	public Optional<HomeEntity> updateById(int id, String owner) {
		EntityManager manager = factory.createEntityManager();
		HomeEntity find = manager.find(HomeEntity.class, id);

		System.out.println("outer");
		if (find != null) {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			find.setOwner(owner);
			System.out.println("found");

			manager.persist(find);

			transaction.commit();
			return Optional.of(find);
		}
		return HomeDAO.super.updateById(id, owner);
	}

	@Override
	public void delete(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		HomeEntity find = manager.find(HomeEntity.class, id);

		if (find != null) {

			System.out.println("found" + " " + find);
			manager.remove(find);
			transaction.commit();

		}
		HomeDAO.super.delete(id);
	}

	@Override
	public boolean save(List<HomeEntity> entity) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();

			for (HomeEntity homeEntity : entity) {
				manager.persist(homeEntity);
			}
			transaction.commit();

			// TODO Auto-generated method stub
			return true;
		} catch (Exception e) {

			transaction.rollback();

			e.printStackTrace();
		}
		return false;
	}

}
