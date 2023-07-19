package com.xworkz.hotel.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.hotel.dao.HotelDAO;
import com.xworkz.hotel.dto.HotelDTO;

@Repository
public class HotelDAOImpl implements HotelDAO {
	@Autowired
	private EntityManagerFactory factory;

	public HotelDAOImpl() {
		System.out.println(" Hoteddaoimpl is created " + this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean save(HotelDTO dto) {
		EntityManager manager = factory.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(dto);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			manager.close();

		}
		return false;
	}

	@Override
	public List<HotelDTO> readAll() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("find");
		List<HotelDTO> resultList = query.getResultList();
		// TODO Auto-generated method stub
		return resultList;
	}

	@Override
	public List<HotelDTO> readByName(String name) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("findByName");
		query.setParameter("nm", name);
		List list = query.getResultList();
		return list;
	}

}
