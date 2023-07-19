package com.manoj.departmentservice.entity;

public record Employee(Long id ,Long departmentId,String name,int age,String position) {
    //default final and give only getter and all arg constructor
}
