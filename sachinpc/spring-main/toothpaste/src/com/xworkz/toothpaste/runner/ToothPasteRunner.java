package com.xworkz.toothpaste.runner;

import java.util.Optional;

import com.xworkz.toothpaste.dao.ToothPasteDAO;
import com.xworkz.toothpaste.dao.ToothPasteDAOImpl;
import com.xworkz.toothpaste.entity.ToothPasteEntity;

public class ToothPasteRunner {

	public static void main(String[] args) {
		ToothPasteEntity entity = new ToothPasteEntity(1, "colgate", "thaja", "tooth company");
		ToothPasteEntity entity2 = new ToothPasteEntity(1, "colgate", "thaja", "tooth company");
		ToothPasteEntity entity3 = new ToothPasteEntity(1, "colgate", "thaja", "tooth company");
		ToothPasteEntity entity4 = new ToothPasteEntity(1, "colgate", "thaja", "tooth company");
		ToothPasteDAO impl = new ToothPasteDAOImpl();
		 Boolean save = impl.save(entity2);
		 System.out.println(save);
		Optional<ToothPasteEntity> findById = impl.findById(1);
		System.out.println("manoj3");
		if (findById.isPresent()) {

			System.out.println(" fount " + " " + findById);
		} else {

			System.out.println(" not found");
		}

	}

}
