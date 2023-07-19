package com.xworkz.home.dao;



import java.util.List;
import java.util.Optional;

import com.xworkz.home.entity.HomeEntity;


public interface HomeDAO {

	Boolean save(HomeEntity entity);

	default Optional<HomeEntity> findById(int id) {

		return Optional.empty();
	}

	default Optional<HomeEntity> updateById(int id, String owner) {

		return Optional.empty();

	}

	default void delete(int id) {

	}

	default boolean save(List<HomeEntity> entity) {

		return false;
	}
}
