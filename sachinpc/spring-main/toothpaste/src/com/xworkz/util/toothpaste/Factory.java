package com.xworkz.util.toothpaste;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Factory {

	private final static EntityManagerFactory factory;

	public final static EntityManagerFactory getFactory() {
		return factory;
	}

	static {

		factory = Persistence.createEntityManagerFactory("com.xworkz");
	}

}
