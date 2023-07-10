package com.dextris.service;

import com.dextris.entity.AddProject;
import com.dextris.entity.Salary;

import java.util.List;
import java.util.Optional;

public interface AddProjectService {

    public AddProject validateAndProject(AddProject addProject);

    default List<AddProject> validateAndGetAllProject() {

        return null;
    }

    default Optional<AddProject> validateAndGetByName(String name) {
        return Optional.empty();

    }
}
