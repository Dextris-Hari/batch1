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

import java.util.List;
import java.util.Optional;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("===================== this is save method calling================================");
        Employee employee = new Employee();
        employee.setName("manoj");
        employee.setMobile("7204250720");
        employee.setDob("03/08/1998");
        EmployeeService employeeService = new EmployeeServiceImpl();
          Boolean aBoolean = employeeService.validateAndSave(employee);
           System.out.println(aBoolean);
        System.out.println(" =============================================this is getEmployeeById method calling================================================");
        Optional<Employee> employee1 = employeeService.validateAndGetEmployeeById(1);
        if (employee1.isPresent()) {
            Employee employee2 = employee1.get();
            System.out.println(employee2);
        } else {


            System.err.println(" in your id data is null");
        }
        System.out.println("===========calling update method====================================================");
        Optional<Employee> employee2 = employeeService.validateAndUpdateNameById(1, "nagabaran");
        if (employee2.isPresent()) {
            Employee employee3 = employee2.get();
            System.out.println(employee3);
        } else {
            System.err.println(" there is no data to show and update");
        }
        System.out.println("==========calling deleteBYId method==============================");
        Optional<Employee> employee3 = employeeService.validateAndDeleteEmployeeById(2);
        if (employee3.isPresent()) {
            Employee employee4 = employee3.get();
            System.out.println("your deleted employee is: " + employee4);
        } else {
            System.err.println(" there no data to delete");
        }
        System.out.println("=====================================QUERY============================================");
        System.out.println("=============calling finfByName method=============");
        Optional<Employee> employee4 = employeeService.validateAndFindByName("jayanth");
        if (employee4.isPresent()) {

            Employee employee5 = employee4.get();
            System.out.println(employee5);

        } else {

            System.err.println(" there is no data in your name");
        }
        System.out.println("===========calling getAll method============================");
        List<Employee> employeeList = employeeService.validateFindAll();
        if (employeeList.size() != 0) {
            System.out.println(employeeList);


        } else {
            System.err.println(" your list is 0");
        }

        System.out.println("===================calling updateByName");
        Optional<Employee> employee5 = employeeService.validateUpdateByName("manoj", "9482560881", "03/08/2023");
        if (employee5.isPresent()) {

            Employee employee6 = employee5.get();
            System.out.println(employee6);
        } else {

            System.out.println(" there is no data in your name");
        }
        System.out.println("==========calling deleteByName===================");
      Optional<String> message=  employeeService.validateDeleteByName("jayanth");
      if(message.isPresent()){
        String message2=  message.get();
          System.out.println(message2);
      }
      else{
          System.out.println(" there is no data in this name to delete");
      }
    }
}
