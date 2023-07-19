package com.xworkz.nanadandaoimpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.nanadandao.NandanDAO;
import com.xworkz.nanadanentity.NandanEntity;

@Component
public class NandanDAOImpl implements NandanDAO {
	@Autowired
	EntityManagerFactory factory;
	//EntityManager manager;

	@Override
	public String save(NandanEntity entity) {
		try {
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(entity);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			//manager.close();
		}
		// manager.close();

		return "banthu";
	}

}
