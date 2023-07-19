package com.xworkz.milkshop.dao;

import java.util.List;

import com.xworkz.milkshop.dto.MilkShopDTO;

public interface MilkShopDAO {
	boolean save(MilkShopDTO dto);
	List<MilkShopDTO> readAll();
	List<MilkShopDTO> readByName(String name);

}
