package com.dextris.service;

import com.dextris.entity.Salary;

import java.util.List;

public interface SalaryService {


    public Salary validateAndSaveSallary(Salary salary);

  default   List<Salary> validateAndGetAll(){

     return  null;
    }
}
