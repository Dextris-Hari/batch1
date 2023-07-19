package com.dextris.controller;

import com.dextris.entity.AddProject;
import com.dextris.entity.Salary;
import com.dextris.service.AddProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class AddProjectController {
    @Autowired
    private AddProjectService addProjectService;

    @PostMapping("/addproject")// tested and working fine

    @PreAuthorize("hasRole('Admin')")
    public AddProject addProject(@RequestBody AddProject addProject){
        return addProjectService.validateAndProject(addProject);
    }

    @GetMapping("/allproject")// tested and working fine
    @PreAuthorize("hasRole('Admin')")

    public List<AddProject> getAllProjects( ) {


        return addProjectService.validateAndGetAllProject();
    }

    @GetMapping("/getbyname/{name}")//tested and found ok
    @PreAuthorize(("hasRole('User')"))
    public AddProject getByName(@PathVariable String name){

        System.out.println("barthide");

        return addProjectService.validateAndGetByName(name).orElse(null);
    }



}
