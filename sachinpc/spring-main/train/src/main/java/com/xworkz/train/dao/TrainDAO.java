package com.xworkz.train.dao;

import java.util.List;

import com.xworkz.train.dto.TrainDTO;

public interface TrainDAO {

	boolean save(TrainDTO dto);
 List<TrainDTO> readAll();
 List<TrainDTO> readByName(String trainName);
}
