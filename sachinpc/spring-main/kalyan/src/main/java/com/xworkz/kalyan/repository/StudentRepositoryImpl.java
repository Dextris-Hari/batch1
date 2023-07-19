package com.xworkz.kalyan.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.kalyan.entity.Student;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public boolean save(Student student) {

		EntityManager createEntityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = createEntityManager.getTransaction();
		transaction.begin();
		createEntityManager.persist(student);
		transaction.commit();
		return true;
	}

}
