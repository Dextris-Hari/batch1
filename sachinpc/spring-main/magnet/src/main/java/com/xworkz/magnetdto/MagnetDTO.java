package com.xworkz.magnetdto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "magnet")
public class MagnetDTO {
	@Id
	@GenericGenerator(name = "m", strategy = "increment")
	@GeneratedValue(generator = "m")
	private Integer id;
	private String name;
	@Override
	public String toString() {
		return "MagnetDTO [id=" + id + ", name=" + name + "]";
	}
	public MagnetDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MagnetDTO(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	

}
