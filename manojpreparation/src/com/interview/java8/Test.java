package com.interview.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        List<Employee>  employeeList=  new ArrayList();
        employeeList.add(new Employee(1,1,"m"));
        employeeList.add(new Employee(1,1,"manoj"));
        employeeList.add(new Employee(2,2,"anaga"));

        employeeList.add(new Employee(3,1,"ananda"));


        List<Department> departmentList = new ArrayList<Department>();
        departmentList.add(new Department(1,"civil"));
        departmentList.add(new Department(2,"mech"));
        departmentList.add(new Department(3,"cs"));

        // i want department name where   employee name start with A

  List list= employeeList.stream()
           .filter(emp->emp.getName().toLowerCase().startsWith("a"))
           .map(emp->departmentList.stream().filter(dep->
                   dep.getDepartmentId()==emp.getDepartmentId())
                   .findFirst().map(Department::getDepartmentName)
                   .orElse("")).collect(Collectors.toList());
      //
        System.out.println(list);
// i need map
        Map<String,String> stringStringMap=employeeList.stream()
                .filter(emp->emp.getName().toLowerCase().startsWith("a"))
                .collect(Collectors.toMap(emp->emp.getName(),emp->departmentList.stream()
                        .filter(dep->dep.getDepartmentId()==emp.getDepartmentId())
                        .findFirst().map(Department::getDepartmentName).orElse("")));
        System.out.println(stringStringMap);
        // count of employee
      Map<Integer, String>  map= departmentList.stream()
                .collect(Collectors.toMap(dep->dep.getDepartmentId(),Department::getDepartmentName));


      Map<String ,Long > stringLongMap= employeeList.stream()
              .collect(Collectors.groupingBy(emp->map.get(emp.getDepartmentId()),   Collectors.counting()));
        System.out.println(stringLongMap);

 employeeList.stream().filter(emp->emp.getName().toLowerCase().startsWith("a"))
         .map(Employee::getName).collect(Collectors.toList());
    }
}
