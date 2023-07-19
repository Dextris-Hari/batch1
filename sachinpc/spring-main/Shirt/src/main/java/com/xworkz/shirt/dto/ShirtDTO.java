package com.xworkz.shirt.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "shirt_details")
@NamedQueries({@NamedQuery(name = "findAll",query = "select info from ShirtDTO info"),
	@NamedQuery(name = "findByName", query = " select info from ShirtDTO info where info.brand=:br")})
public class ShirtDTO {
	public ShirtDTO() {
		
		System.out.println(" nanu ShirtDTO "+this.getClass().getSimpleName());
		
		// TODO Auto-generated constructor stub
	}
	@Id
	@GenericGenerator(name = "man",strategy = "increment")
	@GeneratedValue(generator = "man")
	private Integer id;
	private String brand;
	private String size;
	private Double prize;
	private String discount;
	private String quantity;
	private String gender;
	private String color;

}
