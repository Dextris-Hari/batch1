package com.xworkz.cinimacom.xworkz.cinimaserviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.cinimacom.xworkz.cinimadao.CinimaDAO;
import com.xworkz.cinimacom.xworkz.cinimaentity.CinimaEntity;
import com.xworkz.cinimacom.xworkz.cinimaservice.CinimaService;

@Component

public class CinimaServiceImpl implements CinimaService {
	@Autowired
	CinimaDAO dao;

	public CinimaServiceImpl() {
		System.out.println(" serviceimpl is created");
	}

	public boolean validateAndSave(CinimaEntity entity) {
		dao.save(entity);
		return true;
	}

}
