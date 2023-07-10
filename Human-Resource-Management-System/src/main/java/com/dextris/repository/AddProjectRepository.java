package com.dextris.repository;

import com.dextris.entity.AddProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddProjectRepository extends JpaRepository<AddProject, String> {

}
