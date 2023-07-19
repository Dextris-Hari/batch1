package com.xworkz.user.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.user.dto.UserDTO;

@Repository

public class UserDAOImpl implements UserDAO {
	@Autowired
	private EntityManagerFactory factory;

	public UserDAOImpl() {

		System.out.println(" this daoimpl" + this.getClass().getSimpleName());
	}

	@Override
	public boolean save(UserDTO dto) {

		EntityManager manager = factory.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(dto);
			transaction.commit();
			return true;
		} catch (PersistenceException e) {
			e.printStackTrace();

		} finally {
			manager.close();
		}

		return false;
	}

	@Override
	public Optional<List<UserDTO>> findByMail(String newMail) {
		System.out.println(" this is y Mail method running ");
		EntityManager manager = factory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("findByMail");
			query.setParameter("ml", newMail);
			List resultList = query.getResultList();

			System.out.println(resultList.isEmpty());
			if (resultList.isEmpty()) {

				System.out.println("data is not there");
				return Optional.empty();
			} else {
				System.out.println(" manoj data is there so u r not save this data ");
				System.out.println(resultList);
				return Optional.of(resultList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			manager.close();
		}
		return Optional.empty();
	}

	@Override
	public Optional<List<UserDTO>> findByEmailAndSecurity(String email, String security) {

		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("findByEmailAndSecurity");
		query.setParameter("ml", email);
		query.setParameter("sc", security);
		List resultList = query.getResultList();
		if (resultList.isEmpty()) {

			System.out.println(" data is not there to singin");

			return Optional.empty();
		} else {
			System.out.println(" data is there  for singIn");
			return Optional.of(resultList);

		}

	}

	@Override
	public Boolean updateStatusByMail(String status, String mail) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Query createNamedQuery = manager.createNamedQuery("updateStatusByMail");
			createNamedQuery.setParameter("st", status);
			createNamedQuery.setParameter("mi", mail);
			int executeUpdate = createNamedQuery.executeUpdate();
			System.out.println(executeUpdate);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			manager.close();
		}
		return true;
	}

	@Override
	public Boolean updateCountByMail(int count, String mail) {
		System.out.println(count + "(❁´◡`❁)(❁´◡`❁)(❁´◡`❁)(❁´◡`❁)(❁´◡`❁)(❁´◡`❁)(❁´◡`❁)(❁´◡`❁)");
		EntityManager createEntityManager = factory.createEntityManager();
		EntityTransaction transaction = createEntityManager.getTransaction();
		try {
			transaction.begin();
			Query query = createEntityManager.createNamedQuery("updateCountByMail");
			query.setParameter("cn", count);
			query.setParameter("mi", mail);
			int executeUpdate = query.executeUpdate();
			System.out.println("¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥");
			System.out.println(executeUpdate);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			createEntityManager.close();
		}
		return true;
	}

	@Override
	public Optional<Boolean> updatePasswardByMail(String passward, String mail) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Query query = manager.createNamedQuery("updatePasswardByMail");
			query.setParameter("sc", passward);
			query.setParameter("mi", mail);
			int executeUpdate = query.executeUpdate();
			System.out.println(executeUpdate);
			transaction.commit();
			return Optional.of(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			manager.close();
		}
		return Optional.empty();
	}

	@Override
	public Optional<Boolean> updateOtpDateAndTimeByMail(Integer otp, String email, LocalDate date, LocalTime time) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Query query = manager.createNamedQuery("updateOtpDateAndTimeByMail");
			query.setParameter("otp", otp);
			query.setParameter("date", date);
			query.setParameter("time", time);
			query.setParameter("mi", email);
			int executeUpdate = query.executeUpdate();
			transaction.commit();
			System.out.println(executeUpdate);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return Optional.of(true);
	}

	@Override
	public Boolean resetPasswordByEmail(String email, String security, String status, Integer otp, String conformPassward) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Query query = manager.createNamedQuery("resetPasswordByEmail");
			query.setParameter("security", security);
			query.setParameter("otp", otp);
			query.setParameter("mi", email);
			query.setParameter("st", status);
			query.setParameter("cp", conformPassward);
			int executeUpdate = query.executeUpdate();
			System.out.println(executeUpdate);
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			manager.close();
		}

		return false;
	}



	@Override
	public Boolean updateNameAndPhoneNumberBymail(String mail, Long number, String name,String fileName) {

		try {
			System.out.println(mail + number + name);
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Query query = manager.createNamedQuery("updateNameAndPhoneNumberBymail");
			query.setParameter("mail", mail);
			query.setParameter("pn", number);
			query.setParameter("name", name);
			query.setParameter("fn", fileName);
			int executeUpdate = query.executeUpdate();
			System.out.println(executeUpdate);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
