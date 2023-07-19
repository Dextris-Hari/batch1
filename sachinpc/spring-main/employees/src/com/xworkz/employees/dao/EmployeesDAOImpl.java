package com.xworkz.employees.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.xworkz.employeesentity.EmployeesEntity;
import static com.xworkz.util.employees.FoctoryUtil.getFactory;

public class EmployeesDAOImpl implements EmployeeDAO {

	private EntityManagerFactory factory = getFactory();

	@Override
	public Boolean save(EmployeesEntity entity) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(entity);
			transaction.commit();
//			EmployeesEntity find = manager.find(EmployeesEntity.class, 1);
//			String name = find.getName();
//			System.out.println(name);
//			manager.remove(entity);
//			EmployeesEntity find2 = manager.find(EmployeesEntity.class, 2);
//			
//			String name2 = find2.getName();
//			System.out.println(name2);
//			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			factory.close();
			manager.close();

		}

		return false;
	}

}
