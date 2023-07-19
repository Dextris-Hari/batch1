package com.xworkz.aeroplane.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.aeroplane.dao.AeroplainDAO;
import com.xworkz.aeroplane.dto.AeroplaneDTO;

@Service
public class AeroplainServiceImpl  implements  AeroplainService{
	@Autowired
	private AeroplainDAO dao;

	@Override
	public boolean validateAndSave(AeroplaneDTO dto) {
		
		dao.save(dto);
		
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<AeroplaneDTO> validateAndSave() {
		return dao.readAll();
	}

	@Override
	public List<AeroplaneDTO> validateAndReadByName(String Name) {
		// TODO Auto-generated method stub
		return dao.readByName(Name);
	}
	
	

}
