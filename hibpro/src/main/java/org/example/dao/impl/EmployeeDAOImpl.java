package org.example.dao.impl;

import org.example.dao.EmployeeDAO;
import org.example.entity.Employee;
import org.example.utils.HibernateUtils;
import org.hibernate.*;

import javax.persistence.OneToMany;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.example.utils.LoggerObject.getLOGGER;

public class EmployeeDAOImpl implements EmployeeDAO {
    Logger logger = getLOGGER();
    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    @Override
    public Boolean save(Employee employee) {
        Session session = sessionFactory.openSession();
        try {

            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
            logger.info("save method is compliteted ");
            return true;
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
            logger.log(Level.SEVERE, "hibernate exception" + hibernateException);
        } finally {
            session.close();
            logger.info("sission of save method is closed");
            // sessionFactory.close();
        }


        return false;
    }

    @Override
    public Optional<Employee> getEmployeeById(Integer id) {
        Session session = sessionFactory.openSession();
        try {
            Employee employee = session.find(Employee.class, id);

            if (employee != null) {

                return Optional.of(employee);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            logger.log(Level.SEVERE, "hibernate exception" + e);
        } finally {
            session.close();
            logger.info("sission of getById method is closed");
        }


        return Optional.empty();
    }

    @Override
    public Optional<Employee> updateNameById(Integer id, String name) {
        Session session = sessionFactory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            Employee employee = session.find(Employee.class, id);
            if (employee != null) {
                logger.info("employee is not null");
                employee.setName(name);
                session.save(employee);
                transaction.commit();
                Employee employee1 = session.find(Employee.class, id);
                if (employee1 != null) {
                    logger.info("employee1 is not null");

                    return Optional.of(employee1);

                } else {
                    logger.warning("employee1 is  null");

                    return Optional.empty();
                }

            } else {
                logger.warning("entering id not consist data to update");

                return Optional.empty();
            }
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
            logger.log(Level.SEVERE, "hibernate exception" + hibernateException);
            return Optional.empty();
        } finally {
            session.close();
            logger.info("sission of updateNameById method is closed");
        }


    }

    @Override
    public Optional<Employee> deleteEmployeeById(Integer id) {
        Session session = sessionFactory.openSession();
        try {
            Transaction transaction = session.beginTransaction();

            Employee employee = session.find(Employee.class, id);
            if (employee != null) {
                logger.info("employee is not null");


                session.delete(employee);
                transaction.commit();
                return Optional.of(employee);
            } else {
                logger.warning("you entered id have no data");

                return Optional.empty();
            }

        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
            logger.log(Level.SEVERE, "hibernate exception" + hibernateException);
            return Optional.empty();
        } finally {
            session.close();
            logger.info("sission of deleteEmployeeById method is closed");

        }

    }

    @Override
    public Optional<Employee> findByName(String name) {
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createNamedQuery("findByName");
            query.setParameter("name", name);
            Object obj = query.getSingleResult();
            if (obj != null) {
                logger.info("obj is not null");

                Employee employee = (Employee) obj;
                return Optional.of(employee);
            } else {
                logger.warning("obj is  null");

                return Optional.empty();
            }


        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
            logger.log(Level.SEVERE, "hibernate exception" + hibernateException);
            return Optional.empty();
        } finally {
            session.close();
            logger.info("sission of findByName method is closed");

        }

    }

    @Override
    public List<Employee> findAll() {
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createNamedQuery("findAll");
            List<Employee> employees = query.getResultList();
            if (employees.size() != 0) {
                logger.info("employees size is not 0");


                return employees;
            } else {
                logger.warning("employees size is  0");

                return null;
            }
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
            logger.log(Level.SEVERE, "hibernate exception" + hibernateException);
        } finally {
            session.close();
            logger.info("sission of findAll method is closed");

        }

        return null;
    }

    @Override
    public Optional<Employee> updateByName(String name, String mobile, String dob) {
        Session session = sessionFactory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            Query query = session.createNamedQuery("updateByName");
            query.setParameter("name", name);
            query.setParameter("mobile", mobile);
            query.setParameter("dob", dob);
            Integer integer = query.executeUpdate();
            System.out.println(integer);
            Query query1 = session.createNamedQuery("findByName");
            query1.setParameter("name", name);
            Object obj = query1.getSingleResult();
            Employee employee = (Employee) obj;
            return Optional.of(employee);
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
            logger.log(Level.SEVERE, "hibernate exception" + hibernateException);
        } finally {
            session.close();
            logger.info("sission of updateByName method is closed");

        }

        return EmployeeDAO.super.updateByName(name, mobile, dob);
    }

    @Override
    public Optional<String> deleteByName(String name) {
        Session session = sessionFactory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            Query query = session.createNamedQuery("deleteByName");
            query.setParameter("name", name);
            Integer integer = query.executeUpdate();
            System.out.println(integer);
            transaction.commit();

            return Optional.of("your data is deleted");


        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
            logger.log(Level.SEVERE, "hibernate exception" + hibernateException);
            return Optional.empty();
        } finally {
            session.close();
            logger.info("sission of deleteByName method is closed");

        }

    }
}
