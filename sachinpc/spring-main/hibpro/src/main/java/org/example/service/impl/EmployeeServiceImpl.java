package org.example.service.impl;

import org.example.dao.EmployeeDAO;
import org.example.dao.impl.EmployeeDAOImpl;
import org.example.entity.Employee;
import org.example.service.EmployeeService;

import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public Boolean validateAndSave(Employee employee) {
        if (employee.getName().length() < 20 && employee.getMobile().length() == 10) {

            employeeDAO.save(employee);
            return true;
        }


        return false;
    }

    @Override
    public Optional<Employee> validateAndGetEmployeeById(Integer id) {
        Optional<Employee> employee = employeeDAO.getEmployeeById(id);
        if (employee.isPresent()) {


            Employee employee1 = employee.get();
            return Optional.of(employee1);
        } else {
            System.out.println("your entered id there is no data");
            return Optional.empty();

        }


    }

    @Override
    public Optional<Employee> validateAndUpdateNameById(Integer id, String name) {
        if (name.length() < 20) {
            Optional<Employee> employee = employeeDAO.updateNameById(id, name);
            if (employee.isPresent()) {
                Employee employee1 = employee.get();
                return Optional.of(employee1);
            } else {
                System.out.println("there is no data present in the id you entered");
                return Optional.empty();
            }

        } else {

            System.out.println(" you enter the name is invalid to update the length should be bellow 20");
            return Optional.empty();
        }


    }

    @Override
    public Optional<Employee> validateAndDeleteEmployeeById(Integer id) {
        Optional<Employee> employee = employeeDAO.deleteEmployeeById(id);
        if (employee.isPresent()) {
            Employee employee1 = employee.get();

            return Optional.of(employee1);
        } else {
            System.out.println(" in your id there is nothing to delete");
            return Optional.empty();
        }

    }

    @Override
    public Optional<Employee> validateAndFindByName(String name) {
        Optional<Employee> employee = employeeDAO.finfByName(name);
        if (employee.isPresent()) {
            Employee employee1 = employee.get();

            return Optional.of(employee1);

        } else {


            return Optional.empty();
        }


    }
}
