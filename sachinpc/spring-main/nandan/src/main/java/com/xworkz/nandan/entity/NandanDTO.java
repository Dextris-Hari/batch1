package com.xworkz.nandan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "nandan")
public class NandanDTO {
	@Id
	@GenericGenerator(name = "m", strategy  = "increment")
	@GeneratedValue(generator = "m")
	private Integer id;
	private String name;
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
	public NandanDTO(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "NandanDTO [id=" + id + ", name=" + name + "]";
	}
	public NandanDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
