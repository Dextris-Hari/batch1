package com.xworkz.mobile.service;

import com.xworkz.mobile.dao.MobileDAO;
import com.xworkz.mobile.entity.MobileEntity;

public interface MobileService {
	
	boolean validateAndSave(MobileEntity entity);

}
