package com.dextris.transaction.controller;

import com.dextris.transaction.service.EmployeeService;
import com.dextris.transaction.vo.EmployeeRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
@PostMapping("/employee")
    public  String saveEmployee(@RequestBody EmployeeRequestVO vo){


return  employeeService.saveEmployee(vo);
    }
}
