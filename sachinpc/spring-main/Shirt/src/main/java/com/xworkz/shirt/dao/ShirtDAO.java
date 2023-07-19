package com.xworkz.shirt.dao;

import java.util.List;

import com.xworkz.shirt.dto.ShirtDTO;

public interface ShirtDAO {
	boolean save(ShirtDTO dto);
	List<ShirtDTO> readAll();
	List<ShirtDTO> readByBrand(String brand);
	

}
