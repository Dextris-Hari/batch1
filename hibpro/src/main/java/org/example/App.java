package org.example;

import org.example.entity.Employee;
import org.example.entity.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("========Inside StudentMain================");

        // Get rthe sessionfactiry

        SessionFactory sf = HibernateUtils.getSessionFactory();
        Session sesssion = sf.openSession();
        Transaction tx = sesssion.beginTransaction();

        Employee employee = new Employee();
        employee.setName("Manoj");
        employee.setDob("12-12-1990");
        employee.setMobile("9988776655");
        sesssion.save(employee);
        //sesssion.persist(employee);
        tx.commit();
        sesssion.close();
    }
}
