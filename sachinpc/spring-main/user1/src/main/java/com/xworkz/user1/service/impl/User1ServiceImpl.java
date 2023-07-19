package com.xworkz.user1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.user1.dao.User1DAO;
import com.xworkz.user1.entity.User1;
import com.xworkz.user1.service.User1Service;

@Service
public class User1ServiceImpl implements User1Service {
	@Autowired
	private User1DAO user1dao;

	public User1ServiceImpl() {
		super();
		System.out.println(" service is created");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean validateAndSave(User1 user1) {
		return this.user1dao.save(user1);
	}

}
