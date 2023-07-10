package com.dextris.service.impl;

import com.dextris.entity.AddProject;
import com.dextris.repository.AddProjectRepository;
import com.dextris.service.AddProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddProjectServiceImpl implements AddProjectService {
    @Autowired
    private AddProjectRepository addProjectRepository;


    @Override
    public AddProject validateAndProject(AddProject addProject) {
   List list= new ArrayList();

        return addProjectRepository.save(addProject);
    }

    @Override
    public List<AddProject> validateAndGetAllProject() {
        return  addProjectRepository.findAll();
    }

    @Override
    public Optional<AddProject> validateAndGetByName(String name) {
        return addProjectRepository.findById(name);
    }
}
