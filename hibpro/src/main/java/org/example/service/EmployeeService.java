package org.example.service;

import org.example.entity.Employee;

import java.util.List;
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
    default List<Employee> validateFindAll() {


        return null;
    }
    default Optional<Employee> validateUpdateByName(String name, String mobile, String dob) {


        return Optional.empty();
    }
    default  Optional<String> validateDeleteByName(String name){



        return Optional.empty();
    }


}
