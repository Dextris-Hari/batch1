package com.xworkz.film;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xworkz.filmentity.FilmEntity;
import com.xworkz.filmservice.FilmService;
import com.xworkz.filmserviceimpl.FilmServiceImpl;

public class FilmRunner {
	public static void main(String[] args) {
		FilmEntity filmEntity = new FilmEntity(1, "hudugaru");
		 FilmEntity filmEntity2 = new FilmEntity(2,"chakrayuva");
		 AnnotationConfigApplicationContext context = 
				 new AnnotationConfigApplicationContext("com.xworkz");
		 FilmServiceImpl bean = context.getBean(FilmServiceImpl.class);
		 boolean b = bean.validAndSave(filmEntity2);
		 boolean c = bean.validAndSave(filmEntity);
		 System.out.println(b+" "+c);
	}

}
