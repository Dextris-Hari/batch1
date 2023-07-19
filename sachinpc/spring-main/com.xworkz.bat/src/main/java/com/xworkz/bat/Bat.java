package com.xworkz.bat;

public class Bat {
	public Bat(String name, String brand) {
		super();
		this.name = name;
		this.brand = brand;
	}

	private String name;
	private String brand;

	@Override
	public String toString() {
		return "Bat [name=" + name + ", brand=" + brand + "]";
	}

}
