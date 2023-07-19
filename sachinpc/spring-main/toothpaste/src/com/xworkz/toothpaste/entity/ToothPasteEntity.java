package com.xworkz.toothpaste.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "toothpaste_details")

public class ToothPasteEntity {
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Override
	public String toString() {
		return "ToothPasteEntity [id=" + id + ", name=" + name + ", brand=" + brand + ", companyName=" + companyName
				+ "]";
	}
	public ToothPasteEntity(Integer id, String name, String brand, String companyName) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.companyName = companyName;
	}
	public ToothPasteEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	private Integer id;
	private String name;
	private String brand;
	private String companyName;

}
