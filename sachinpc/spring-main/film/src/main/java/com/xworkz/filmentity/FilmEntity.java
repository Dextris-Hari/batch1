package com.xworkz.filmentity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="film_inf")
public class FilmEntity {
	@Id
	private int id;
	private String name;
	public FilmEntity(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	

}
