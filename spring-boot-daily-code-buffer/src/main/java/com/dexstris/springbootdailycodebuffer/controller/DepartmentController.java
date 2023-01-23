package com.dexstris.springbootdailycodebuffer.controller;

import com.dexstris.springbootdailycodebuffer.entity.DepartmentEntity;
import com.dexstris.springbootdailycodebuffer.exception.DepartmentEntityNotFoundException;
import com.dexstris.springbootdailycodebuffer.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
public class DepartmentController {
    private DepartmentService service;
    private final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class);

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public DepartmentEntity post(@Valid @RequestBody DepartmentEntity entity){

LOGGER.info("inside the save method");

        return service.validateAndSave(entity);
    }
    @GetMapping("getall")
    public List<DepartmentEntity> getAll(){

        System.out.println("manoj");

        return  service.findAll();
    }
    @GetMapping("/get/{id}")
    public  DepartmentEntity getById(@PathVariable("id") Long id) throws DepartmentEntityNotFoundException {



        return  service.getByID(id);
    }
    @DeleteMapping("{id}")
    public  String delete(@PathVariable Long id){
        service.delete(id);

        return "deleted";
    }
    @PutMapping("{id}")
    public  DepartmentEntity update(@PathVariable Long id, @RequestBody DepartmentEntity entity){



        return service.update(id,entity);
    }
    @GetMapping("/name/{name}")
    public  DepartmentEntity getByName(@PathVariable String name){



        return  service.getByName(name);
    }
}
