package com.dextris.transaction.service;

import com.dextris.transaction.entity.Department;
import com.dextris.transaction.entity.Employee;
import com.dextris.transaction.repository.DepartmentRepository;
import com.dextris.transaction.repository.EmployeeRepository;
import com.dextris.transaction.vo.EmployeeRequestVO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
@Transactional
    public String saveEmployee(EmployeeRequestVO vo) {
        Department department= new Department();
        department.setDepartmentCode(vo.getDepartmentName());
        department.setDepartmentName(vo.getDepartmentName());
      Long departmentId=  departmentRepository.save(department).getDepartmentId();

        Employee employee=null; //new Employee();
        employee.setName(vo.getEmployeeName());
        employee.setEmail(vo.getEmail());
        employee.setDepartmentId(departmentId);
        employeeRepository.save(employee);
        return  "employee is saved with employeeId:"+employee.getEmployeeId();

    }
}
