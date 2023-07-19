package com.xworkz.car.service;

import java.util.List;

import com.xworkz.dto.CarDTO;

public interface CarService {
	boolean validateAndSave(CarDTO dto);

	List<CarDTO> validateAndReadAll();
	List<CarDTO> validateReadByName(String Name);


}
