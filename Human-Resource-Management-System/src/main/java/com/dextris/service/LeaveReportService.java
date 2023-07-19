package com.dextris.service;

import com.dextris.entity.LeaveReport;

import java.util.List;

public interface LeaveReportService {

    public LeaveReport saveLeaveReport(LeaveReport leaveReport);

    default List<LeaveReport> getAllLeaveReports(){
        return null;
    }

}
