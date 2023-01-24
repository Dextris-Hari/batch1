package org.example;

import org.example.dao.EmployeeDAO;
import org.example.dao.impl.EmployeeDAOImpl;
import org.example.entity.Employee;
import org.example.entity.utils.HibernateUtils;
import org.example.service.EmployeeService;
import org.example.service.impl.EmployeeServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("========Inside EmployeeMain================");

        Employee employee = new Employee();
        employee.setName("leela");
        employee.setDob("15-5-2000");
        employee.setMobile("8877993344");

        EmployeeService employeeService = new EmployeeServiceImpl();

        //System.out.println("========Inside validate and save method================");
        // Boolean aBoolean = employeeService.validateAndSave(employee);
        // System.out.println(aBoolean);

        // System.out.println("========Inside Validate and getEmployeeById method================");
        //Employee employee1 = employeeService.validateAndGetEmployeeById(5);
        //System.out.println(employee1);

        System.out.println("========Inside validate and update name by ID method ================");
        Employee emp = employeeService.validateAndUpdateNameById(7, "Feabi");
        System.out.println(emp);

      //  System.out.println("========Inside validate and delete employee by ID================");
       // Employee mm = employeeService.validateAndDeleteEmployeeById(8);
       // System.out.println(mm);


    }
}
