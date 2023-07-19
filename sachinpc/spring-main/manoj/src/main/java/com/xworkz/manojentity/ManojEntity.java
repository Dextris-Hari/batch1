package com.xworkz.manojentity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="manoj")
public class ManojEntity implements Serializable {
	@Id
	private Integer id;
	private String name;
	private String father;
	private String mather;
	public ManojEntity(Integer id, String name, String father, String mather) {
		super();
		this.id = id;
		this.name = name;
		this.father = father;
		this.mather = mather;
	}
	@Override
	public String toString() {
		return "ManojEntity [id=" + id + ", name=" + name + ", father=" + father + ", mather=" + mather + "]";
	}
	
	

}
