package org.example.dao;

import org.example.entity.Employee;

public interface EmployeeDAO {

    Boolean Save(Employee employee);

    Employee getEmployeeById(int id);

    Employee updateNameById(int id, String name);

    Employee deleteEmployeeById(int id);



}
