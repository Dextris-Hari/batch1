package com.xworkz.criminals.dao;

import java.util.List;

import com.xworkz.criminals.dto.CriminalsDTO;


public interface CriminalsRepository {
	boolean save(CriminalsDTO dto);
	List<CriminalsDTO> readAll();
	List<CriminalsDTO> findByName(String name);

}
