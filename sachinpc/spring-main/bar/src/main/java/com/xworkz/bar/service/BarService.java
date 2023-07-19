package com.xworkz.bar.service;

import java.util.List;

import com.xworkz.bar.dto.BarDTO;

public interface BarService {
	boolean validateAndSave(BarDTO dto);
	List<BarDTO> validateAndReadAll();
	List<BarDTO> validateReadAll(String name);

}
