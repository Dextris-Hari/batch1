package com.dextris.controller;

import com.dextris.entity.ProjectReport;
import com.dextris.entity.Salary;
import com.dextris.service.ProjectReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projectreport")
public class ProjectReportController {
    @Autowired
    private ProjectReportService projectReportService;

    @PostMapping("/addprojectreport")//tested and found ok
    @PreAuthorize("hasRole('User')")

    public ProjectReport addProjectReport(@RequestBody ProjectReport projectReport) {


        return projectReportService.validateAndAdd(projectReport);
    }

    @GetMapping("/allprojectreport")// tested and found ok
    @PreAuthorize("hasRole('Admin')")

    public List<ProjectReport> getAllProjectReport() {


        return projectReportService.validateAndGetAll();
    }
}
