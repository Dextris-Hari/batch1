package com.xworkz.mobile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.mobile.dao.MobileDAO;
import com.xworkz.mobile.entity.MobileEntity;

@Component
public class MobileServiceImpl implements MobileService {
	public MobileServiceImpl(MobileDAO dao) {
		super();
		this.dao = dao;
		System.out.println();
	}

	@Autowired
	private MobileDAO dao;

	@Override
	public boolean validateAndSave(MobileEntity entity) {
		dao.save(entity);
		return true;
	}

}
