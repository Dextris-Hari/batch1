package com.xworkz.laptop;

public class LapTop {
	private String name;
	private String brand;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Override
	public String toString() {
		return "LapTop [name=" + name + ", brand=" + brand + "]";
	}
	

}
