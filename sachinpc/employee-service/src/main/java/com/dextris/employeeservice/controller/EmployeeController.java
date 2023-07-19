package com.dextris.employeeservice.controller;

import com.dextris.employeeservice.entity.Employee;
import com.dextris.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    private final static Logger LOGGER= LoggerFactory.getLogger(EmployeeController.class);

@PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
    LOGGER.info("employee is added: " ,employee);
        return  employeeRepository.addEmployee(employee);
    }
    @GetMapping
    public List<Employee> getAll( ){
        LOGGER.info(" all employee : ");
        return  employeeRepository.getAll();
    }
    @GetMapping("/{id}")
    public Employee getAll( @PathVariable Long id){
        LOGGER.info("  employee  by id: ",id);
        return  employeeRepository.getById(id);
    }

    @GetMapping("/department/{id}")
    public List<Employee> getAllByDepartmentId(@PathVariable Long id ){
        LOGGER.info(" all employee by Department : ",id);
        return  employeeRepository.getByDepartmenId(id);
    }
}
