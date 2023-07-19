package com.xworkz.train.service;

import java.util.List;

import com.xworkz.train.dto.TrainDTO;

public interface TrainService {

	boolean validateAndSave(TrainDTO dto);
	List<TrainDTO> validateReadAll();
	 List<TrainDTO> validateReadByName(String trainName);

}
