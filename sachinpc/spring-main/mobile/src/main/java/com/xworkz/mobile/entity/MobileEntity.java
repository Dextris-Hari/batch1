package com.xworkz.mobile.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jaya")
public class MobileEntity {
	@Id
	private int id;
	private String brand;
	private double version;
	private String createdBy;
	private String updatedBy;
	private LocalDate createDate;
	private LocalDate updateDate;

	public MobileEntity(int id, String brand, double version, String createdBy, String updatedBy, LocalDate createDate,
			LocalDate updateDate) {
		super();
		this.id = id;
		this.brand = brand;
		this.version = version;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getVersion() {
		return version;
	}

	public void setVersion(double version) {
		this.version = version;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "MobileEntity [id=" + id + ", brand=" + brand + ", version=" + version + ", createdBy=" + createdBy
				+ ", updatedBy=" + updatedBy + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}

}
