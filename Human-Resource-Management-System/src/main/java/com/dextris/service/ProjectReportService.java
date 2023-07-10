package com.dextris.service;

import com.dextris.entity.ProjectReport;

import java.util.List;

public interface ProjectReportService {


    public ProjectReport validateAndAdd(ProjectReport projectReport);

   default List<ProjectReport> validateAndGetAll(){
        return  null;
    }
}
