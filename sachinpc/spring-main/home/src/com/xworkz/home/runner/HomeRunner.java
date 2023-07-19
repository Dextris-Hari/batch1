package com.xworkz.home.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.xworkz.home.dao.HomeDAOImpl;
import com.xworkz.home.entity.HomeEntity;

public class HomeRunner {
	public static void main(String[] args) {
		HomeEntity entity = new HomeEntity(1, "bangara", "manoj", "building", 3, 5);
		HomeEntity entity1 = new HomeEntity(2, "singara", "mangya", "ret", 3, 5);
		HomeEntity entity2 = new HomeEntity(3, "sothya", "ragu", "but", 3, 5);
		HomeEntity entity3= new HomeEntity(4, "baaa", "ragju", "sot", 3, 5);
		HomeDAOImpl impl = new HomeDAOImpl();
		 Boolean save = impl.save(entity);
			/*
			 * // System.out.println(save); Optional<HomeEntity> findById =
			 * impl.findById(1); if (findById.isPresent()) {
			 * 
			 * HomeEntity entity4= findById.get(); System.out.println("fount" + " " +
			 * entity2); } else { System.out.println("not found"); findById.empty(); }
			 * 
			 * 
			 * Optional<HomeEntity> updateById = impl.updateById(1, "jayaram"); if
			 * (updateById.isPresent()) {
			 * 
			 * System.out.println("record is updated"); HomeEntity homeEntity =
			 * updateById.get(); System.out.println(homeEntity); } else {
			 * System.out.println(); updateById.isEmpty(); }
			 * 
			 * 
			 * impl.delete(1);
			 */
		
		 List<HomeEntity> list = new ArrayList<>();
		
		
		boolean add = list.add(entity1);
		
	
		list.add(entity2);
		list.add(entity3);
		impl.save(list);
	}
	
	

}
