package com.xworkz.hotel.service;

import java.util.List;

import com.xworkz.hotel.dto.HotelDTO;

public interface HotelService {

	boolean validateAndSave(HotelDTO dto);
	List<HotelDTO> validateAndReadAll();
	List<HotelDTO> validateAndReadByName(String name);

}
