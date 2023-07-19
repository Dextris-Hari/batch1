package com.xworkz.aeroplane.service;

import java.util.List;

import com.xworkz.aeroplane.dto.AeroplaneDTO;

public interface AeroplainService {
	boolean validateAndSave(AeroplaneDTO dto);
    List<AeroplaneDTO> validateAndSave();
    List<AeroplaneDTO> validateAndReadByName(String Name);
}
