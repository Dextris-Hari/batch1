package com.xworkz.manojserviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.manojdao.ManojDAO;
import com.xworkz.manojentity.ManojEntity;
import com.xworkz.manojservice.ManojService;
@Component
public class ManojServiceImpl implements ManojService {
	@Autowired
	ManojDAO dao;

	public boolean validAndSave(ManojEntity entity) {
		dao.save(entity);

		return false;
	}

}
