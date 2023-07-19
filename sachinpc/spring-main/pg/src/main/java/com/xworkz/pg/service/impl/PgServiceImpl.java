package com.xworkz.pg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.pg.dao.PgDAO;
import com.xworkz.pg.dto.PgDTO;
import com.xworkz.pg.service.PgService;

@Service
public class PgServiceImpl implements PgService {
	@Autowired
	private PgDAO dao;
	public PgServiceImpl() {
		System.out.println(" nanu service impl"+this.getClass().getSimpleName());
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean vallidateAndSave(PgDTO dto) {
		System.out.println(" nanu service impl method");
		dao.save(dto);
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<PgDTO> validateAndReadAll() {
		//dao.readAll();
		System.out.println(" service method");
		// TODO Auto-generated method stub
		return dao.readAll();
	}
	@Override
	public List<PgDTO> validateAndReadByName(String name) {
		return dao.readByName(name);
	}
	

}
