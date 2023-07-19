package com.xworkz.pg.dao;

import java.util.List;

import com.xworkz.pg.dto.PgDTO;

public interface PgDAO {
	boolean save(PgDTO dto);
	List<PgDTO> readAll();
	List<PgDTO> readByName(String name);

}
