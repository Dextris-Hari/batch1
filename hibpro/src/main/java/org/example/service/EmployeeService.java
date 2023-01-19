package org.example.service;

import org.example.entity.Employee;

public interface EmployeeService {

    Boolean validateAndSave(Employee employee);

    Employee validateAndGetEmployeeById(int id);

    Employee validateAndUpdateNameById(int id , String name);

    Employee validateAndDeleteEmployeeById(int id);

}
