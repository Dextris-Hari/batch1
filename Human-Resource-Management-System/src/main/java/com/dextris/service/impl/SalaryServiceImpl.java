package com.dextris.service.impl;

import com.dextris.entity.Salary;
import com.dextris.repository.SalaryRepository;
import com.dextris.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryRepository salaryRepository;
    @Override
    public Salary validateAndSaveSallary(Salary salary) {
        return salaryRepository.save(salary);
    }

    @Override
    public List<Salary> validateAndGetAll() {

     return    salaryRepository.findAll();
    }
}
