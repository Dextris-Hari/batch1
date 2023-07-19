package com.xwork.student.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xwork.student.StudentEntity;

public class StudentDAOImpl implements StudentDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.xworkz");

	@Override
	public boolean save(StudentEntity entity) {

		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		transaction.commit();
		return true;
	}

	@Override
	public Optional<StudentEntity> findById(Integer id) {
		EntityManager manager = factory.createEntityManager();
		StudentEntity find = manager.find(StudentEntity.class, id);
		if (find == null) {
			return Optional.empty();
		}

		return Optional.of(find);
	}

}
