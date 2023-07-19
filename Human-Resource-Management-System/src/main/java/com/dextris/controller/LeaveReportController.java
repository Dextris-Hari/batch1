package com.dextris.controller;

import com.dextris.entity.LeaveReport;
import com.dextris.service.LeaveReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LeaveReportController {
    @Autowired
    private LeaveReportService leaveReportService;
    @PostMapping("/addleavereport")
    @PreAuthorize("hasRole('User')")
    public LeaveReport addLeave(@RequestBody LeaveReport leaveReport){
        return leaveReportService.saveLeaveReport(leaveReport);
    }
    @GetMapping("/allleavereports")
    @PreAuthorize("hasRole('Admin')")
    public List<LeaveReport> getAllLeaveReport(){
        return leaveReportService.getAllLeaveReports();

    }
}
