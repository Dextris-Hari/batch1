package com.xworkz.hotel.dto;

import java.io.Serializable;

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
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "hotel_details")
@NamedQueries({ @NamedQuery(name = "find", query = "select info from HotelDTO info"),
	@NamedQuery(name = "findByName", query = "select info from HotelDTO info where info.name=:nm")})
public class HotelDTO implements Serializable {
	@Id
	@GenericGenerator(name = "man", strategy = "increment")
	@GeneratedValue(generator = "man")
	private Integer id;
	private String name;

	public HotelDTO() {
		System.out.println(" hoteldto class is created " + this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}

}
