package com.xworkz.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.hotel.dao.HotelDAO;
import com.xworkz.hotel.dto.HotelDTO;
import com.xworkz.hotel.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelDAO dao;

	public HotelServiceImpl() {
		System.out.println(" HotedServiceImpl is created " + this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validateAndSave(HotelDTO dto) {
		System.out.println(" method");
		if (dto.getName().length() > 3) {
			dao.save(dto);
		}
		System.out.println(" u r name is not saved");
		return false;
	}

	@Override
	public List<HotelDTO> validateAndReadAll() {

		// TODO Auto-generated method stub
		return dao.readAll();
	}

	@Override
	public List<HotelDTO> validateAndReadByName(String name) {
		// TODO Auto-generated method stub
		return dao.readByName(name);
	}

}
