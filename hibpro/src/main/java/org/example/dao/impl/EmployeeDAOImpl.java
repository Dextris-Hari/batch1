package org.example.dao.impl;

import org.example.dao.EmployeeDAO;
import org.example.entity.Employee;
import org.example.entity.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeDAOImpl implements EmployeeDAO {
    private static SessionFactory sessionFactory = HibernateUtils.getSessionFactory();


    @Override
    public Boolean Save(Employee employee) {

        Session session = sessionFactory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Session session = sessionFactory.openSession();
        try {
            Employee employee = session.find(Employee.class, id);
            if (employee != null) {
                return employee;
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println("----There is no data available for this ID---");

        return null;
    }

    @Override
    public Employee updateNameById(int id, String name) {
        Session session = sessionFactory.openSession();

        try {
            Transaction transaction = session.beginTransaction();
            Employee employee = session.find(Employee.class, id);
            if (employee != null) {
                employee.setName(name);
                session.save(employee);
                transaction.commit();
                return employee;
            } else {
                System.out.println("-----U cant update Name By using this ID-----");
                return null;
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee deleteEmployeeById(int id) {
        Session session = sessionFactory.openSession();

        try {
            Transaction transaction = session.beginTransaction();
            Employee employee = session.find(Employee.class, id);

            if (employee != null) {
                session.delete(employee);
                transaction.commit();
                return employee;
            } else {
                System.out.println("---u cant delete any data , entered ID does not match-----");
                return null;
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return null;
    }
}
