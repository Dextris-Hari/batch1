package com.xworkz.filmserviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.filmdao.FilmDAO;
import com.xworkz.filmentity.FilmEntity;
import com.xworkz.filmservice.FilmService;
@Component
public class FilmServiceImpl implements FilmService {
	@Autowired
private FilmDAO dao;
	@Override
	public boolean validAndSave(FilmEntity entity) {
		dao.save(entity);
		return true;
	}


	
}
