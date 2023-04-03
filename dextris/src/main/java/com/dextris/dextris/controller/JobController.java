package com.dextris.dextris.controller;

import com.dextris.dextris.entity.Job;
import com.dextris.dextris.service.impl.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {
    @Autowired
    private JobService jobService;


    @PostMapping("/job/add")
    public Job addNewJob(@RequestBody Job job) {
        System.out.println("78521236");
        return jobService.addNeWJob(job);


    }
}
