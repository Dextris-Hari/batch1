package com.xworkz.train.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.xworkz.train.dao.TrainDAO;
import com.xworkz.train.dto.TrainDTO;
import com.xworkz.train.service.TrainService;

@Service
@Component
public class TrainServiceImpl implements TrainService {
	@Autowired
	private TrainDAO dao;

	public TrainServiceImpl() {
		System.out.println("TrainServiceImpl is created " + this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validateAndSave(TrainDTO dto) {
		System.out.println("nanu validateandsave method hen evaga");
		dao.save(dto);

		return true;
	}

	@Override
	public List<TrainDTO> validateReadAll() {
		// TODO Auto-generated method stub
		return dao.readAll();
	}

	@Override
	public List<TrainDTO> validateReadByName(String trainName) {
		// TODO Auto-generated method stub
		return dao.readByName(trainName);
	}

}
