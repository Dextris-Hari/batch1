package com.dexstris.springbootdailycodebuffer.controller;

import com.dexstris.springbootdailycodebuffer.entity.DepartmentEntity;
import com.dexstris.springbootdailycodebuffer.exception.DepartmentEntityNotFoundException;
import com.dexstris.springbootdailycodebuffer.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartmentService service;
    private DepartmentEntity departmentEntity;

    @BeforeEach
    void setUp() {

        departmentEntity=DepartmentEntity.builder().departmentAdress("manya").id(1l).build();
    }

    @Test
    void post() throws Exception {
        DepartmentEntity inputDepartmentEntity1= DepartmentEntity.builder().departmentAdress("manya").build();
        Mockito.when(service.validateAndSave(inputDepartmentEntity1)).thenReturn(departmentEntity);
        mockMvc.perform(MockMvcRequestBuilders.post("/save").contentType(MediaType.APPLICATION_JSON).content("{\n" +
                "\"departmentAdress\":\"manya\"\n" +
                "\n" +
                "}")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("successfull for get by id in controller")
    void getById() throws Exception {

        Mockito.when(service.getByID(1l)).thenReturn(departmentEntity);
        mockMvc.perform(MockMvcRequestBuilders.get("/get/1").contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.jsonPath("$.departmentAdress").value(departmentEntity.getDepartmentAdress()));
    }
}