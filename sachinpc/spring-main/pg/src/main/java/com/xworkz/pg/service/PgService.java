package com.xworkz.pg.service;

import java.util.List;

import javax.xml.crypto.dsig.keyinfo.PGPData;

import com.xworkz.pg.dto.PgDTO;

public interface PgService {
	boolean vallidateAndSave(PgDTO dto);
	List<PgDTO> validateAndReadAll();
	List<PgDTO> validateAndReadByName(String name);

}
