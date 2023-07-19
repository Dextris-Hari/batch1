package com.xworkz.milkshop.service;

import java.util.List;

import com.xworkz.milkshop.dto.MilkShopDTO;

public interface MilkShopService {
	boolean validateAndSave(MilkShopDTO dto);
	List<MilkShopDTO> readAll();
	List<MilkShopDTO> readByName(String name);

}
