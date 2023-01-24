package org.example.service.impl;

import org.example.dao.EmployeeDAO;
import org.example.dao.impl.EmployeeDAOImpl;
import org.example.entity.Employee;
import org.example.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public Boolean validateAndSave(Employee employee) {
        if (employee.getName().length() < 20) {
            return employeeDAO.Save(employee);
        }
        return false;
    }

    @Override
    public Employee validateAndGetEmployeeById(int id) {

        Employee employee = employeeDAO.getEmployeeById(id);
        if (employee != null) {
            return employee;

        } else {
            System.out.println("----There is no data available for this ID---");
            return null;
        }
    }

    @Override
    public Employee validateAndUpdateNameById(int id, String name) {

        if (name.length() < 20) {
            Employee employee = employeeDAO.updateNameById(id, name);

            return employee;
        } else {
            System.out.println("-----U cant update Name By using this ID-----");
            return null;
        }
    }

    @Override
    public Employee validateAndDeleteEmployeeById(int id) {

        Employee employee = employeeDAO.deleteEmployeeById(id);

        return employee;
    }
}
