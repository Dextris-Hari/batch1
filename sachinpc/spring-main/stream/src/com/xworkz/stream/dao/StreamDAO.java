package com.xworkz.stream.dao;

import java.util.Optional;

import com.xworkz.stream.entity.StreamEntity;

public interface StreamDAO {

	Optional<Boolean> save(StreamEntity entity);
	Optional<StreamEntity> findByKey(int id);

}
