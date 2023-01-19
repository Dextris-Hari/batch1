package org.example.dao.impl;

import org.example.dao.EmployeeDAO;
import org.example.entity.Employee;
import org.example.utils.HibernateUtils;
import org.hibernate.*;

import javax.persistence.OneToMany;
import java.util.List;
import java.util.Optional;

public class EmployeeDAOImpl implements EmployeeDAO {
    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    @Override
    public Boolean save(Employee employee) {
        Session session = sessionFactory.openSession();
        try {

            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
            return true;
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
        } finally {
            session.close();
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
        } finally {
            session.close();
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

                employee.setName(name);
                session.save(employee);
                transaction.commit();
                Employee employee1 = session.find(Employee.class, id);
                if (employee1 != null) {
                    return Optional.of(employee1);

                } else {
                    return Optional.empty();
                }

            } else {
                System.out.println(" entering id not consist data to update ");
                return Optional.empty();
            }
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
            return Optional.empty();
        } finally {
            session.close();
        }


    }

    @Override
    public Optional<Employee> deleteEmployeeById(Integer id) {
        Session session = sessionFactory.openSession();
        try {
            Transaction transaction = session.beginTransaction();

            Employee employee = session.find(Employee.class, id);
            if (employee != null) {
                session.delete(employee);
                transaction.commit();
                return Optional.of(employee);
            } else {
                System.out.println(" you entered id have no data");
                return Optional.empty();
            }

        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
            return Optional.empty();
        } finally {
            session.close();
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
                Employee employee = (Employee) obj;
                return Optional.of(employee);
            } else {
                return Optional.empty();
            }


        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
            return Optional.empty();
        } finally {
            session.close();
        }

    }

    @Override
    public List<Employee> findAll() {
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createNamedQuery("findAll");
            List<Employee> employees = query.getResultList();
            if (employees.size() != 0) {

                return employees;
            } else {
                return null;
            }
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
        } finally {
            session.close();
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
        } finally {
            session.close();
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
            return Optional.empty();
        } finally {
            session.close();
        }

    }
}
