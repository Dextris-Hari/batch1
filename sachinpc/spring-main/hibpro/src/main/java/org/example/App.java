package org.example;

import org.example.dao.EmployeeDAO;
import org.example.dao.impl.EmployeeDAOImpl;
import org.example.entity.Employee;
import org.example.service.EmployeeService;
import org.example.service.impl.EmployeeServiceImpl;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Optional;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("===================== this is save method calling================================");
        Employee employee = new Employee();
        employee.setName("jayanth");
        employee.setMobile("7204250720");
        employee.setDob("03/08/1998");
        EmployeeService employeeService = new EmployeeServiceImpl();
        //   Boolean aBoolean = employeeService.validateAndSave(employee);
        //   System.out.println(aBoolean);
        System.out.println(" =============================================this is getEmployeeById method calling================================================");
        Optional<Employee> employee1 = employeeService.validateAndGetEmployeeById(1);
        if (employee1.isPresent()) {
            Employee employee2 = employee1.get();
            System.out.println(employee2);
        } else {


            System.out.println(" in your id data is null");
        }
        System.out.println("===========calling update method====================================================");
        Optional<Employee> employee2 = employeeService.validateAndUpdateNameById(1, "nagabaran");
        if (employee2.isPresent()) {
            Employee employee3 = employee2.get();
            System.out.println(employee3);
        } else {
            System.out.println(" there is no data to show and update");
        }
        System.out.println("==========calling deleteBYId method==============================");
        Optional<Employee> employee3 = employeeService.validateAndDeleteEmployeeById(1);
        if (employee3.isPresent()) {
            Employee employee4 = employee3.get();
            System.out.println("your deleted employee is: " + employee4);
        } else {
            System.out.println(" there no data to delete");
        }
        System.out.println("=============calling finfByName method=============");
        Optional<Employee> employee4 = employeeService.validateAndFindByName("manoj");
        if (employee4.isPresent()) {

            Employee employee5 = employee4.get();
            System.out.println(employee5);

        }
        else{

            System.out.println(" there is no data in your name");
        }

    }
}
