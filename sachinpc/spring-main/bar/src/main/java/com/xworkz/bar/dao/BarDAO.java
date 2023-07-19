package com.xworkz.bar.dao;

import java.util.List;

import com.xworkz.bar.dto.BarDTO;

public interface BarDAO {
	boolean collect(BarDTO dto);
	List<BarDTO> readAll();
	List<BarDTO> readAll(String name);

}
