package com.interview.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {


    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    Employee(int id, String name) {

        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Employee employee
                = new Employee(1, "manoj");
        Employee employee1 = new Employee(2, "jayanth");
        Employee employee2 = new Employee(3, "jyothi");
        List<Employee> list = new ArrayList();

        list.add(employee);
        list.add(employee1);
        list.add(employee2);


      List<Employee> list1=  list.stream().sorted(Comparator.comparingInt(Employee::getId)).collect(Collectors.toList());
        System.out.println(list1);


    }
}
