package com.xworkz.car.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.car.dao.CarDAO;
import com.xworkz.car.service.CarService;
import com.xworkz.dto.CarDTO;

@Service
public class CarServiceImpl implements CarService {
	@Autowired
	private CarDAO dao;

	public CarServiceImpl() {
		System.out.println(" nanu impl service");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validateAndSave(CarDTO dto) {
		dao.save(dto);
		return true;
	}

	@Override
	public List<CarDTO> validateAndReadAll() {
		return dao.readAll();
	}

	@Override
	public List<CarDTO> validateReadByName(String Name) {
		// TODO Auto-generated method stub
		return dao.readByName(Name);
	}

}
