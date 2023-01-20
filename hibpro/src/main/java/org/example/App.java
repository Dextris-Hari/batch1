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
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.example.utils.LoggerObject.getLOGGER;

/**
 * Hello world!
 */
public class App {
    static Logger logger = getLOGGER();

    public static void main(String[] args) {

        logger.info("===================== this is save method calling================================");

        Employee employee = new Employee();
        employee.setName("jayaram");
        employee.setMobile("9482560881");
        employee.setDob("08/05/1996");
        EmployeeService employeeService = new EmployeeServiceImpl();
        Boolean aBoolean = employeeService.validateAndSave(employee);
        logger.info("data of the save method is save" + " " + aBoolean);
        logger.info("=============================================this is getEmployeeById method calling===============================");
        Optional<Employee> employee1 = employeeService.validateAndGetEmployeeById(8);
        if (employee1.isPresent()) {
            Employee employee2 = employee1.get();
            logger.info("employee on  you entered id is there yu can read it" + " " + employee2);

            System.out.println(employee2);
        } else {
            logger.warning("in your id data is null");


        }
        logger.info("===========calling update method====================================================");


        Optional<Employee> employee2 = employeeService.validateAndUpdateNameById(8, "nagabaran");
        if (employee2.isPresent()) {

            Employee employee3 = employee2.get();
            System.out.println(employee3);
            logger.info("employee is present on your id you can get updated employee" + " " + employee3);

        } else {
            logger.warning("there is no data to show and update");

        }
        logger.info("==========calling deleteBYId method==============================");

        Optional<Employee> employee3 = employeeService.validateAndDeleteEmployeeById(10);
        if (employee3.isPresent()) {

            Employee employee4 = employee3.get();
            logger.info("your employee on the id you entered is deleted  and deleted employee is: " + employee4);

        } else {
            logger.warning(" there no data to delete");

        }
        logger.info("=====================================QUERY============================================");
        logger.info("=============calling finfByName method=============");

        Optional<Employee> employee4 = employeeService.validateAndFindByName("jayaram");
        if (employee4.isPresent()) {

            Employee employee5 = employee4.get();
            logger.info("employee is present on the name you entered you can read it" + " " + employee5);


        } else {
            logger.warning(" there is no data in your name");

        }
        logger.info("===========calling getAll method============================");

        List<Employee> employeeList = employeeService.validateFindAll();
        if (employeeList.size() != 0) {
            logger.info("your data  in the list are: " + " " + employeeList);


        } else {
            logger.warning(" your list is 0");

        }
        logger.info("===================calling updateByName===============");
        Optional<Employee> employee5 = employeeService.validateUpdateByName("jayanth", "7894561230", "09/09/1960");
        if (employee5.isPresent()) {

            Employee employee6 = employee5.get();
            logger.info(" your  employee on the name you entered  is updated and updated emplyoee is" + " " + employee6);

        } else {
            logger.warning(" there is no data in your name");

        }
        logger.info("==========calling deleteByName====================");

        Optional<String> message = employeeService.validateDeleteByName("manoj");
        if (message.isPresent()) {
            String message2 = message.get();
            logger.info(" " + message2);

        } else {
            logger.warning(" there is no data in this name to delete");

        }
    }
}
