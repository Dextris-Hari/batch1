package com.dexstris.springbootdailycodebuffer.service;

import com.dexstris.springbootdailycodebuffer.entity.DepartmentEntity;
import com.dexstris.springbootdailycodebuffer.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private  DepartmentService service;
    @MockBean
    private DepartmentRepository departmentRepository;



    @BeforeEach
    void setUp() {
        DepartmentEntity departmentEntity= DepartmentEntity.builder().departmentAdress("mysore").build();
        Mockito.when(departmentRepository.getByDepartmentAdressIgnoreCase("mysore")).thenReturn(departmentEntity);
    }
    @Test
    @DisplayName("get data by name method is successusful")
    public  void whenValidDepartmentName_ThanDepartmentFound(){
String departmentAddress="mysore";
        DepartmentEntity found=service.getByName(departmentAddress);


    assertEquals(departmentAddress,found.getDepartmentAdress());
    }

}