package com.xworkz.criminals.service;

import java.util.List;

import com.xworkz.criminals.dto.CriminalsDTO;

public interface CriminalsService {
	boolean validateAndSave(CriminalsDTO dto);
    List<CriminalsDTO> validateAndReadAll();
    List<CriminalsDTO> findByName(String name);
}
