package org.example.dao;

import org.example.entity.Employee;

import java.util.Optional;

public interface EmployeeDAO {


    Boolean save(Employee employee);

    default Optional<Employee> getEmployeeById(Integer id) {


        return Optional.empty();

    }

    default Optional<Employee> updateNameById(Integer id, String name) {


        return Optional.empty();
    }

    default Optional<Employee> deleteEmployeeById(Integer id) {
        return Optional.empty();
    }

    default Optional<Employee> finfByName(String name) {


        return Optional.empty();
    }
}
