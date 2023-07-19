package com.xworkz.filmservice;

import com.xworkz.filmdao.FilmDAO;
import com.xworkz.filmentity.FilmEntity;

public interface FilmService {
	boolean validAndSave(FilmEntity entity);

}
