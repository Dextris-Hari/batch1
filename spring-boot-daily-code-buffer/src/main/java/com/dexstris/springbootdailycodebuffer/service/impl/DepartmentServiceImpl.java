package com.dexstris.springbootdailycodebuffer.service.impl;

import com.dexstris.springbootdailycodebuffer.entity.DepartmentEntity;
import com.dexstris.springbootdailycodebuffer.exception.DepartmentEntityNotFoundException;
import com.dexstris.springbootdailycodebuffer.repository.DepartmentRepository;
import com.dexstris.springbootdailycodebuffer.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentEntity validateAndSave(DepartmentEntity entity) {


        return departmentRepository.save(entity);
    }

    @Override
    public List<DepartmentEntity> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public DepartmentEntity getByID(Long id) throws DepartmentEntityNotFoundException {
        Optional<DepartmentEntity> departmentEntity= departmentRepository.findById(id);
        if(!departmentEntity.isPresent()){


           throw  new DepartmentEntityNotFoundException("department not available");
        }
        return departmentEntity.get();
    }

    @Override
    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public DepartmentEntity update(Long id, DepartmentEntity entity) {

        DepartmentEntity departmentEntity = departmentRepository.findById(id).get();
        if(Objects.nonNull(entity.getDepartmentAdress())&&!"".equalsIgnoreCase(entity.getDepartmentAdress())){


            departmentEntity.setDepartmentAdress(entity.getDepartmentAdress());
        }


        return departmentRepository.save(departmentEntity);
    }

    @Override
    public DepartmentEntity getByName(String name) {
        return departmentRepository.getByDepartmentAdressIgnoreCase(name);
    }

}
