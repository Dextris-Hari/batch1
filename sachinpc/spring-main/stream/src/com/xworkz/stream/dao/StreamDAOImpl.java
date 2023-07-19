package com.xworkz.stream.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.stream.entity.StreamEntity;

public class StreamDAOImpl implements StreamDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.xworkz");
	EntityManager createEntityManager = factory.createEntityManager();

	@Override
	public Optional<Boolean> save(StreamEntity entity) {
		EntityTransaction transaction = createEntityManager.getTransaction();
		transaction.begin();
		createEntityManager.persist(entity);
		transaction.commit();
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<StreamEntity> findByKey(int id) {
		
		StreamEntity find = createEntityManager.find(StreamEntity.class, id);
		if(find==null) {
			
			return Optional.empty();
		}
		
		return Optional.of(find);
		
		// TODO Auto-generated method stub
	}

}
