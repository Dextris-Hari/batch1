package com.xworkz.tv;

public class TV {
	private String brand;
	private String color;
	private Double price;
	private Dispaly dispaly;
	private Remote remote;
	private SetupBox setupBox;
	private Stand stand;

	public TV() {
		System.out.println(this.getClass().getSimpleName() + "Tv bean is created");

	}

	@Override
	public String toString() {
		return "TV [brand=" + brand + ", color=" + color + ", price=" + price + ", dispaly=" + dispaly + ", remote="
				+ remote + ", setupBox=" + setupBox + ", stand=" + stand + "]";
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Dispaly getDispaly() {
		return dispaly;
	}

	public void setDispaly(Dispaly dispaly) {
		this.dispaly = dispaly;
	}

	public Remote getRemote() {
		return remote;
	}

	public void setRemote(Remote remote) {
		this.remote = remote;
	}

	public SetupBox getSetupBox() {
		return setupBox;
	}

	public void setSetupBox(SetupBox setupBox) {
		this.setupBox = setupBox;
	}

	public Stand getStand() {
		return stand;
	}

	public void setStand(Stand stand) {
		this.stand = stand;
	}

	public TV(String brand, String color, Double price, Dispaly dispaly, Remote remote, SetupBox setupBox,
			Stand stand) {
		super();
		this.brand = brand;
		this.color = color;
		this.price = price;
		this.dispaly = dispaly;
		this.remote = remote;
		this.setupBox = setupBox;
		this.stand = stand;
	}

}
