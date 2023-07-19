package com.xworkz.toothpaste.dao;

import java.util.Optional;

import com.xworkz.toothpaste.entity.ToothPasteEntity;

public interface ToothPasteDAO {
	Boolean save(ToothPasteEntity paste);

	default Optional<ToothPasteEntity> findById(Integer id) {

		return Optional.empty();
	}

}
