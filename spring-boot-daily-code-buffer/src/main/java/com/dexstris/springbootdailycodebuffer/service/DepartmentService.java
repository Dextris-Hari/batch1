package com.dexstris.springbootdailycodebuffer.service;

import com.dexstris.springbootdailycodebuffer.entity.DepartmentEntity;
import com.dexstris.springbootdailycodebuffer.exception.DepartmentEntityNotFoundException;

import java.util.List;

public interface DepartmentService {

    DepartmentEntity validateAndSave(DepartmentEntity entity);


    List<DepartmentEntity> findAll();

    DepartmentEntity getByID(Long id) throws DepartmentEntityNotFoundException;

    void delete(Long id);

    DepartmentEntity update(Long id, DepartmentEntity entity);

    DepartmentEntity getByName(String name);
}
