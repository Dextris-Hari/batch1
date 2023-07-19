package com.xworkz.lap.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "lap_details")
public class LapEntity {
	@Id
	@GenericGenerator(name = "m", strategy = "increment")
	@GeneratedValue(generator = "m")
	private Integer id;
	private String name;
	private String fileName;
	
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "LapEntity [id=" + id + ", name=" + name + ", fileName=" + fileName + "]";
	}
	public LapEntity(Integer id, String name, String fileName) {
		super();
		this.id = id;
		this.name = name;
		this.fileName = fileName;
	}
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
	public LapEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
