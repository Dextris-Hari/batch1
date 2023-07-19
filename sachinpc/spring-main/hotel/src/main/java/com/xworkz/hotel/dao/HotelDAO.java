package com.xworkz.hotel.dao;

import java.util.List;

import com.xworkz.hotel.dto.HotelDTO;

public interface HotelDAO {
	boolean save(HotelDTO dto);
	List<HotelDTO> readAll();
	List<HotelDTO> readByName(String name);

}
