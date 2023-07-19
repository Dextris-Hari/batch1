package com.xworkz.football;

public class Football {
	private String name;
	private String brand;

	public Football(String name, String brand) {
		super();
		this.name = name;
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Football [name=" + name + ", brand=" + brand + "]";
	}

}
