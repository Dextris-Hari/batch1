package com.xworkz.tv;

public class Stand {
	private String name;
	private Double price;

	@Override
	public String toString() {
		return "Stand [name=" + name + ", price=" + price + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Stand(String name, Double price) {
		super();
		this.name = name;
		this.price = price;
	}

}
