package com.dextris.service.impl;

import com.dextris.entity.ProjectReport;
import com.dextris.repository.ProjectReportRepository;
import com.dextris.service.ProjectReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectReportServiceImpl implements ProjectReportService {
    @Autowired
    private ProjectReportRepository projectReportRepository;
    @Override
    public ProjectReport validateAndAdd(ProjectReport projectReport) {
        return projectReportRepository.save(projectReport);
    }

    @Override
    public List<ProjectReport> validateAndGetAll() {
        return projectReportRepository.findAll();
    }
}
