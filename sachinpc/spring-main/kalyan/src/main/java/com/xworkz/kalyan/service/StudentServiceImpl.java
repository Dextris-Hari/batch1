package com.xworkz.kalyan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.kalyan.entity.Student;
import com.xworkz.kalyan.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public boolean validateAndsave(Student student) {
		
		return studentRepository.save(student);
	}

}
