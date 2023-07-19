package org.example.service;

import org.example.entity.Employee;

import java.util.Optional;

public interface EmployeeService {

    Boolean validateAndSave(Employee employee);

    default Optional<Employee> validateAndGetEmployeeById(Integer id) {


        return null;
    }

    default Optional<Employee> validateAndUpdateNameById(Integer id, String name) {


        return Optional.empty();
    }

    default Optional<Employee> validateAndDeleteEmployeeById(Integer id) {


        return Optional.empty();
    }

    default Optional<Employee> validateAndFindByName(String name) {


        return Optional.empty();
    }


}
