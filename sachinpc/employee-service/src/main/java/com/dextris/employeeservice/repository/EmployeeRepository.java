package com.dextris.employeeservice.repository;

import com.dextris.employeeservice.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {


    private List<Employee> employees= new ArrayList<>();

    public Employee addEmployee(Employee employee){
        employees.add(employee);
        return  employee;

    }
    public  Employee getById(Long id){


       return employees.stream().filter(a->a.id().equals(id)).findFirst().orElseThrow();
    }
    public  List<Employee> getAll(){


        return  employees;
    }
    public List<Employee> getByDepartmenId(Long id){

        return employees.stream()
                .filter(emp->emp.departmentId().equals(id)).toList();
    }
}
