package com.xworkz.booklist.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.booklist.dao.BookListDAO;
import com.xworkz.booklist.dto.BookListDTO;

@Repository
public class BookListDAOImpl implements BookListDAO {
	@Autowired
	private EntityManagerFactory factory;

	public BookListDAOImpl() {
		System.out.println(" nanu Implimantaion of dao " + this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean save(BookListDTO dto) {
		System.out.println(" nanu save method");
		EntityManager manager = factory.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(dto);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			manager.close();
		}
		return false;

	}

	@Override
	public List<BookListDTO> readAll() {
		
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("find");
		List<BookListDTO> list = query.getResultList();
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<BookListDTO> readByName(String name) {
		
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createNamedQuery("findByName");
		query.setParameter("nm", name);
		List list = query.getResultList();
		return list;
	}

}
