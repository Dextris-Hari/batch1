package com.xworkz.aeroplane.dto;

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
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "aeroplane_info")
@NamedQueries({@NamedQuery(name = "find",query = "select info from AeroplaneDTO info "),
	@NamedQuery(name = "findByName",query = "select info from AeroplaneDTO info where info.name=:nm")})
public class AeroplaneDTO {
	public AeroplaneDTO() {
		System.out.println("nanu DTO" + this.getClass().getSimpleName());
	}

	
	@Id
	@GenericGenerator(name = "man", strategy = "increment")
	@GeneratedValue(generator = "man")
	private Integer id;
	private String name;
	private String type;
	private String image;

}
