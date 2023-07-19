package com.manoj.departmentservice.controller;

import com.manoj.departmentservice.client.EmployeeClient;
import com.manoj.departmentservice.entity.Deportment;
import com.manoj.departmentservice.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired

    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeClient employeeClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping
    public Deportment addDepartment(@RequestBody Deportment deportment) {

        LOGGER.info("add department", deportment);

        return departmentRepository.addDepaertment(deportment);
    }

    @GetMapping
    public List<Deportment> getAll() {
        LOGGER.info("get all department");


        return departmentRepository.getAll();
    }

    @GetMapping("/{id}")
    public Deportment getById(@PathVariable Long id) {
        LOGGER.info("get by id  department", id);


        return departmentRepository.getDepartmentById(id);
    }
@GetMapping("/dep")
    public List<Deportment> getAllDepartmentWithEmployee() {
        LOGGER.info("get by all department with emplyee");

        List<Deportment> deportment = departmentRepository.getAll();
        deportment
                .forEach(dep -> dep.setEmployees(employeeClient.getAllByDepartmentId(dep.getDepartmentId())));
        return deportment;
    }

}
