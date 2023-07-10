package com.dextris.controller;

import com.dextris.entity.Salary;
import com.dextris.repository.SalaryRepository;
import com.dextris.service.SalaryService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class SalaryController {
    @Autowired
    private SalaryService service;


    @GetMapping("/getbyname/{name}")
    @PreAuthorize(("hasRole('User')"))
    public Salary getByName(@PathVariable String name){

        System.out.println("barthide");

        return service.validateAndGetByName(name).orElse(null);
    }

    @PostMapping("/addSalary")
    @PreAuthorize("hasRole('Admin')")

    public Salary addSalary(@RequestBody Salary salary) {


        return service.validateAndSaveSallary(salary);
    }
    @GetMapping("/allSalary")
    @PreAuthorize("hasRole('Admin')")

    public List<Salary> getAllSalaryDetails( ) {


        return service.validateAndGetAll();
    }
}
