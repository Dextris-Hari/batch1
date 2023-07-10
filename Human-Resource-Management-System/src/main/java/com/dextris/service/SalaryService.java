package com.dextris.service;

import com.dextris.entity.Salary;

import java.util.List;
import java.util.Optional;

public interface SalaryService {


    public Salary validateAndSaveSallary(Salary salary);

    default List<Salary> validateAndGetAll() {

        return null;
    }

    default Optional<Salary> validateAndGetByName(String name) {

        return null;

    }
}
