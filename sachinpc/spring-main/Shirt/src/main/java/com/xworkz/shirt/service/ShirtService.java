package com.xworkz.shirt.service;

import java.util.List;

import com.xworkz.shirt.dto.ShirtDTO;

public interface ShirtService {
	boolean validateAndSave(ShirtDTO dto);
	List<ShirtDTO> validateAndReadAll();
	List<ShirtDTO> validateAndreadByBrand(String brand);
}
