package com.xworkz.aeroplane.dao;

import java.util.List;

import com.xworkz.aeroplane.dto.AeroplaneDTO;

public interface AeroplainDAO {

	String save(AeroplaneDTO dto);
	List<AeroplaneDTO> readAll();
	List<AeroplaneDTO> readByName(String name);
    
}
