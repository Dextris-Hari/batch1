package com.xworkz.bus.dao;

import java.util.List;

import com.xworkz.bus.dto.BusDTO;

public interface BusDAO {

	boolean collect(BusDTO dto);
  List<BusDTO> readAll();
  List<BusDTO> readAll(String name);
  

}
