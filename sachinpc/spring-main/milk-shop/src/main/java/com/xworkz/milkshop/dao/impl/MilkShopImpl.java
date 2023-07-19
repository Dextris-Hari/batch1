package com.xworkz.milkshop.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.milkshop.dao.MilkShopDAO;
import com.xworkz.milkshop.dto.MilkShopDTO;
@Repository
public class MilkShopImpl implements  MilkShopDAO {
	@Autowired
	private EntityManagerFactory factory;
  public MilkShopImpl() {
	  System.out.println(" dao impl is created"+this.getClass().getSimpleName());
	// TODO Auto-generated constructor stub
}
  
	@Override
	public boolean save(MilkShopDTO dto) {
		EntityManager createEntityManager = factory.createEntityManager();
		try {
			EntityTransaction transaction = createEntityManager.getTransaction();
			transaction.begin();
			createEntityManager.persist(dto);
			transaction.commit();
		} catch (PersistenceException e) {
			// TODO: handle exception
		}
		finally {
			createEntityManager.close();
		}
		return true;
	}

	@Override
	public List<MilkShopDTO> readAll() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("find");
		List list = query.getResultList();
		return list;
	}

	@Override
	public List<MilkShopDTO> readByName(String name) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("findByName");
		query.setParameter("nm", name);
		List list = query.getResultList();
		return list;
	}

}
