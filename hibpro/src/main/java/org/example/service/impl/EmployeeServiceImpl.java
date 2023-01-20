package org.example.service.impl;

import org.example.dao.EmployeeDAO;
import org.example.dao.impl.EmployeeDAOImpl;
import org.example.entity.Employee;
import org.example.service.EmployeeService;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static org.example.utils.LoggerObject.getLOGGER;

public class EmployeeServiceImpl implements EmployeeService {
    Logger logger = getLOGGER();
    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public Boolean validateAndSave(Employee employee) {
        if (employee.getName().length() < 20 && employee.getMobile().length() == 10) {
            logger.info(" employee name is valid and mobile number is also valid ");

            employeeDAO.save(employee);
            return true;
        }
        logger.warning(" employee name is not valid and mobile number is also not valid ");


        return false;
    }

    @Override
    public Optional<Employee> validateAndGetEmployeeById(Integer id) {
        Optional<Employee> employee = employeeDAO.getEmployeeById(id);
        if (employee.isPresent()) {
            logger.warning(" employee  is have data ");


            Employee employee1 = employee.get();
            return Optional.of(employee1);
        } else {
            logger.warning("   your entered id there is no data ");

            return Optional.empty();

        }


    }

    @Override
    public Optional<Employee> validateAndUpdateNameById(Integer id, String name) {
        if (name.length() < 20) {
            logger.info("  name is valid to update ");

            Optional<Employee> employee = employeeDAO.updateNameById(id, name);
            if (employee.isPresent()) {
                logger.info("  employee have data you can update that data ");

                Employee employee1 = employee.get();
                return Optional.of(employee1);
            } else {
                logger.warning(" there is no data present in the id you entered\" ");

                return Optional.empty();
            }

        } else {
            logger.warning(" you enter the name is invalid to update the length should be bellow 20");

            return Optional.empty();
        }


    }

    @Override
    public Optional<Employee> validateAndDeleteEmployeeById(Integer id) {
        Optional<Employee> employee = employeeDAO.deleteEmployeeById(id);
        if (employee.isPresent()) {
            logger.info(" employee have data you can delete");

            Employee employee1 = employee.get();

            return Optional.of(employee1);
        } else {
            logger.warning(" in your id there is nothing to delete");

            return Optional.empty();
        }

    }

    @Override
    public Optional<Employee> validateAndFindByName(String name) {
        Optional<Employee> employee = employeeDAO.findByName(name);
        if (employee.isPresent()) {
            logger.info("employee have data  you can see that data");

            Employee employee1 = employee.get();

            return Optional.of(employee1);

        } else {
            logger.warning("employee doestnot  have data on that entering name");



            return Optional.empty();
        }


    }

    @Override
    public List<Employee> validateFindAll() {
        List<Employee> employees = employeeDAO.findAll();
        if (employees.size() != 0) {
            logger.info("employee list is not emty you can read it ");


            return employees;
        }
        logger.warning("employee list is  emty  ");

        return EmployeeService.super.validateFindAll();
    }

    @Override
    public Optional<Employee> validateUpdateByName(String name, String mobile, String dob) {

        Optional<Employee> employee = employeeDAO.updateByName(name, mobile, dob);
        if (employee.isPresent()) {
            logger.warning("employee   not emty you can update it ");


            Employee employee1 = employee.get();
            return Optional.of(employee1);
        }
        logger.warning("employee   is emty you cannot update it ");

        return EmployeeService.super.validateUpdateByName(name, mobile, dob);
    }

    @Override
    public Optional<String> validateDeleteByName(String name) {
        Optional<String> message = employeeDAO.deleteByName(name);
        if (message.isPresent()) {
            logger.warning("employee   not emty you can delete it ");


            String message2 = message.get();
            return Optional.of(message2);
        }
        logger.warning("employee   is emty you cannot delete it ");

        return Optional.empty();
    }
}
