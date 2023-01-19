package org.example.dao;

import org.example.entity.Employee;

import java.util.List;
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

    default Optional<Employee> findByName(String name) {


        return Optional.empty();
    }

    default List<Employee> findAll() {


        return null;
    }

    default Optional<Employee> updateByName(String name, String mobile, String dob) {


        return Optional.empty();
    }
    default  Optional<String> deleteByName(String name){



        return Optional.empty();
    }
}
