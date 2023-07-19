package com.xworkz.kalyandemo.repo;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.kalyandemo.entity.KalyanEntity;

@Repository
public class KalyanRepositoryImpl implements KalyanRepository {
	@Autowired
	private EntityManagerFactory factory;

	@Override
	public Boolean save(KalyanEntity entity) {
		System.out.println("manoj");
		return true;
	}

}
