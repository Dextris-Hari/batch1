package com.xworkz.car.dao;

import java.util.List;

import com.xworkz.dto.CarDTO;

public interface CarDAO {
	boolean save(CarDTO dto);

	List<CarDTO> readAll();
	List<CarDTO> readByName(String Name);

}
