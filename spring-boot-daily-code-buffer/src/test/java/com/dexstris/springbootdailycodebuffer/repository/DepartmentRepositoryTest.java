package com.dexstris.springbootdailycodebuffer.repository;

import com.dexstris.springbootdailycodebuffer.entity.DepartmentEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private  DepartmentRepository departmentRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        DepartmentEntity departmentEntity= DepartmentEntity.builder().departmentAdress("manoj").build();
        testEntityManager.persist(departmentEntity);
    }
    @Test
@DisplayName("by id method is successfull")
    public  void whenFindById_ThenReturnDepartmentEntity(){
DepartmentEntity departmentEntity=departmentRepository.findById(1L).get();
assertEquals(departmentEntity.getDepartmentAdress(),"manoj");


    }
}