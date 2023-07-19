package com.xworkz.pg.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.xworkz.pg.controller.PgController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "pg_details")
@NamedQueries({@NamedQuery(name = "find", query = "select info from PgDTO info"),
	@NamedQuery(name = "findByName", query = "select info from PgDTO info where info.name=:nm")})
public class PgDTO implements Serializable {
	@Id
	@GenericGenerator(name = "m", strategy = "increment")
	@GeneratedValue(generator = "m")
	private Integer id;
	private String name;
	private String fileName;
	

	public PgDTO()  {
		System.out.println(" nanu pg dto " + this.getClass().getSimpleName());
		
		
		
	
	}

}
