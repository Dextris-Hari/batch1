package com.xworkz.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "car")
@NamedQueries({ @NamedQuery(name = "find", query = " select info from CarDTO info") ,
	@NamedQuery(name = "findByName", query = "select info from CarDTO info where info.name=:nm")})
public class CarDTO implements Serializable {
	@Id
	@GenericGenerator(name = "m", strategy = "increment")
	@GeneratedValue(generator = "m")
	private Integer id;
	private String name;
	public CarDTO() {
		System.out.println(" nanu cardto  created"+this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}
		
		
		
	

}
