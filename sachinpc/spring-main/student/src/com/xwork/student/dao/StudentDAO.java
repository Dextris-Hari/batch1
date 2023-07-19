package com.xwork.student.dao;

import java.util.Optional;

import com.xwork.student.StudentEntity;

public interface StudentDAO {
	boolean save(StudentEntity entity);

	default Optional<StudentEntity> findById(Integer id) {
//
		return Optional.empty();
		

	}

}
