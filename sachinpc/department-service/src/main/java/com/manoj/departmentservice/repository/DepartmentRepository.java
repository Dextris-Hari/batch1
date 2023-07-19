package com.manoj.departmentservice.repository;

import com.manoj.departmentservice.entity.Deportment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {


    private List<Deportment> departments= new ArrayList<>();


    public  Deportment addDepaertment(Deportment deportment){

        departments.add(deportment);
        return deportment;
    }
    public Deportment getDepartmentById(Long id){


        return  departments.stream().filter(deportment -> deportment.getDepartmentId().equals(id)).findFirst()
                .orElseThrow();
    }

    public  List<Deportment> getAll(){

        return  departments;
    }
}
