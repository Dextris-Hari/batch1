package com.dextris.service.impl;

import com.dextris.entity.LeaveReport;
import com.dextris.repository.LeaveReportRepository;
import com.dextris.service.LeaveReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveReportServiceImpl implements LeaveReportService {
    @Autowired
    private LeaveReportRepository leaveRepository;
    @Override
    public LeaveReport saveLeaveReport(LeaveReport leaveReport) {
        return leaveRepository.save(leaveReport);

    }

    @Override
    public List<LeaveReport> getAllLeaveReports() {
        return leaveRepository.findAll();
    }
}
