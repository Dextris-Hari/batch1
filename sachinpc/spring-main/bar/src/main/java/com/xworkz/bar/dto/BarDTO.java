package com.xworkz.bar.dto;

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

@AllArgsConstructor
@Setter
@Getter
//@NoArgsConstructor
@ToString
@Entity
@Table(name = "bar_details")
@NamedQueries({@NamedQuery(name = "findAll",query = "select info from BarDTO info "),
	@NamedQuery(name = "findByName",query = "select info from BarDTO info where info.name=:nm")})
public class BarDTO implements Serializable {

	public BarDTO() {
		System.out.println("bardto is created :" + this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}

	@Id
	@GenericGenerator(name = "man", strategy = "increment")
	@GeneratedValue(generator = "man")
	private Integer id;
	private String name;

}
