package com.xworkz.foodandmusic.dto;

import java.io.Serializable;

public class FoodDTO  implements Serializable{
	private String name;
	private int price;
	private String hotelName;
	private String type;
	private String location;
	private String order;
	private int quantity;
	public FoodDTO() {
		System.out.println("DTOcreated "+ this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "FoodDTO [name=" + name + ", price=" + price + ", hotelName=" + hotelName + ", type=" + type
				+ ", location=" + location + ", order=" + order + ", quantity=" + quantity + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
